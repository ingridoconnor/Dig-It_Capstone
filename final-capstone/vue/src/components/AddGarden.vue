<template>
  <form v-on:submit.prevent="addNewGarden">
    <h1>Add New Garden</h1>

    <div class="form-element">
      <label for="name">Garden Name:</label>
      <input id="name" type="text" v-model="newGarden.gardenName" />
    </div>

    <div class="form-element">
      <label for="width">Garden Width in Feet:</label>
      <input
        id="width"
        type="number"
        min="1"
        v-on:change="changeSize"
        v-model="newGarden.gardenWidth"
      />
    </div>

    <div class="form-element">
      <label for="length">Garden Length in Feet:</label>
      <input
        id="length"
        type="number"
        min="1"
        v-on:change="changeSize"
        v-model="newGarden.gardenLength"
      />
    </div>

    <div id="gridView">
      <div class="row" v-for="i in rowCount" v-bind:key="i">
        <span
          class="squares"
          v-for="plot in itemCountInRow(i)"
          v-bind:key="plot"
        >{{plot.plotNumber}}</span>
      </div>
    </div>

    <div class="actions">
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
      <button>Submit</button>
    </div>
  </form>
</template>

<script>
import GardenService from "@/services/GardenService";

export default {
  name: "add-garden",
  data() {
    return {
      newGarden: {
        userId: this.$store.state.userData.data.id,
        gardenId: 0,
        gardenName: "",
        gardenWidth: 2,
        gardenLength: 2
      },

        sizeArray: [
          {
            plotNumber: 1,
            gardenId: 0,
            vegetableId: 0,
          },
          {
            plotNumber: 2,
            gardenId: 0,
            vegetableId: 0,
          },
          {
            plotNumber: 3,
            gardenId: 0,
            vegetableId: 0,
          },
          {
            plotNumber: 4,
            gardenId: 0,
            vegetableId: 0,
          }
        ],
      
    };
  },

  computed: {
    rowCount() {
      return Math.ceil(this.sizeArray.length / this.newGarden.gardenWidth);
    }
  },

  methods: {
    itemCountInRow(index) {
      return this.sizeArray.slice(
        (index - 1) * this.newGarden.gardenWidth,
        index * this.newGarden.gardenWidth
      );
    },
    addNewGarden() {
      GardenService.addGarden(this.newGarden)
        .then((response) => {
          if (response.status == 200) {
            this.newGarden.gardenId = response.data.gardenId;
            this.$store.commit("ADD_GARDEN", response.data);
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
      this.newGarden.gardenName = "";
      this.newGarden.gardenWidth = 2;
      this.newGarden.gardenLength = 2;
      this.newGarden.sizeArray = [
        [1, 2],
        [3, 4],
      ];
    },
    changeSize() {
      var x = 1;
      let plotsNum = this.newGarden.gardenWidth * this.newGarden.gardenLength;
      this.sizeArray = new Array();
      for (var i = 0; i < plotsNum; i++) {
        let plot = {
          plotNumber: x++,
          gardenId: 0,
          vegetableId: 0,
        };
        this.sizeArray.push(plot);
      }
    }
  }
};
</script>

<style >
form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

#gridView {
display: flex;
flex-direction: column;
flex-grow: 1;
  width: fit-content;
  justify-content: center;
  align-items: center;
  padding: 20px;
  border-radius: 20px;
  background-color: #381c06;
}

input {
  width: 5ch;
}

#name {
  width: 20ch;
}

.row {
  display: flex;
}

.squares  {
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
</style>