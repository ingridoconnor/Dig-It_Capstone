import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {

    getGarden() {
        return http.get('/garden');
    },

    getPlots(gardenID) {
        return http.get(`/garden/${gardenID}`)
    },

    addPlot(plot) {
        return http.post('/plots', plot);
      },
    
      updatePlot(plot) {
        return http.put(`/plots/${plot.id}`, plot);
      },
    
      deletePlot(plotID) {
        return http.delete(`/plots/${plotID}`);
      },
    
      addGarden(garden) {
        return http.post('/gardens', garden);
      },
    
      deleteGarden(gardenID) {
        return http.delete(`/gardens/${gardenID}`);
      }
    
}