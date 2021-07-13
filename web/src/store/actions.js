import axios from "axios";
export const RECEIVE_COMPANIES = "RECEIVE_COMPANIES";
export const RECEIVE_SKILLS = "RECEIVE_SKILLS";
export const RECEIVE_CANDIDATES = "RECEIVE_CANDIDATES";

export const fetchCOMPANIES = () => {
  const config = {
    method: "get",
    url: "http://localhost:8080/companies",
    headers: {},
  };
  return (dispatch) => {
    return axios(config)
      .then((response) => {
        dispatch({ type: "RECEIVE_COMPANIES", names: response.data });
      })
      .catch((err) => {
        dispatch({ type: "RECEIVE_ERROR", names: err });
      });
  };
};
export const fetchSKILLS = () => {
  const config = {
    method: "get",
    url: "http://localhost:8080/skills",
    headers: {},
  };
  return (dispatch) => {
    return axios(config)
      .then((response) => {
        dispatch({ type: "RECEIVE_SKILLS", names: response.data });
      })
      .catch((err) => {
        dispatch({ type: "RECEIVE_ERROR", names: err });
      });
  };
};

export const fetchCANDIDATES = () => {
  const config = {
    method: "get",
    url: "http://localhost:8080/candidates",
    headers: {},
  };
  return (dispatch) => {
    return axios(config)
      .then((response) => {
        dispatch({ type: "RECEIVE_CANDIDATES", candidates: response.data });
      })
      .catch((err) => {
        dispatch({ type: "RECEIVE_ERROR", candidates: err });
      });
  };
};
