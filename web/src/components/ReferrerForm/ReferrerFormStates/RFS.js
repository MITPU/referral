import React, { Component } from 'react';
import axios from '../../../axios-orders';
import Input from '../../../components/UI/Input/Input';
import Spinner from '../../UI/Spinner/Spinner';
import classes from '../../ParticipantForm/ParticipantFormStates/PFS.css';

class RFS extends Component {
    state = {
        referrerForm: {
            email: {
                elementType: 'input',
                label: 'Your E-Mail',
                elementConfig: {
                    type: 'email',
                    placeholder: 'Your E-Mail'
                },
                value: ''
            },
            name: {
                elementType: 'input',
                label: 'Your Name',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Your Name'
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
            howYouHelp: {
                elementType: 'select',
                label: 'How can you help Referral Participants beside referring? Please check the boxes that applies to you.',
                elementConfig: {
                    options: [
                        {value: 'resumereview', displayValue: 'Resume review'},
                        {value: 'informationalVideoConference/PhoneCallWithPotentialCandidates', displayValue: 'Informational Video conference/Phone call with potential candidates'},
                        {value: 'intervievPreparation', displayValue: 'Interview Preparation'},
                        {value: 'attendMITPUin-personEvents', displayValue: 'Attend MITPU in-person events'}
                    ]
                },
                value: ''
            }
        },
        loading: false,
 };

    submitHandler = (event) => {
        event.preventDefault();
        this.setState( { loading: true } );
        const formData = {};
        for (let formElementIdentifier in this.state.referrerForm) {
            // Set a key and value
            formData[formElementIdentifier] = this.state.referrerForm[formElementIdentifier].value;
        }
        const rf = {
            referrer: formData
        }
        axios.post( '/referrer.json', rf )
            .then( response => {
                this.setState( { loading: false } );
                console.log(response);
            } )
            .catch( error => {
                this.setState( { loading: false } );
            } );
    }

    inputChangedHandler = (event, inputIdentifier) => {
        // Creating a copy of referrerForm
         const updatedReferrerForm = {
             ...this.state.referrerForm
         };
         // Accessing value of referrerForm
         const updatedFormElement = { 
             ...updatedReferrerForm[inputIdentifier]
         };
         updatedFormElement.value = event.target.value;
         updatedReferrerForm[inputIdentifier] = updatedFormElement;
         this.setState({referrerForm: updatedReferrerForm});
    }

    render() {
        const formElementsArray = [];
        for (let key in this.state.referrerForm) {
            formElementsArray.push({
                id: key,
                config: this.state.referrerForm[key]
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
                <h1>Referrer Form</h1>
                <p>Welcome to the Referral Program from MITPU! Your support to MITPU Community helps hundreds of Mongolian job seekers. 
        The first step is to fill this form to join our referrer community.</p>
            {form}
            </div>    
        );
    }
}    

export default RFS