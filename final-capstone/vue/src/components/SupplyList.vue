<template>
  <form id="supply-selector">
    <div id="supplies">
      <div class="supply" v-for="supply in this.$store.state.supplies" v-bind:key="supply.index">
        <input
          type="checkbox"
          class="checkboxes"
          v-bind:id="`Supply-${supply.id}`"
          v-bind:value="supply.id"
          v-on:change="selectVegetable($event)"
        />
        <label v-bind:for="`supply-${supply.id}`">{{supply.name}}</label>
      </div>
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

  name: "supply-data",
  components: {},
  data() {
    return {
      supply: {
        supplyId: "",
        supplyName: "",
        supplyCost: ""
       },
       supplies: [],

    };
  },
  // methods: {
  //   selectSupply(event) {
  //     if (event.target.checked) {
  //       this.vegetable.description = this.$store.state.plants.filter(
  //         (plant) => {
  //           if (plant.id == event.target.value) {
  //             this.vegetable = plant;
  //             this.$store.commit("SET_VEGETABLE", this.vegetable);
  //           }
  //         }
  //       );
  //     } else {
  //       this.vegetable = null;
  //     }
  //   },
  // },
};
</script>

<style>
#supply-selector {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 25px;
}

#supplies {
  display: flex;
  flex-direction: column;
  height: 30vh;
  width: 90%;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-items: center;
}

.supply {
  display: flex;
  width: 18ch;
  align-items: center;
  /* margin: 3px 3px;
  background-color: #85a183;
  border: 1px solid #85a183;
  border-radius: 5px; */

}

.supply label {
  margin: 0px;
}
.checkboxes {
  width: 13px;
  margin-bottom: 5px;
}
</style>
