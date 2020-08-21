import axios from 'axios';

const instance = axios.create({
    // This baseURL will be replaced soon
    baseURL: 'http://localhost:8080/companies'
});

export default instance;