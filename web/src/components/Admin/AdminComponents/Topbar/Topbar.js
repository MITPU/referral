import React from 'react';
import classes from './Topbar.css';
import SearchBar from './SearchBar';
import { Row, Col } from 'react-bootstrap';

function Topbar() {
    return (
      <div>
        <Row>
          <Col xs={9} className={classes.title}><p>MITPU Applicant Tracking System</p>
          </Col>
          <Col xs={3} className={classes.search}><SearchBar />
          </Col>
        </Row>
      </div>
    )
}

export default Topbar;