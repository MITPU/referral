import React, { Component } from 'react';
import Participant from '../../components/ParticipantForm/ParticipantForm';
import Referrer from '../../components/ReferrerForm/ReferrerForm';
import { Route, Switch } from 'react-router-dom';


class FormBuilder extends Component {
    render() {
        return (
            <div>

                <Switch>
                    <Route path="/referrer" component={Referrer} />
                    <Route path="/" component={Participant} />
                </Switch>
            </div>
        );
    }
}

export default FormBuilder;
