import axios from 'axios';

const instance = axios.create({
    // This baseURL will be replaced soon
    baseURL: 'https://referral-3ffeb.firebaseio.com/'
});

export default instance;