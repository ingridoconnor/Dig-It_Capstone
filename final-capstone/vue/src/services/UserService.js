import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080/api"
});

export default {

  getUserInfo(id) {
    return http.get(`/user/${id}`);
  },

  updateUserInfo(id) {
    return http.put(`/user/${id}`);
  },
  
  addUser(id) {
    return http.post(`/user/${id}`);
  }



}