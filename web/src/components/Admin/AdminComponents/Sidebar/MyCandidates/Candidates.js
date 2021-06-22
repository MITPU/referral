import React from 'react';
import classes from './MyCandidates.css';

function RenderItem({ candidate }) {
    return ( 
        <div key={candidate.id} className={classes.row}>{candidate.name}</div>
    );
}

function Candidates (props) {
    const comp = props.candidates.map(candidate => {
        return (
            <RenderItem key={candidate.id} candidate={candidate} />        
        );
    });

    return (
        <React.Fragment>
            {comp}
        </React.Fragment>
    )
}

export default Candidates;