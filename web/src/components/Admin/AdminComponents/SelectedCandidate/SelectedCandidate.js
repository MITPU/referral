import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import classes from "./SelectedCandidate.css";

function SelectedCandidate(props) {
  const selectedId = props.match.params.id;
  const candidate = props.candidates[selectedId - 1];

  return (
    <Container>
      <Row>
        <Col className={classes.container} >
          <div>Name: {candidate.firstname + " " + candidate.lastname}</div>
          <div>Phone: {candidate.phone}</div>
          <div>Email: {candidate.email}</div>
          <div>Address: {candidate.city + ", " + candidate.state + " " + candidate.country}</div>
          <div>Work Authorization: {candidate.workAuthorization}</div>
          <div>LinkedIn: {candidate.linkedin}</div>
        </Col>
        <Col className={classes.container}>
            Status:
            <p>(Participation status)</p>
            Stage:
            <p>{candidate.status}</p>
        </Col>
      </Row>
      <Row>
        <Col className={classes.container}>Resume</Col>
      </Row>
      <Row>
        <Col className={classes.container}>Engagement</Col>
      </Row>
      <Row>
        <Col className={classes.container}>Notes</Col>
      </Row>
      <Row>
        <Col className={classes.container}>Skills</Col>
      </Row>
    </Container>
  );
}

export default SelectedCandidate;
