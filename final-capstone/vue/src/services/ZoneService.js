import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080/api"
});

export default {

  getZoneInfo(user) {
    return http.get('/zone', user);
  }

}
