<template>
  <form v-on:submit.prevent="updatePlots">

<p>{{this.$route.params.gardenid}}</p>


    <h1>{{this.$store.state.garden.gardenName}}</h1>
    <h1>{{this.$store.state.garden.gardenWidth}}</h1>
        <h1>{{this.$store.state.garden.gardenLength}}</h1>
            <h1>{{this.$store.state.garden.gardenId}}</h1>
    <div id="gridView">
      <span class="width" v-for="arrays in this.plotArray" v-bind:key="arrays">

                 <input  class="float check" type="checkbox">


        <div class="squares" v-for="height in arrays" v-bind:key="height" >
          {{height}}
          <input class="check" type="checkbox" />
        </div>
      </span>
    </div>

    <div class="actions">
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
      <button>Update</button>
    </div>


  </form>
</template>

<script>
import GardenService from "@/services/GardenService";

export default {
  name: "garden-details",
  data() {
    return {
      newPlot: {
        gardenId: 0,
        width: 1,
        length: 1,
        vegatableId: ""
      },
      PlotList: [],
      plotArray: ""
    };
  },
  created() {
      if (this.$state.store.garden.gardenId === 0) {
      
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
      }
      
      this.loadArray;
  },
  methods: {
    updatePlots() {
      GardenService.addGarden(this.newGarden)
        .then((response) => {
          if (response.status == 200) {
            this.newGarden.gardenId = response.data.gardenId;
            this.$store.commit("SET_GARDEN", response.data);
            this.$router.push({ name: "garden", params: { gardenid: this.newGarden.gardenId } });

          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });


    },
    resetForm() {
      this.newPlot = "";
      this.newPlots = [];
    },
    loadArray() {
      var x = 1;

      // Create 1D array
      this.plotArray = new Array(this.$store.state.garden.gardenWidth);

      // Loop to create 2D array using 1D array
      for (var w = 0; w < this.$store.state.garden.gardenWidth; w++) {
        this.plotArray[w] = new Array(this.$store.state.garden.gardenLength);
      }

      // Loop to Fill In 2D array elements with Numbers.
      for (var wi = 0; wi < this.$store.state.garden.gardenWidth; wi++) {
        for (var l = 0; l < this.$store.state.garden.gardenLength; l++) {
          this.plotArray[wi][l] = x++;
        }
      }
    },
  },
};
</script>

<style scoped>
form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

#gridView {
  display: flex;
  width: fit-content;
  justify-content: center;
  align-items: center;
  padding: 20px;
  border-radius: 20px;
  background-color: #381c06;
}




.width {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-items: center;
}

.squares {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 50px;
  max-height: 100px;
  min-width: 50px;
  max-width: 100px;
  text-align: center;
  background-color: rgb(165, 112, 42);
  border: 2px;
  border-style: solid;
  border-color: #381c06;
}

.check {
  display: inline-block;
  align-content: center;
  justify-content: center;
  width: 15px;
  height: 15px;
}

.temp {
  color: red;
}
</style>