import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/api"
});

export default {


    generateSeedlingShoppingList(data) {
        return http.get(`/generateSuggestedSeedlingList`, data);
    },

    saveGardenPlots(plots, gardenID) {
      return http.post(`/garden/${gardenID}/plots`, plots)
  }
    
}