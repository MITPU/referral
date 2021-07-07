import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import classes from './SelectedCandidate.css';

import Overview from './Overview/Overview';

function SelectedCandidate() {
    return (
        <div>
            <Container>
                <Row>
                    <Col className={classes.container}><Overview />
                    </Col>
                    <Col className={classes.container}>Status
                    </Col>
                </Row>
                <Row>
                    <Col className={classes.container}>Resume
                    </Col>
                </Row>
                <Row>
                    <Col className={classes.container}>Engagement
                    </Col>
                </Row>
                <Row>
                    <Col className={classes.container}>Notes
                    </Col>
                </Row>
                <Row>
                    <Col className={classes.container}>Skills
                    </Col>
                </Row>
            </Container>
            
        </div>
    )
}

export default SelectedCandidate;