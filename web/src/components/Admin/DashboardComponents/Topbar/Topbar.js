import React from 'react';
import classes from './Topbar.css';

function Topbar() {
    return (
        <React.Fragment>
            <div className={classes.container}>
              <div className={classes.title}>
              <p>MITPU Applicant Tracking System</p>
            </div>
            <div className={classes.search}>
              <form action="/" method="get">
                <label htmlFor="header-search">
                </label>
              <input
                type="text"
                id="header-search"
                placeholder="Search"
                />
              <button type="submit">Search</button>
              </form>
            </div>
            </div>
        </React.Fragment>
    )
}

export default Topbar;