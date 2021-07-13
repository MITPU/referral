import React from "react";
import { Col } from "react-bootstrap";


function Overview(props) {
  const selectedId = props.match.params.id;
  const candidate = props.candidates[selectedId - 1];

  return (
        <Col>
          <div>Name: {candidate.firstname + " " + candidate.lastname}</div>
          <div>Phone: {candidate.phone}</div>
          <div>Email: {candidate.email}</div>
          <div>Address: {candidate.city + ", " + candidate.state + " " + candidate.country}</div>
        </Col>
  );
}

export default Overview;
