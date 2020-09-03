import React, { Component } from 'react';
import axios from '../../../axios-orders';
import Input from '../../../components/UI/Input/Input';
import Spinner from '../../UI/Spinner/Spinner';
import classes from './RFS.css';
// import classes from '../../ParticipantForm/ParticipantFormStates/PFS.css';

class RFS extends Component {
    state = {
        referrerForm: {
            // test: null,
            firstName: {
                elementType: 'input',
                label: 'First Name',
                elementConfig: {
                    type: 'text',
                    placeholder:'First Name'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },

            lastName: {
                elementType: 'input',
                label: 'Last Name',
                elementConfig: {
                    type: 'text',
                    placeholder:'Last Name'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },

            email: {
                elementType: 'input',
                label: 'Email Address',
                elementConfig: {
                    type: 'email',
                    placeholder: 'Email'
                },
                value: '',
                validation: {
                    required: true,
                    minLength: 3,
                    maxLength: 45,
                },
                valid: false,
                touched: false
            },

            phone: {
                elementType: 'input',
                label: 'Phone Number',
                elementConfig: {
                    type: 'digits',
                    placeholder: 'Numbers'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },

            city: {
                elementType: 'input',
                label: 'City',
                elementConfig: {
                    type: 'text',
                    placeholder: 'City'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },

            referTo: {
                elementType: 'input',
                label: 'What company are currently work for and be able to refer to?',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Company'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },

            referTo: {
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
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },

            bestCommunication: {
                elementType: 'input',
                label: 'What is the best way to communicate with you? We understand and respect your value of time. Some of our referrers prefer emails, phone call, or appointments. Please specify.',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Company'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },

            feedbackSection: {
                elementType: 'input',
                label: 'You are almost at the end! We want to remind you that you are an awesome human of MITPU. From your previous experience, do you have any feedback on our program? We would love to improve attempt to help our members.',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Company'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },

            visaSection: {
                elementType: 'input',
                label: 'Do you know if your employer requires certain work authorization? Please answer in details if possible. Many of our participants are on F1 Student Visa and H1B.',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Visa'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },
        },
        formIsValid: false,
        loading: false,
    };

    checkValidity(value, rules) {
        let isValid = true;
        if (rules.required) {
            isValid = value.trim() !== '' && isValid;
        }

        if (rules.minLength) {
            isValid = value.length >= rules.minLength && isValid
        }

        if (rules.maxLength) {
            isValid = value.length <= rules.maxLength && isValid
        }
        return isValid
    }

    submitHandler = (event) => {
        event.preventDefault();
        this.setState({ loading: true });
        const formData = {};
        for (let formElementIdentifier in this.state.referrerForm) {
            // Set a key and value
            formData[formElementIdentifier] = this.state.referrerForm[formElementIdentifier].value;
        }
        console.log(formData)
        const referrerForm = {

            myData: formData
        }
        axios.post('/', referrerForm)
            .then(response => {
                this.setState({ loading: false });
                console.log(response);
            })
            .catch(error => {
                this.setState({ loading: false });
            });
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
        updatedFormElement.valid = this.checkValidity(updatedFormElement.value, updatedFormElement.validation);
        updatedFormElement.touched = true;
        updatedReferrerForm[inputIdentifier] = updatedFormElement;
        this.setState({ referrerForm: updatedReferrerForm });
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
                        label={formElement.config.label}
                        invalid={!formElement.config.valid}
                        shouldValidate={formElement.config.validation}
                        touched={formElement.config.touched}
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
                <p>Welcome to the Referral Program from MITPU! Your support to MITPU Community helps hundreds of Mongolian job seekers. The first step is to fill this form to join our referrer community.</p>
            {form}
            </div>    
        );
    }
}    

export default RFS