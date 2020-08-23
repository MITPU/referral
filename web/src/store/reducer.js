import { RECEIVE_COMPANIES } from './actions';

const initialState = {
    companyNames: []
};

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case RECEIVE_COMPANIES: {
            return { ...state, companyNames: action.names }
            break;
        }
        default:
            return state
    }
}

export default reducer;