import React from 'react';
import classes from './Participant.css';
import PFS from './ParticipantFormStates/PFS';
import {Route} from 'react-router-dom';

// import Spinner from '../../components/UI/Spinner/Spinner';
// import axios from '../../axios-orders';

// Transfer the state object into an array

const ParticipantForm = (props) => {
    const myParagraphs = <h1>Participant Form</h1>;
    const greetings = <p>Welcome to Referral Program! Our mission is to help you find the best position</p>;

    return (
        <div className = {classes.Participant}>
            <Route
            render={() => (<PFS />) }/>
        </div>
    );
};

export default ParticipantForm