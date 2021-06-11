import React from 'react';
import Sidebar from "../DashboardComponents/Sidebar/Sidebar";
import {Route} from 'react-router-dom';
import "./Dashboard.css";

const Dashboard = (props) => {
    return (
        <div className="container">
            <Route
            render={() => (<Sidebar />) }/>
        </div>
    )
}


export default Dashboard;
