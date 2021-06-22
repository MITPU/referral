import React from 'react';
import classes from './MyCandidates.css';

function RenderItem({ candidate }) {
    return ( 
        <div key={candidate.id} className={classes.row}>{candidate.stage}</div> 
    );
}

function Candidates (props) {
    const comp = props.candidates.map(candidate => {
        return (
            <RenderItem key={candidate.id} candidate={candidate} />        
        );
    });

    return (
        <div>
            {comp}  
        </div>
    )
}

export default Candidates;