<template>
  <div class="shopping-list-container">
    <p>{{$store.state.shoppingLists}}</p>

    <p>{{$store.state.plots}}</p>
  </div>
</template>

<script>
import PlotService from "@/services/PlotService";
import ShoppingService from "@/services/ShoppingService.js";
import GardenService from "@/services/GardenService";

export default {
  name: "shopping-list",
  data() {
    return {
      PlotsLoaded: false,
      plotList: [],
      ShoppingLists: [],
      String: "CODE REACHED",
    };
  },

  created() {
    PlotService.getPlotsByGardenId(this.$route.params.gardenid)
      .then((response) => {
        this.plotList = response.data;
        this.$store.commit("SET_PLOTS", response.data);
        this.PlotsLoaded = true;

        for (var i = 0; i < 300; i++) {
          console.log("*");
        }

        ShoppingService.generateSeedlingShoppingList(this.plotList)
          .then((response) => {
            console.log("shopping service CODE REACHED");
            this.ShoppingLists = response.data;
            this.$store.commit("SET_SEEDLING_SHOPPING_LISTS", response.data);

          })
          .catch((error) => {
            console.log("SHOPPING ERROR REACHED");
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

    GardenService.getGardenById(this.$route.params.gardenid)
      .then((response) => {
        this.$store.commit("SET_GARDEN", response.data);
        console.log(this.String);
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