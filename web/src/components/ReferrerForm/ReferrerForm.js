import React from 'react';
import classes from './Referrer.css';
import RFS from './ReferrerFormStates/RFS';
import {Route} from 'react-router-dom';

const ParticipantForm = (props) => {

    return (
        <div className = {classes.Participant}>
            <Route
            render={() => (<RFS />) }/>
        </div>
    );
};

export default ParticipantForm