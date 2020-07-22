import React, { Component } from 'react';
import axios from '../../../axios-orders';
import Input from '../../../components/UI/Input/Input';
import Spinner from '../../UI/Spinner/Spinner';
import classes from './PFS.css';

class PFS extends Component {
    state = {
        participantForm: {
            email: {
                elementType: 'input',
                label: 'Email Address',
                elementConfig: {
                    type: 'email',
                    placeholder: 'Email Address'
                },
                value: ''
            },
            name: {
                elementType: 'input',
                label: 'What is your full name? (First name, Last Name)',
                elementConfig: {
                    type: 'text',
                    placeholder:'What is your full name? (First name, Last Name)'
                },
                value: ''
            },
            location: {
                elementType: 'input',
                label: 'Where are you located?',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Where are you located?'
                },
                value: ''
            },
            company: {
                elementType: 'input',
                label: 'What company are currently work for and be able to refer to?',
                elementConfig: {
                    type: 'text',
                    placeholder: 'What company are currently work for and be able to refer to?'
                },
                value: ''
            },
        },
        loading: false,
 };

    submitHandler = (event) => {
        event.preventDefault();
        this.setState( { loading: true } );
        const formData = {};
        for (let formElementIdentifier in this.state.participantForm) {
            // Set a key and value
            formData[formElementIdentifier] = this.state.participantForm[formElementIdentifier].value;
        }
        const participant = {
            myData: formData
        }
        axios.post( '/participant.json', participant )
            .then( response => {
                this.setState( { loading: false } );
                console.log(response);
            } )
            .catch( error => {
                this.setState( { loading: false } );
            } );
    }

    inputChangedHandler = (event, inputIdentifier) => {
        // Creating a copy of participantForm
         const updatedParticipantForm = {
             ...this.state.participantForm
         };
         // Accessing value of participantForm
         const updatedFormElement = { 
             ...updatedParticipantForm[inputIdentifier]
         };
         updatedFormElement.value = event.target.value;
         updatedParticipantForm[inputIdentifier] = updatedFormElement;
         this.setState({participantForm: updatedParticipantForm});
    }

    render() {
        const formElementsArray = [];
        for (let key in this.state.participantForm) {
            formElementsArray.push({
                id: key,
                config: this.state.participantForm[key]
            });
        }
        let form = (
            <form onSubmit={this.submitHandler}>
                {formElementsArray.map(formElement => (
                    <Input 
                        key={formElement.id}
                        elementType={formElement.config.elementType}
                        elementConfig={formElement.config.elementConfig}
                        value={formElement.config.value}
                        changed={(event) => this.inputChangedHandler(event, formElement.id)} />
                ))}
                <button className={classes.FormButton}>Submit</button>
            </form>
        );
        if ( this.state.loading ) {
            form = <Spinner />;
        }

        return (
            <div>
                <h1>Participant Form</h1>
                <p>Welcome to Referral Program! Our mission is to help you find the best position</p>
                {form}
            </div>
        );
    }
}
export default PFS