<template>
  <form>
    <h1>{{this.$store.state.garden.gardenName}}</h1>

    <h3>Select plots that you'd like to assign a vegetable to:</h3>

    <div id="gridView">
      <div class="row" v-for="i in rowCount" v-bind:key="i">
        <span class="squares" v-for="plot in itemCountInRow(i)" v-bind:key="plot.id">
          <input
            class="check"
            type="checkbox"
            v-bind:id="plot.plotNumber"
            v-on:change="selectPlot($event)"
            v-bind:checked="selectedPlots.includes(plot.plotNumber)"
          />
          {{plot.plotNumber}}_{{plot.plantId}}
        </span>
      </div>
<p>{{this.selectedPlots}}</p>

    </div>

    <div class="button-container">
      <a
        v-if="this.$store.state.vegetable.name != null && this.selectedPlots != ''"
        href="#"
        class="btn-update btn-garden"
        v-on:click.prevent="assignVegetableToPlots()"
      >Assign {{this.$store.state.vegetable.name}} to the Selected Plot{{this.selectedPlots.length > 1 ? 's' : ''}}</a>
      <h3
        v-else-if="this.$store.state.vegetable.name != null"
      >Select at Least 1 Plot from the Grid Above</h3>
      <h3
        v-else-if="this.selectedPlots != ''"
      >Select a Vegetable to Assign it to the Selected Plot{{this.selectedPlots.length > 1 ? 's' : ''}}</h3>
      <h3 v-else>Select at Least 1 Plot from the Grid Above and a Vegetable from the List Below</h3>
    
     <a
        href="#"
        class="btn-save-garden btn-garden"
        v-on:click.prevent="saveUpdates()"
      >Save Changes to Garden</a>
    
    </div>
  </form>
</template>

<script>
import GardenService from "@/services/GardenService";
import PlotService from "@/services/PlotService";

export default {
  name: "garden-details",
  data() {
    return {
      itemsPerRow: this.$store.state.garden.gardenWidth,

      plot: {
        plotNumber: 0,
        gardenId: this.$route.params.gardenid,
        plantId: 0,
      },
      selectedPlots: [],
      plotList: [],
      plotArray: "",
      assignedPlotArray: []
    };
  },
  created() {
    GardenService.getGardenById(this.$route.params.gardenid)
      .then((response) => {
        this.$store.commit("SET_GARDEN", response.data);

        this.loadArray();
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });
  },

  computed: {
    rowCount: function () {
      return Math.ceil(this.plotArray.length / this.itemsPerRow);
    },
  },
  methods: {
    itemCountInRow: function (index) {
      return this.plotArray.slice(
        (index - 1) * this.itemsPerRow,
        index * this.itemsPerRow
      );
    },

    selectPlot(event) {
      if (event.target.checked) {
        this.selectedPlots.push(parseInt(event.target.id));
      } else {
        this.selectedPlots = this.selectedPlots.filter((plot) => {
          return plot !== parseInt(event.target.id);
        });
      }
    },
    assignVegetableToPlots() {
  
      this.selectedPlots.forEach((id) => {
        this.plotArray.filter(plot => {
          if (plot.plotNumber == id) {
            plot.plantId = this.$store.state.vegetable.id;
          }
        });
      });
      this.selectedPlots = [];

    },

    saveUpdates() {
      PlotService.saveGardenPlots(this.plotArray, this.$route.params.gardenid)
        .then((response) => {
          if (response.status == 200) {
            this.plotArray = response.data;
            this.$store.commit("SET_PLOTS", response.data);
           //add router push potentially
          
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },


    saveGarden() {
      GardenService.addGarden(this.newGarden)
        .then((response) => {
          if (response.status == 200) {
            this.newGarden.gardenId = response.data.gardenId;
            this.$store.commit("SET_GARDEN", response.data);
            this.$router.push({
              name: "garden",
              params: { gardenid: this.newGarden.gardenId },
            });
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
      let plotsNum =
        this.$store.state.garden.gardenWidth *
        this.$store.state.garden.gardenLength;
      this.plotArray = new Array();
      for (var i = 0; i < plotsNum; i++) {
        let plot = {
          plotNumber: x++,
          gardenId: this.$route.params.gardenid,
          plantId: 0,
        };
        this.plotArray.push(plot);
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
  flex-direction: column;
  width: fit-content;
  justify-content: center;
  align-items: center;
  padding: 20px;
  border-radius: 20px;
  background-color: #381c06;
}

.row {
  display: flex;
}

.squares {
  display: flex;
  flex-grow: 1;
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

#gridViewTwo {
  display: flex;
  flex-wrap: wrap;
  width: fit-content;
  justify-content: center;
  align-items: center;
  padding: 20px;
  border-radius: 20px;
  background-color: green;
}
.squarestwo {
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

.block-it {
  display: inline-block;
}

.span-it {
  display: inline;
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

.button-container {
  display: flex;
  flex-grow: 1;
  justify-content: center;
  height: 2em;
  margin-top: 20px;
}

.btn-garden {
  color: #fff;
  text-align: center;
  width: 150px;
  border-radius: 15px;
  line-height: 1.7em;
  font-size: 1.1em;
  text-decoration: none;
  border-style: solid;
  margin: 0px 10px;
}

.btn-update {
  width: 370px;
  background-color: #e48438;
  border-color: #e48438;
}
.btn-update:hover {
  background-color: #85a183;
  border-color: #85a183;
}
</style>