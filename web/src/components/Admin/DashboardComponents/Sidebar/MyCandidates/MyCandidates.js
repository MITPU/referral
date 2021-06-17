import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import MockComponent from './MockComponent';
import classes from './MyCandidates.css';
import {personOne, personTwo, personThree } from '../../../../MockData';

function MyCandidates() {
    return (
        <React.Fragment>
            <MockComponent {...personOne} />
        </React.Fragment>
    )
}

export default MyCandidates;