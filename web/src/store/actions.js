import axios from 'axios';
export const RECEIVE_COMPANIES = 'RECEIVE_COMPANIES'

export const fetchCOMPANIES = () => {
    const config = {
        method: 'get',
        url: 'http://localhost:8080/companies',
        headers: {}
    };
    return dispatch => {
        return (
            axios(config)
                .then((response) => {
                    dispatch({type: "RECEIVE_COMPANIES", names: response.data})
                })
                .catch((err) => {
                    dispatch({type: "RECEIVE_ERROR", names: err})
                })
        )
    }
} 