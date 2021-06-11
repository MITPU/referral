import React from 'react';
import classes from '../ReferrerForm/Referrer.css';
// import Admin from './AdminForm/Admin';
import {Route} from 'react-router-dom';
import Dashboard from "../DashboardComponents/Dashboard";

const ParticipantForm = (props) => {

    return (
        <div className = {classes.Participant}>
            {/* <Route
            render={() => (<Admin />) }/> */}
            <Route
            render={() => (<Dashboard />) }/>
        </div>
    );
};

export default ParticipantForm;