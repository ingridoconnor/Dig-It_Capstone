<template>
  <div>
    <div>
      <h1>This is the garden detail page i guess</h1>
      
      <router-link
        tag="button"
        class="btn addNewPlot"
        :to="{ name: 'AddPlot', params: {gardenID: this.gardenId} }"
      >Add New Plot</router-link>
      <button
        class="btn btn-cancel deleteGarden"
        v-on:click="deleteGarden"
      >Delete Garden</button>
    </div>
    </div>
  
    <!-- <div class="garden-actions">
      <router-link to="/garden">Back to Garden</router-link>
    </div> -->
</template>

<script>
import gardensService from "../services/GardenService";


export default {
  name: "plot-list",
  components: {
    
  },
  data() {
    return {
      gardenId: 0,
      type: "",
      width: "",
      length: ""
    };
  },
  methods: {
    retrievePlots() {
      gardensService
        .getPlots(this.gardenId)
        .then(response => {
          this.$store.commit("SET_GARDEN_PLOTS", response.data.plots);
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Garden not available. This garden may have been deleted or you have entered an invalid garden ID."
            );
            this.$router.push("/");
          }
        });
    },
    deleteBoard() {
      if (confirm("Are you sure you want to delete this garden and all associated plots? This action cannot be undone.")) {
        gardensService
          .deleteBoard(this.gardenId)
          .then(response => {
            if (response.status === 200) {
              alert("Garden successfully deleted");
              this.$router.push("/");
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error deleting garden. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting garden. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting garden. Request could not be created.";
            }
          });
      }
    }
  },
  created() {
    this.gardenId = this.$route.params.id;
    this.retrievePlots();
  }
    
  
};
</script>

<style>

</style>
