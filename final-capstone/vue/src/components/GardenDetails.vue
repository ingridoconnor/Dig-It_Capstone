<template>
  <form id="garden-grid-form">
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
    </div>

    <div class="button-container">
      <div class="center-it">
        <a
          v-if="this.$store.state.vegetable.name != null && this.selectedPlots != ''"
          href="#"
          class="btn-update btn-garden"
          v-on:click.prevent="assignVegetableToPlots()"
        >Assign {{this.$store.state.vegetable.name}} to the Selected Plot{{this.selectedPlots.length > 1 ? 's' : ''}}</a>
        <h3
          class="the-directions"
          v-else-if="this.$store.state.vegetable.name != null"
        >Select at Least 1 Plot from the Grid Above to Start Assigning Plants</h3>
       
      </div>
      <div class="center-it">
        <a
          href="#"
          class="btn-save-garden btn-garden"
          v-if="updatesMade"
          v-on:click.prevent="saveUpdates()"
        >Save Changes to Garden</a>
      </div>
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
      itemsPerRow: 0,
      updatesMade: false,

      plot: {
        plotNumber: 0,
        gardenId: this.$route.params.gardenid,
        plantId: 1,
      },
      selectedPlots: [],
      plotList: [],
      plotArray: "",
      assignedPlotArray: [],
    };
  },
  created() {
    GardenService.getGardenById(this.$route.params.gardenid)
      .then((response) => {
        this.$store.commit("SET_GARDEN", response.data);
        this.itemsPerRow = this.$store.state.garden.gardenWidth;
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });

    PlotService.getPlotsByGardenId(this.$route.params.gardenid)
      .then((response) => {
        if (
          response.data.length ===
          this.$store.state.garden.gardenWidth *
            this.$store.state.garden.gardenLength
        ) {
          this.$store.commit("SET_PLOTS", response.data);
          this.plotArray = response.data;
        } else {
          this.loadArray();
        }
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
        this.plotArray.forEach((plot) => {
          if (plot.plotNumber == id) {
            plot.plantId = this.$store.state.vegetable.id;
          }
        });
      });
      this.selectedPlots = [];
      this.updatesMade = true;
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
          plantId: 1,
        };
        this.plotArray.push(plot);
      }
    },
  },
};
</script>

<style scoped>
.garden-grid-form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
    flex-grow: 1;
  width: 100%;
}

#gridView {
  display: flex;
  flex-direction: column;
  width: 95%;
  height: 500px;
  justify-content: center;
  align-items: center;
  padding: 20px;
  border-radius: 20px;
  background-color: #381c06;
}

.row {
  display: flex;
  width: 100%;
  height: 100%;
}

.squares {
  display: flex;
  flex-grow: 1;
  align-items: center;
  justify-content: center;
  max-width: 500px;
  max-height: 500px;

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

.button-container {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  justify-content: center;
  height: 2em;
  margin-top: 20px;
  margin-bottom: 20px;
}

.center-it,
.the-directions {
  display: flex;
  justify-content: center;
  text-justify: center;
  flex-grow: 1;
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
.btn-update:hover,
.btn-save-garden:hover {
  background-color: #e48438;
  border-color: #e48438
}

.btn-save-garden {
  width: 370px;
  background-color: #307c55;
  border-color: #307c55;
}
</style>