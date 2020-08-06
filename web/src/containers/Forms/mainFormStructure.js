import React, { Component } from 'react';

import { connect } from 'react-redux';
import Aux from '../../hoc/Auxiliary';
import Participant from '../../components/ParticipantForm/ParticipantForm';
import Referrer from '../../components/ReferrerForm/ReferrerForm';
import Admin from '../../components/Admin/Admin';
import { Route, Switch } from 'react-router-dom';
// import * as actionTypes from '../../store/actions';
import {fetchCOMPANIES} from '../../store/actions';


class FormBuilder extends Component {

    // Test State
    // state = {
    //     companyNames: [
    //         { name: 'Facebook'},
    //         { name: 'Google'},
    //         { name: 'Luther College'}
    //     ],
    //     skills: [
    //         { name: 'Python'},
    //         { name: 'JAVA'},
    //         { name: 'React Js'},
    //         { name: 'JavaScript'}
    //     ]
    // }

    state = {
        counter: 0
    }

    componentDidMount() {
        const { dispatch } = this.props
         dispatch(fetchCOMPANIES())
    }

    render () {

        // console.log("Main", this.props, this.state)
        return(
            <div>
                <Aux>
                    <Switch>
                        <Route path="/referrer" component={Referrer}/>
                        <Route path="/admin" component={Admin} />
                        <Route path="/" render={() => (<Participant companyName={this.state.companyNames} />)} />
                        <Route path="/login" />
                    </Switch>
                </Aux>
            </div>
        );
    }
}

// Fonfiguring out what information I need, saving initialStates in Store
const mapStateToProps = state => {
    return {
        companyNames: state.companyNames
    };
};

// const mapDispatchToProps = dispatch => {
//     return {
//         fetchNames: (companyName) => dispatch({type: actionTypes.FETCH_COMPANYNAME, companyName}),
//         fetchSkills: (skill) => dispatch({type: actionTypes.FETCH_SKILLS, skill})

//     }
// }

// Connect is a function that returns a higher order
export default connect(mapStateToProps)(FormBuilder);
