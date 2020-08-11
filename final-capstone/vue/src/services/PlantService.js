import axios from 'axios';

const http = axios.create( {
    baseURL: "http://localhost:8080/api"
});

export default {
    getAllPlants() {
        return http.get("/allPlants");
    },
    updatePlantInfo(plant) {
        return http.put('/', plant);
      },
      
      addPlant(id) {
        return http.post(`/plant/${id}`);
      },
    
      deletePlant(id) {
        return http.delete(`/plant/${id}`);
      }

    
};