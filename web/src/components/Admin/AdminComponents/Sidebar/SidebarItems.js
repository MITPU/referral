import React from 'react';
import classes from './SidebarItems.css';

const sidebarItems = (props) => (
    <li className={classes.SidebarItems}>
        <a 
        href={props.link} 
        className = {props.active ? classes.active : null} >{props.children}</a>
    </li>
);

export default sidebarItems;