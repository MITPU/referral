import React from "react";
import classes from "./MyCandidates.css";
import * as ReactBootstrap from "react-bootstrap";
import { Link } from "react-router-dom";

function MyCandidates(props) {
  return (
    <ReactBootstrap.Table striped bordered hover>
      <thead>
        <tr>
          <th>
            <h4>ID</h4>
          </th>
          <th>
            <h4>Candidates</h4>
          </th>
          <th>
            <h4>SLA</h4>
          </th>
          <th>
            <h4>Stage</h4>
          </th>
          <th>
            <h4>Last Email</h4>
          </th>
        </tr>
      </thead>
      <tbody>
        {props.candidates.map((candidate) => (
          <tr key={candidate.id}>
            <td>{candidate.id}</td>
            <td>
              <Link className={classes.link}
              to={`/candidate/${candidate.id}`}
              >
                {candidate.firstname + " " + candidate.lastname}
              </Link>
            </td>
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
