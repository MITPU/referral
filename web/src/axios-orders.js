import axios from 'axios';

const instance = axios.create({
    baseURL: 'https://referral-3ffeb.firebaseio.com/'
});

export default instance;