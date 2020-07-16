import React from 'react';

import classes from './Layout.css';
import Toolbar from '../Navigation/Toolbar/Toolbar';
import SideDrawer from '../Navigation/SideDrawer/SideDrawer';

const layout = ( props ) => (
    <div>
    <Toolbar />
    <SideDrawer />
    <main className = {classes.Content}>
        {props.children}
    </main>
    </div>
);

export default layout;

