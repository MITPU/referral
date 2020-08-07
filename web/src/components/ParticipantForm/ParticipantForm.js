import React from 'react';
import classes from '../ReferrerForm/Referrer.css';
import PFS from './ParticipantFormStates/PFS';
import { Route } from 'react-router-dom';

const ParticipantForm = (props) => {
<<<<<<< HEAD
=======
    console.log(props.companyName)
>>>>>>> e00fc49... Having problem setting mystate in Reducer.js
    return (
        <div className={classes.Participant}>
            <Route
                render={() => (<PFS />)} />
        </div>
    );
};

export default ParticipantForm