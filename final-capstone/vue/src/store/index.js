import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));
const currentUserData = JSON.parse(localStorage.getItem('userData'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    userData: currentUserData || {},
    gardens: [],
    plants: {
      id: "",
      name: "",
      description: "",
      plantsPerSqFoot: "",
      sunRequirements: "", 
      region: "", 
      seedlingCost: ""
    },
    plot: {
      gardenId: 0,
      type: "",
      width: "",
      length: ""
    }
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    SET_USER_DATA(state, userData) {
      state.userData = userData;
      localStorage.setItem('userData',JSON.stringify(userData));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_PLANTS(state, data) {
      state.plants = data;
    },
    ADD_PLOT(state,plot) {
      const garden = this.state.gardens.find(p => p.id == plot.id);
      garden.plot.unshift(plot);
    },
    SET_GARDEN(state, data) {
      state.gardens.push(data);
    },
    // ADD_GARDEN(state,garden) {
    //   const garden = this.state.gardens.find(p => p.id == review.id);
    //   product.reviews.unshift(review);
    // }
  }
})
