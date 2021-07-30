import { RECEIVE_COMPANIES } from "./actions";
import { RECEIVE_SKILLS } from "./actions";
import { RECEIVE_CANDIDATES } from "./actions";

const initialState = {
  companyNames: [],
  skills: [],
  candidates: [],
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case RECEIVE_COMPANIES: {
      return { ...state, companyNames: action.names };
      break;
    }
    case RECEIVE_SKILLS: {
      return { ...state, skills: action.names };
      break;
    }
    case RECEIVE_CANDIDATES: {
      return { ...state, candidates: action.candidates };
      break;
    }
    default:
      return state;
  }
};

export default reducer;
