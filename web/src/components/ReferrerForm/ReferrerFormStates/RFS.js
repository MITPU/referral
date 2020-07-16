import React, { Component } from 'react';
import PropTypes from 'prop-types';

import { FormGroup, InputGroup } from "@blueprintjs/core";

class RFS extends Component {
    state = {
        email: '',
        name: '',
    }
    render() {

        let aForm = null;
        switch (this.props.type) {
            case ('email'):
                aForm = <FormGroup
                    label="Email"
                    labelFor="text-input"
                    labelInfo="(required)" 
                    inline={true} >
                    <InputGroup id="text-input" placeholder="Placeholder text" />
                </FormGroup>
                break;
            case ('greetings'):
                aForm = <FormGroup
                    label="What's your full name? (First name, Last Name) "
                    labelFor="text-input"
                    labelInfo="(required)"
                    inline={true}>
                    <InputGroup id="text-input" placeholder="Placeholder text" />
                </FormGroup>
                break;
            default:
                aForm = null;
        }
        return aForm;
    };
}
RFS.propTypes = {
    type: PropTypes.string.isRequired
};

export default RFS