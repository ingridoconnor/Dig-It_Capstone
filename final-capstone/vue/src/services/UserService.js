import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080/api"
});

export default {

  getUserInfo(id) {
    return http.get(`/user/${id}`);
  }


}