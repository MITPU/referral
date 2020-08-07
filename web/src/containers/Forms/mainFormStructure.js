import React, { Component } from 'react';
import Aux from '../../hoc/Auxiliary';
import Participant from '../../components/ParticipantForm/ParticipantForm';
import Referrer from '../../components/ReferrerForm/ReferrerForm';
import Admin from '../../components/Admin/Admin';
import { Route, Switch } from 'react-router-dom';
import { connect } from 'react-redux';
<<<<<<< HEAD
import { fetchCOMPANIES } from '../../store/actions';
=======
import {fetchCOMPANIES} from '../../store/actions';
>>>>>>> e00fc49... Having problem setting mystate in Reducer.js

class FormBuilder extends Component {

    state = {
        companyNames: []
    }

    componentDidMount() {
        const { dispatch } = this.props
        dispatch(fetchCOMPANIES())
    }

<<<<<<< HEAD
    render() {

        // console.log("Main", this.props, this.state)
        return (
=======
    render () {
        return(
>>>>>>> e00fc49... Having problem setting mystate in Reducer.js
            <div>
                <Aux>
                    <Switch>
                        <Route path="/referrer" component={Referrer} />
                        <Route path="/admin" component={Admin} />
                        <Route path="/" render={() => (<Participant companyName={this.props.companyNames} />)} />
                        <Route path="/login" />
                    </Switch>
                </Aux>
            </div>
        );
    }
}
const mapStateToProps = state => {
    return {
        companyNames: state.companyNames
    };
};

export default connect(mapStateToProps)(FormBuilder);
