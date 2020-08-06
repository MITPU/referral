import React, { Component } from 'react';
import axios from '../../../axios-orders';
import Input from '../../../components/UI/Input/Input';
import Spinner from '../../UI/Spinner/Spinner';
import classes from '../../ParticipantForm/ParticipantFormStates/PFS.css';

class RFS extends Component {
    state = {
        referrerForm: {
            // test: null
            email: {
                elementType: 'input',
                label: 'Your E-Mail',
                elementConfig: {
                    type: 'email',
                    placeholder: 'E-Mail'
                },
                value: ''
            },
            firstName: {
                elementType: 'input',
                label: 'First Name',
                elementConfig: {
                    type: 'text',
                    placeholder: 'First name'
                },
                value: ''
            },
            lastName: {
                elementType: 'input',
                label: 'Last Name',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Last name'
                },
                value: ''
            },
            phoneNumber: {
                elementType: 'input',
                label: 'Phone Number',
                elementConfig: {
                    type: 'tel',
                    placeholder: 'Number',
                    pattern: "[0-9]{3}-[0-9]{2}-[0-9]{3}",
                    maxlength: "12",
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
            referTo: {
                elementType: 'input',
                label: 'What company are currently work for and be able to refer to?',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Company Name'
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
            },
            bestCommunication: {
                elementType: 'input',
                label: 'What is the best way to communicate with you? We understand and respect your value of time. Some of our referrers prefer emails, phone call, or appointments. Please specify.',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Communication'
                },
                value: ''
            },
            feedbackSection: {
                elementType: 'input',
                label: 'You are almost at the end! We want to remind you that you are an awesome human of MITPU. From your previous experience, do you have any feedback on our program? We would love to improve attempt to help our members.',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Feedback'
                },
                value: ''
            },
            visaSection: {
                elementType: 'input',
                label: 'Do you know if your employer requires certain work authorization? Please answer in details if possible. Many of our participants are on F1 Student Visa and H1B.',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Visa'
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

    // componentDidMount () {
    //     axios.get('https://referral-3ffeb.firebaseio.com/test.json');
    //           .then(response => {
    //             this.setState({test: response.data});
    //           });
    // }

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
                        label={formElement.config.label}
                        changed={(event) => this.inputChangedHandler(event, formElement.id)} />
                ))}
                <button className={classes.FormButton}>Submit</button>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            </form>
        );
        if ( this.state.loading ) {
            form = <Spinner />;
        }
        return (
            <div>
                <h1>Referrer Form</h1>
                <p>Welcome to the Referral Program from MITPU! Your support to MITPU Community helps hundreds of Mongolian job seekers. The first step is to fill this form to join our referrer community.</p>
            {form}
            </div>    
        );
    }
}    

export default RFS