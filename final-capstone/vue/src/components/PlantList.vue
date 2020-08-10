<template>
  <form id="plant-selector">
    <div id="plants">
      <div class="plant" v-for="plant in this.$store.state.plants" v-bind:key="plant">
        <input
          type="radio"
          name="veggie"
          class="radios"
          v-bind:id="`Plant-${plant.id}`"
          v-bind:value="plant.id"
          v-on:change="selectVegetable($event)"
        />
        <label v-bind:for="`Plant-${plant.id}`">{{plant.name}}</label>
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

  name: "plant-data",
  components: {},
  data() {
    return {
      vegetable: {
        id: "",
        name: "",
        description: "",
        plantsPerSqFoot: "",
        sunRequirements: "",
        region: "",
        seedlingCost: "",
      },
    };
  },
  methods: {
    selectVegetable(event) {
      if (event.target.checked) {
        this.vegetable.description = this.$store.state.plants.filter(
          (plant) => {
            if (plant.id == event.target.value) {
              this.vegetable = plant;
              this.$store.commit("SET_VEGETABLE", this.vegetable);
            }
          }
        );
      } else {
        this.vegetable = null;
      }
    },
  },
};
</script>

<style>
#plant-selector {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 25px;
}

#plants {
  display: flex;
  flex-direction: column;
  height: 30vh;
  width: 90%;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-items: center;
}

.plant {
  display: flex;
  width: 18ch;
  align-items: center;
  /* margin: 3px 3px;
  background-color: #85a183;
  border: 1px solid #85a183;
  border-radius: 5px; */

}

.plant label {
  margin: 0px;
}
.radios {
  width: 13px;
  margin-bottom: 5px;
}
</style>
