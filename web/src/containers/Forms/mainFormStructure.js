import React, { Component } from 'react';
import Aux from '../../hoc/Auxiliary';
import Participant from '../../components/ParticipantForm/ParticipantForm';
import Referrer from '../../components/ReferrerForm/ReferrerForm';
import { Route, Switch } from 'react-router-dom';


class FormBuilder extends Component {
    render () {
        return(
            <div>
                <Aux>
                    <Switch>
                        <Route path="/referrer" component={Referrer} />
                        <Route path="/" component={Participant} />
                    </Switch>
                </Aux>
            </div>
        );
    }
}

export default FormBuilder;
