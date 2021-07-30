import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import classes from "./SelectedCandidate.css";
import NotesModal from '../../AdminComponents/SelectedCandidate/Notes/NotesModal';

function SelectedCandidate(props) {
  const selectedId = props.match.params.id;
  const candidate = props.candidates[selectedId - 1];

  return (
    <Container>
      <Row>
        <Col className={classes.container}>
          <p><b>Name: </b> {candidate.firstname + " " + candidate.lastname}</p>
          <p><b>Phone: </b> {candidate.phone}</p>
          <p><b>Email: </b> {candidate.email}</p>
          <p>
            <b>Address: </b> 
            {candidate.city + ", " + candidate.state + " " + candidate.country}
          </p>
          <p><b> Work Authorization: </b> {candidate.workAuthorization}</p>
          <p><b> LinkedIn: </b> {candidate.linkedin}</p>
        </Col>
        <Col className={classes.container}>
          <b>Status: </b>
          <p>(Participation status)</p>
          <b>Stage: </b>
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
      <Col className={classes.container}>Notes
        <NotesModal />
      </Col>
      </Row>
      <Row>
        <Col className={classes.container}>Skills</Col>
      </Row>
    </Container>
  );
}

export default SelectedCandidate;
