import React from 'react';
import classes from '../ReferrerForm/Referrer.css';
import PFS from './ParticipantFormStates/PFS';
import {Route} from 'react-router-dom';

const ParticipantForm = (props) => {
    console.log(props.companyName)
    return (
        <div className = {classes.Participant}>
            <Route
            render={() => (<PFS />) }/>
        </div>
    );
};

export default ParticipantForm