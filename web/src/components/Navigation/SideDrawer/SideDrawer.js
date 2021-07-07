import React from 'react';
import Logo from '../../Logo/Logo';
import NavigationItems from '../NavigationItems/NavigationItems';
import classes from './SideDrawer.css';
import Backdrop from '../../UI/Backdrop/Backdrop';
import Auxiliary from '../../../hoc/Auxiliary/Auxiliary';



const sideDrawer = (props) => {
    let attachedClasses = [classes.SideDrawer, classes.Close];
    if (props.open) {
        attachedClasses = [classes.SideDrawer, classes.Open];
    }
    return (
        <Auxiliary>
            <Backdrop show={props.open} clicked={props.closed}/>
                <div className={attachedClasses.join(' ')}>
                    <div className={classes.Logo}>
                        <Logo height="35%"/>
                    </div>
                    <nav>
                        <NavigationItems />
                        <ul className={classes.container}>
                            <a className={classes.item} href="/mycandidates">
                                My Candidates
                            </a>
                            <a className={classes.item} href="/search">
                                Search
                            </a>
                            <a className={classes.item} href="/metrics">
                                Metrics
                            </a>
                            <a className={classes.item} href="/">
                                Referrers
                            </a>
                        </ul>
                    </nav>
                </div>
        </Auxiliary>
    );
};

export default sideDrawer