import React from 'react';
import classes from '../ReferrerForm/Referrer.css';
import PFS from './ParticipantFormStates/PFS';
import {Route} from 'react-router-dom';

const ParticipantForm = (props) => {
    return (
        <div className = {classes.Participant}>
            <Route
            render={() => (<PFS companyNames={props.companyName} candidateSkills={props.companySkill}/>) }/>
        </div>
    );
};

export default ParticipantForm