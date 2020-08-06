import * as actionTypes from './actions';

const initialState = {
   
    companyNames: 12
    // isFetching: false,
    // didInvalidate: false,
    
    // companyNames: [
       
    // ],
    // skills: [
        
    // ]
};

const reducer = (state = initialState, action) => {
    
    // switch (action.type) {
    //     case INVALIDATE_SUBREDDIT:
    //       return Object.assign({}, state, {
    //         didInvalidate: true
    //       })
    //     case REQUEST_POSTS:
    //       return Object.assign({}, state, {
    //         isFetching: true,
    //         didInvalidate: false
    //       })
    //     case RECEIVE_POSTS:
    //       return Object.assign({}, state, {
    //         isFetching: false,
    //         didInvalidate: false,
    //         items: action.posts,
    //         lastUpdated: action.receivedAt
    //       })
    //     default:
    //       return state

    switch (action.type) {
        // case actionTypes.FETCH_COMPANYNAME:
        // return {
        //     // companyNames: {
        //     //     [action.companyName] : state.companyNames[action.companyNames]
        //     // }
        // };
        // case actionTypes.FETCH_SKILLS: 
        //     return {
                
        //     };
        default:
            return state;
    }
    
};

export default reducer;