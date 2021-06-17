import React from 'react';
import classes from './MockComponent.css';
import { Container, Row, Col } from 'react-bootstrap';

function MockComponent({
    name, sla, stage, lastEmail
}) {
    return (
        <Row className={classes.home_row}>
            <Col md={3} className={classes.candidates}>
                <h1>Candidates</h1>
                <p>{name}</p>  
            </Col>
            <Col md={3} className={classes.sla}>
                <h1>SLA</h1>
                <p>{sla}</p>  
            </Col>
            <Col md={3} className={classes.stage}>
                <h1>Stage</h1>
                <p>{stage}</p>  
            </Col>
            <Col md={3} className={classes.email}>
                <h1>Last Email</h1>
                <p >{lastEmail}</p>  
            </Col>
        </Row>
    )
}

export default MockComponent;


