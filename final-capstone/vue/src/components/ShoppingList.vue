<template>
  <div class="shopping-list-container">
    <p>{{$store.state.shoppingLists}}</p>

    <p>{{$store.state.plots}}</p>
  </div>
</template>

<script>
import PlotService from "@/services/PlotService";
import ShoppingService from "@/services/ShoppingService";
import GardenService from "@/services/GardenService";

export default {
  name: "shopping-list",
  created() {
    GardenService.getGardenById(this.$route.params.gardenid)
      .then((response) => {
        this.$store.commit("SET_GARDEN", response.data);
       })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });
      
      PlotService.getPlotsByGardenId(this.$route.params.gardenid)
      .then((response) => {
        this.$store.commit("SET_PLOTS", response.data);


    ShoppingService.generateSeedlingShoppingList(this.$store.state.plots)
      .then((response) => {
        this.$store.commit("SET_SHOPPING_LISTS", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Shopping List Data not available.");
          this.$router.push("/");
        }
      });

      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });


  },
};
</script>

<style>
</style>