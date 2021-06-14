import React from 'react';
import {Route} from 'react-router-dom';
import Sidebar from "../Admin/DashboardComponents/Sidebar/Sidebar";
import Topbar from "../Admin/DashboardComponents/Topbar/Topbar";
import MyCandidates from "../Admin/DashboardComponents/Sidebar/MyCandidates/MyCandidates";

const Admin = (props) => {

    return (
        <React.Fragment>
            <Route
            render={() => (<Topbar />) }/>
            <Route
            render={() => (<Sidebar />) }/>
            <Route
            render={() => (<MyCandidates />) }/>
        </React.Fragment>
    );
};

export default Admin;