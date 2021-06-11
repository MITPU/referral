import React from 'react';
import "./Sidebar.css";

function Sidebar() {
    return (
        <div className="sidebar">
            <div className="sidebarWrapper">
                <div className="sidebarMenu">
                    <h3 className="sidebarTitle">Dashboard</h3>
                    <ul className="sidebarList">
                        <li className="sidebarListItem">
                            My Candidates
                        </li>
                        <li className="sidebarListItem">
                            Search
                        </li>
                        <li className="sidebarListItem">
                            Metrics
                        </li>
                        <li className="sidebarListItem">
                            Referrers
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    )
}


export default Sidebar;