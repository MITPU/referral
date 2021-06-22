import React from 'react';
import {Route} from 'react-router-dom';
import classes from './Admin.css';
import Sidebar from "./AdminComponents/Sidebar/Sidebar";
import Topbar from "./AdminComponents/Topbar/Topbar";
import MyCandidates from "./AdminComponents/Sidebar/MyCandidates/MyCandidates";

const Admin = (props) => {

    return (
        <React.Fragment>
        <div>
            <Route
            render={() => (<Topbar />) }/>
        </div>
        <div className={classes.container}>
            <Route className={classes.sidebar}
            render={() => (<Sidebar />) }/>
            <Route className={classes.main}
            render={() => (<MyCandidates />) }/>
        </div>
        </React.Fragment>
    );
};

export default Admin;