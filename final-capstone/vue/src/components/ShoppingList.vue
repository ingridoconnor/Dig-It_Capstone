<template>
  <div class="shopping-list-container">
    <p>{{this.$store.state.shoppingList}}</p>

    <p>{{this.$store.state.plots}}</p>




  </div>
</template>

<script>
import PlotService from "@/services/PlotService"
import ShoppingService from "@/services/ShoppingService"


export default {
    name: "shopping-list",
    created() {
        PlotService.getPlotsByGardenId(this.$route.params.gardenid)
      .then((response) => {
          this.$store.commit("SET_PLOTS", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });
        
        ShoppingService.generateSeedlingShoppingList(this.$store.state.plots)
 .then((response) => {
          this.$store.commit("SET_SHOPPING_LIST", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Shopping List Data not available.");
          this.$router.push("/");
        }
      });

    }
}
</script>

<style>


</style>