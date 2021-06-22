import React from 'react';
import { personOne } from '../../../../MockData';
import Candidates from './Candidates';
import SLA from './Sla';
import Stage from './Stage';
import Email from './Email';
import classes from './MyCandidates.css';


function MyCandidates() {
    return (
        <table className={classes.table}>
            <thead>
                <tr>
                    <th><h3 className={classes.header}>Candidates</h3></th>
                    <th><h3 className={classes.header}>SLA</h3></th>
                    <th><h3 className={classes.header}>Stage</h3></th>
                    <th><h3 className={classes.header}>Last Email</h3></th>
                </tr>
            </thead>
            <tbody>
                <td className={classes.column}>
                    <Candidates candidates={personOne} />   
                </td>
                <td className={classes.column}>
                    <SLA candidates={personOne} />   
                </td>
                <td className={classes.column}>
                    <Stage candidates={personOne} />    
                </td>
                <td className={classes.email}>
                    <Email candidates={personOne} /> 
                </td>  
            </tbody>
        </table>     
    )
}

export default MyCandidates;

