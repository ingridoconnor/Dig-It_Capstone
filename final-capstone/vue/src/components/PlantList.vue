<template>

    <form>
      <div v-for="plant in this.$store.state.plants" v-bind:key="plant">
        <input type="radio" >  {{plant.name}} 
    </div>
  </form>

</template>

<script>
import PlantService from "../services/PlantService";

export default {
  created() {
    PlantService.getAllPlants()
      .then((response) => {
        this.$store.commit("SET_PLANTS", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Plant data not available.");
          this.$router.push("/");
        }
      });
  },

  name: "plant-data",
  components: {},
  data() {
    return {};
  },
};
</script>

<style>

</style>
