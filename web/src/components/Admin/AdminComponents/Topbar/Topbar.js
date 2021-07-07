import React from 'react';
import classes from './Topbar.css';
import SearchBar from './SearchBar';
import { Container, Row, Col } from 'react-bootstrap';

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
        // <React.Fragment>
        //     <div className={classes.container}>
        //       <div className={classes.title}>
        //       <p>MITPU Applicant Tracking System</p>
        //       </div>
        //       <div className={classes.search}>
        //         <SearchBar />
        //       </div>
        //     </div>
        // </React.Fragment>
    )
}

export default Topbar;