// import { combineReducers } from 'redux';
import { RECEIVE_COMPANIES } from './actions';

const initialState = {
    companyNames: []
};

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case RECEIVE_COMPANIES: {
            return {...state, companyNames:action.names}
            break;
            }
        default:
            return state
    }
}

// switch (action.type) {
//       case RECEIVE_COMPANIES:
//         return Object.assign({}, state, {
//           items: action.COMPANIES,
//           lastUpdated: action.receivedAt
//         })
//       default:
//         return state
// }

// function postsByCompanies(state = {}, action) {
//     switch (action.type) {
//       case RECEIVE_COMPANIES:
//         return Object.assign({}, state, {
//           [action.subreddit]: COMPANIES(state[action.subreddit], action)
//         })
//       default:
//         return state
//     }
//   }

// const reducer = (state = initialState, action) => {
//     return state
// };

export default reducer;