import React, { Component } from 'react';
import axios from '../../../axios-orders';

import { FormGroup, InputGroup } from "@blueprintjs/core";

class PFS extends Component {
    state = {
        email: '',
        name: '',
    }

    submitHandler = (event) => {
        event.preventDefault();
        const aForm = {
            // myState = this.state.email,
            // myName = this.state.name,
            customer: {
                email: 'erdete01@luther.edu',
                name: 'Temuulen Erdenebulgan'
            }
        }
        axios.post( '/referral.json', aForm)
            .then(response => console.log(response))
            .catch(error => console.log(error));
    }

    render() {
        return (
            <div>
                <h1>Participant Form</h1>
                <p>Welcome to Referral Program! Our mission is to help you find the best position</p>
                <FormGroup
                    label="Email"
                    labelFor="text-input"
                    labelInfo="(required)"
                    inline={true} >
                    <InputGroup id="text-input" placeholder="Placeholder text" />
                </FormGroup>
                <FormGroup
                    label="Hello! It's nice to e-meet you. What's your name? (First name, Last name)"
                    labelFor="text-input"
                    labelInfo="(required)"
                    inline={true}>
                    <InputGroup id="text-input" placeholder="Placeholder text" />
                </FormGroup>
                <button clicked={this.submitHandler}>Submit</button>
            </div>
        );
    }
}
export default PFS

//         let aForm = null;
//         switch (this.props.type) {
//             case ('email'):
//                 aForm = <FormGroup
//                     label="Email"
//                     labelFor="text-input"
//                     labelInfo="(required)"
//                     inline={true} >
//                     <InputGroup id="text-input" placeholder="Placeholder text" />
//                 </FormGroup>
//                 break;
//             case ('greetings'):
//                 aForm = <FormGroup
//                     label="Hello! It's nice to e-meet you. What's your name? (First name, Last name)"
//                     labelFor="text-input"
//                     labelInfo="(required)"
//                     inline={true}>
//                     <InputGroup id="text-input" placeholder="Placeholder text" />
//                 </FormGroup>
//                 break;
//             default:
//                 aForm = null;
//         }
//         return aForm;
//     };
// }
// PFS.propTypes = {
//     type: PropTypes.string.isRequired
// };
