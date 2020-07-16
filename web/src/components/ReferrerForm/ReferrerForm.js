import React from 'react';
import classes from './Referrer.css';
import RFS from './ReferrerFormStates/RFS';
import Spinner from '../../components/UI/Spinner/Spinner';
import axios from '../../axios-orders';

// Transfer the state object into an array

const ReferrerForm = (props) => {
    const myParagraphs = <h1>Referrer Form</h1>;
    const greetings = <p>Welcome to the Referral Program from MITPU! Your support to MITPU Community helps hundreds of Mongolian job seekers. 
        The first step is to fill this form to join our referrer community.</p>;

    return (
        <div className = {classes.Participant}>
            {myParagraphs}
            {greetings}
            <RFS type="email" />
            <RFS type="greetings" />
            <button 
                className={classes.OrderButton}
                cliked={this.submitForm}
            >Submit</button>
        </div>
    );
};

export default ReferrerForm