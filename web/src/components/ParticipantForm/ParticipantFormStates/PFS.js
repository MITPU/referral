import React, { Component } from 'react';
import axios from '../../../axios-orders';
import Input from '../../../components/UI/Input/Input';
import Spinner from '../../UI/Spinner/Spinner';
import classes from './PFS.css';
import ReactMultiSelectCheckboxes from 'react-multiselect-checkboxes';
import { Multiselect } from 'multiselect-react-dropdown';

class PFS extends Component {
    state = {
        companyNameAPI: [],
        candidateSkills: [],
        participantForm: {
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
            firstName: {
                elementType: 'input',
                label: 'First Name',
                elementConfig: {
                    type: 'text',
                    placeholder: 'First Name'
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
                    placeholder: 'Last Name'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },
            location: {
                elementType: 'input',
                label: 'Where are you located?',
                elementConfig: {
                    type: 'text',
                    placeholder: 'Location'
                },
                value: '',
                validation: {
                    required: true
                },
                valid: false,
                touched: false
            },
            phone: {
                elementType: 'input',
                label: 'What is your phone number',
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
            resume: {
                elementType: 'input',
                label: 'Please upload your most recent resume here.',
                elementConfig: {
                    type: 'file',
                    name: 'filename'
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
        for (let formElementIdentifier in this.state.participantForm) {
            // Set a key and value
            formData[formElementIdentifier] = this.state.participantForm[formElementIdentifier].value;
        }
        const participant = {
            myData: formData
        }
        axios.post('/', participant)
            .then(response => {
                this.setState({ loading: false });
                console.log(response);
            })
            .catch(error => {
                this.setState({ loading: false });
            });
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
        updatedFormElement.valid = this.checkValidity(updatedFormElement.value, updatedFormElement.validation);
        updatedFormElement.touched = true;
        updatedParticipantForm[inputIdentifier] = updatedFormElement;
        this.setState({ participantForm: updatedParticipantForm });
    }

    getDropdownButtonLabel = (event) => {
        this.setState({ companyNameAPI: event }
            );
    };

    // constructor helps to define state when calling the function onSelect
    constructor() {
        super();
        this.state.candidateSkills = [],
        this.onSelect = this.onSelect.bind(this);
    }

    onSelect = (selectedItem) => {
        this.setState({
            candidateSkills: selectedItem }
            );
    };

    render() {
    
        const formElementsArray = [];
        const companyNameList = [];

        for (let key in this.state.participantForm) {
            formElementsArray.push({
                id: key,
                config: this.state.participantForm[key]
            });
        }

        for (let key in this.props.companyNames) {
            try {
                companyNameList.push({
                    id: key,
                    config: this.props.companyNames[key]
                });
            } catch (e) {
                break
            }
        }
        // Changing companyNames
        let options = []
        if (this.props.companyNames) {
            options = Object.entries(this.props.companyNames).map(company => {
                return (
                    { label: company[1].name, value: company[1].name }
                );
            });
        }
        // Changing CompanySkills
        let skills = []
        if (this.props.candidateSkills) {
            skills = Object.entries(this.props.candidateSkills).map(skill => {
                return (
                    { name: skill[1].skill}
                );
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
        if (this.state.loading) {
            form = <Spinner />;
        }
        return (
            <div>
                <h1>Participant Form</h1>
                <p>Welcome to Referral Program! Our mission is to help you find the best position</p>
                <p>Please choose 3 company names</p>
                <ReactMultiSelectCheckboxes 
                    options={options} 
                    onChange={this.getDropdownButtonLabel} />
                <Multiselect
                    options={skills} 
                    selectedValues={this.state.selectedValue} 
                    onSelect={this.onSelect} 
                    onRemove={this.onRemove} 
                    displayValue="name" 
                    />    
                {form}
            </div>
        );
    }
}
export default PFS
