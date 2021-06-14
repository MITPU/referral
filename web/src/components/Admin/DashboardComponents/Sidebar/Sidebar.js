import React from 'react';
import classes from "./Sidebar.css";

function Sidebar() {
    return (
        <div className={classes.sidebar}>
            <div className={classes.sidebarWrapper}>
                <div className={classes.sidebarMenu}>
                    <ul className={classes.sidebarList}>
                        <li className={classes.sidebarListItem}>
                            My Candidates
                        </li>
                        <li className={classes.sidebarListItem}>
                            Search
                        </li>
                        <li className={classes.sidebarListItem}>
                            Metrics
                        </li>
                        <li className={classes.sidebarListItem}>
                            Referrers
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    )
}


export default Sidebar;