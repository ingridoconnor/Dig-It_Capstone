import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/api"
});

export default {


    generateSeedlingShoppingList(gardenId) {
        return http.get(`/generateSuggestedSeedlingList/${gardenId}/`);
    },

    saveGardenPlots(plots, gardenID) {
      return http.post(`/garden/${gardenID}/plots`, plots)
  }
    
}