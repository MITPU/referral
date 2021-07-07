import React from "react";
import classes from "./MyCandidates.css";
import * as ReactBootstrap from "react-bootstrap";

function MyCandidates(props) {
  return (
    <ReactBootstrap.Table striped bordered hover>
      <thead>
        <tr>
          <th>
            <h4 className={classes.header}>Candidates</h4>
          </th>
          <th>
            <h4 className={classes.header}>SLA</h4>
          </th>
          <th>
            <h4 className={classes.header}>Stage</h4>
          </th>
          <th>
            <h4 className={classes.header}>Last Email</h4>
          </th>
        </tr>
      </thead>
      <tbody>
        {props.candidates.map((candidate) => (
          <tr key={candidate.id}>
            <td>{candidate.firstname + " " + candidate.lastname}</td>
            <td></td>
            <td>{candidate.stage}</td>
            <td>{candidate.email}</td>
          </tr>
        ))}
      </tbody>
    </ReactBootstrap.Table>
  );
}

export default MyCandidates;
