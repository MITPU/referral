import React from 'react';
import classes from "./Sidebar.css";
import SidebarItems from './SidebarItems';

const sidebar = () => (
    <ul className={classes.sidebar}>
        <SidebarItems link="/mycandidates">
            My Candidates
        </SidebarItems>
        <SidebarItems link="/search">
            Search
        </SidebarItems>
        <SidebarItems link="/metrics">
            Metrics
        </SidebarItems>
        <SidebarItems link="/">
            Referrers
        </SidebarItems>
    </ul>
)

export default sidebar;