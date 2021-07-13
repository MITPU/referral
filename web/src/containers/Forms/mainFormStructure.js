import React, { Component } from "react";
import Aux from "../../hoc/Auxiliary/Auxiliary";
import Participant from "../../components/ParticipantForm/ParticipantForm";
import Referrer from "../../components/ReferrerForm/ReferrerForm";
import Admin from "../../components/Admin/Admin";
import SelectedCandidate from "../../components/Admin/AdminComponents/SelectedCandidate/SelectedCandidate";
import MyCandidates from "../../components/Admin/AdminComponents/Sidebar/MyCandidates/MyCandidates";
import { Route, Switch } from "react-router-dom";
import { connect } from "react-redux";
import { fetchCOMPANIES } from "../../store/actions";
import { fetchSKILLS } from "../../store/actions";
import { fetchCANDIDATES } from "../../store/actions";
import { fetchCANDIDATE } from '../../store/actions';

class FormBuilder extends Component {
  state = {
    companyNames: [],
    skills: [],
    candidates: [],
  };

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(fetchCOMPANIES());
    dispatch(fetchSKILLS());
    dispatch(fetchCANDIDATES());
  }

  render() {
    return (
      <div>
        <Aux>
          <Switch>
            <Route path="/referrer" component={Referrer} />
            <Route
              path="/admin"
              render={() => <Admin candidates={this.props.candidates} />}
            />
            <Route
              path="/mycandidates"
              render={() => <MyCandidates candidates={this.props.candidates} />}
            />
            <Route
              path="/candidate/:id"
              render={(props) => (
                <SelectedCandidate
                  {...props}
                  candidates={this.props.candidates}
                />
              )}
            />
            <Route path="/login" />
            <Route
              path="/"
              render={() => (
                <Participant
                  companyName={this.props.companyNames}
                  companySkill={this.props.skills}
                />
              )}
            />
          </Switch>
        </Aux>
      </div>
    );
  }
}
const mapStateToProps = (state) => {
  return {
    companyNames: state.companyNames,
    skills: state.skills,
    candidates: state.candidates,
  };
};

export default connect(mapStateToProps)(FormBuilder);
