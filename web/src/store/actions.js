import axios from 'axios';
export const RECEIVE_COMPANIES = 'RECEIVE_COMPANIES'

function receiveCOMPANIES(json) {
    return {
        type: RECEIVE_COMPANIES,
        COMPANIES: json.data.children.map(child => child.data),
        receivedAt: Date.now()
    }
}

export const fetchCOMPANIES = () => {
    const config = {
        method: 'get',
        url: 'http://localhost:8080/companies',
        headers: {}
    };
    return dispatch => {
        return (
            axios(config)
                .then(function (response) { console.log(JSON.stringify(response.data)); })
                .then(json => dispatch(receiveCOMPANIES(json)))
                .catch(function (error) { console.log(error) })
        )
    }
}