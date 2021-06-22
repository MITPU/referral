import React from 'react';
import classes from './NavigationItems.css';
import NavigationItem from './NagivationItem/NavigationItem'

const navigationItems = () => (
    <ul className={classes.NavigationItems}>
        <NavigationItem link="/">
            Participant Form
        </NavigationItem>
        <NavigationItem link="/referrer">
            Referrer Form
        </NavigationItem>
        <NavigationItem link="/admin">
            Admin
        </NavigationItem>
    </ul>
);

export default navigationItems;