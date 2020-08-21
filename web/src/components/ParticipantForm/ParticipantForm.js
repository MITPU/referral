import React from 'react';
import classes from '../ReferrerForm/Referrer.css';
import PFS from './ParticipantFormStates/PFS';
import { Route } from 'react-router-dom';

const ParticipantForm = (props) => {
    return (
<<<<<<< HEAD
        <div className={classes.Participant}>
            <Route render={() => (<PFS companyNames={props.companyName} />)} />
=======
        <div className = {classes.Participant}>
            <Route
            render={() => (<PFS companyNames={props.companyName}/>) }/>
>>>>>>> 841ec65... update
        </div>
    );
};

export default ParticipantForm