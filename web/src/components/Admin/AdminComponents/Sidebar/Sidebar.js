import React from "react";
import classes from "./Sidebar.css";
import SidebarItems from "./SidebarItems";

function Sidebar() {
  return (
    <div className={classes.sidebarBox}>
      <div className={classes.sidebar}>
        <SidebarItems link="/mycandidates">My Candidates</SidebarItems>
        <SidebarItems link="/search">Search</SidebarItems>
        <SidebarItems link="/metrics">Metrics</SidebarItems>
        <SidebarItems link="/">Referrers</SidebarItems>
      </div>
    </div>
  );
}

export default Sidebar;