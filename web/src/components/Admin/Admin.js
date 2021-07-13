import React from "react";
import classes from "./Admin.css";
import Sidebar from "./AdminComponents/Sidebar/Sidebar";
import Topbar from "./AdminComponents/Topbar/Topbar";
import MyCandidates from "./AdminComponents/Sidebar/MyCandidates/MyCandidates";
import { Row, Col } from "react-bootstrap";

function Admin(props) {
  return (
    <div>
      <Topbar />
      <Row>
        <Col sm={2} className={classes.sidebar}>
          <Sidebar />
        </Col>
        <Col sm={10} className={classes.main}>
          <MyCandidates candidates={props.candidates} />
        </Col>
      </Row>
    </div>
  );
}

export default Admin;
