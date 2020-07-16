import React from 'react';

import mitpuLogo from "../assets/images/logo.png";
import classes from './Logo.css'

const logo = (props) => (
    <div className={classes.Logo} style={{height: props.height}}>
        <img src={mitpuLogo} alt='MyLogo' />
    </div>
);

export default logo;