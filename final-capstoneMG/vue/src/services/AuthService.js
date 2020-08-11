import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080/"
});

export default {

  login(user) {
    console.log(user);
    return http.post('/login', user)
  },

  register(user) {
    return http.post('/register', user)
  }

}
