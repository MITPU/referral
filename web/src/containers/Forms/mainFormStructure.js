import React, { Component } from 'react';
import Aux from '../../hoc/Auxiliary';
import Participant from '../../components/ParticipantForm/ParticipantForm';
import Referrer from '../../components/ReferrerForm/ReferrerForm';
import Admin from '../../components/Admin/Admin';
import { Route, Switch } from 'react-router-dom';
import { connect } from 'react-redux';
import {fetchCOMPANIES} from '../../store/actions';
import {fetchSKILLS} from '../../store/actions';

class FormBuilder extends Component {

    state = {
        companyNames: [],
        skills: []
    }

    componentDidMount() {
        const { dispatch } = this.props
        dispatch(fetchCOMPANIES())
        dispatch(fetchSKILLS())
    };

    render () {
        return(
            <div>
                <Aux>
                    <Switch>
                        <Route path="/referrer" component={Referrer} />
                        <Route path="/admin" component={Admin} />
                        <Route path="/" render={() => (<Participant 
                            companyName={this.props.companyNames}
                            companySkill={this.props.skills}  />)} /> 
                        <Route path="/login" />
                    </Switch>
                </Aux>
            </div>
        );
    }
}
const mapStateToProps = state => {
    return {
        companyNames: state.companyNames,
        skills: state.skills
    };
};

export default connect(mapStateToProps)(FormBuilder);
