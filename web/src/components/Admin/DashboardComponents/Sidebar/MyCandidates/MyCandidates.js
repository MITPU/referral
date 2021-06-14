import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import classes from './MyCandidates.css';

function MyCandidates() {
    return (
        <React.Fragment>
            <Row>
                <Col md={6} className={classes.candidates}><p>My cadindates</p></Col>
                <Col md={6} className={classes.sla}><p>SLA</p></Col>
                <Col md={6} className={classes.stage}><p>STAGE</p></Col>
                <Col md={6} className={classes.email}><p>Last email</p></Col>
            </Row>
        </React.Fragment>
    )
}

export default MyCandidates;