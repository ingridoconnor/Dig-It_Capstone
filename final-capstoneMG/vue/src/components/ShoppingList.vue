<template>
  <div class="shopping-list-container">
    <p>{{this.ShoppingLists}}</p>

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
      plotList: this.$store.state.plots,
      ShoppingLists: [{
        cost: 0,
        itemName: ''
      }],
      String: "CODE REACHED",
    };
  },

  created() {
    PlotService.getPlotsByGardenId(this.$route.params.gardenid)
      .then((response) => {
        this.plotList = response.data;
        this.$store.commit("SET_PLOTS", response.data);
        this.PlotsLoaded = true;

        ShoppingService.generateSeedlingShoppingList(this.$route.params.gardenid)
          .then((response) => {
            console.log("shopping service CODE REACHED");
            console.log(response.data);
            this.ShoppingLists = response.data;
            console.log (this.ShoppingLists[0].cost);
            this.$store.commit("SET_SEEDLING_SHOPPING_LISTS", this.ShoppingLists);

          })
          .catch((error) => {
            console.log("SHOPPING ERROR REACHED");
            if (error.response && error.response.status === 404) {
              alert("Shopping List Data not available.");
              this.$router.push("/");
            }
          });
          for (var i = 0; i < 300; i++) {
              console.log("*");
         }
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