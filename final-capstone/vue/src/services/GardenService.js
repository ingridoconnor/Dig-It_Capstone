import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
});

export default {

    getGarden() {
        return http.get('/garden');
    },

    getPlots(gardenID) {
        return http.get(`/garden/${gardenID}`)
    }
}