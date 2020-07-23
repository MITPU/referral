import React from 'react';
import classes from '../ReferrerForm/Referrer.css';
import Admin from './AdminForm/Admin';
import {Route} from 'react-router-dom';

const ParticipantForm = (props) => {

    return (
        <div className = {classes.Participant}>
            <Route
            render={() => (<Admin />) }/>
        </div>
    );
};

export default ParticipantForm