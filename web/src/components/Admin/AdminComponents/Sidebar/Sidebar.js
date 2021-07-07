import React, {useState} from 'react';
import classes from "./Sidebar.css";
import SidebarItems from './SidebarItems';


function Sidebar() { 

    return (
        <div className={classes.sidebarBox}>
            <div className={classes.sidebar} >
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
        </div>
        </div>
        
    
    )  
}


export default Sidebar;


// import React, { useState } from "react";
// import classes from "./Sidebar.css";
// import SidebarItems from "./SidebarItems";
// import Sidebar from "react-sidebar";
// import ArrowForwardIosIcon from '@material-ui/icons/ArrowForwardIos';

// class SidebarComponent extends React.Component {
//   constructor(props) {
//     super(props);
//     this.state = {
//       sidebarOpen: false,
//     };
//     this.onSetSidebarOpen = this.onSetSidebarOpen.bind(this);
//   }

//   onSetSidebarOpen(open) {
//     this.setState({ sidebarOpen: open });
//   }

//   render() {
//     return (
//       <Sidebar
//         sidebar={
//           <b>
//             <div className={classes.sidebar}>
//               <SidebarItems link="/mycandidates">My Candidates</SidebarItems>
//               <SidebarItems link="/search">Search</SidebarItems>
//               <SidebarItems link="/metrics">Metrics</SidebarItems>
//               <SidebarItems link="/">Referrers</SidebarItems>
//             </div>
//           </b>
//         }
//         open={this.state.sidebarOpen}
//         onSetOpen={this.onSetSidebarOpen}
//         styles={{ sidebar: { background: "white" } }}
//       >
//         <button onClick={() => this.onSetSidebarOpen(true)} className={classes.button}>
//           <ArrowForwardIosIcon />
//         </button>
//       </Sidebar>
//     );
//   }
// }

// export default SidebarComponent;