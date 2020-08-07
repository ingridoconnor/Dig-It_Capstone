<template>
  <form v-on:submit.prevent="addNewGarden">
    <h1>Add New Garden</h1>

    <div class="form-element">
      <label for="name">Garden Name:</label>
      <input id="name" type="text" v-model="newGarden.gardenName" />
    </div>

    <div class="form-element">
      <label for="width">Garden Width in Feet:</label>
      <input id="width" type="number" min="1" v-on:change="changeSize" v-model="newGarden.gardenWidth" />
    </div>

    <div class="form-element">
      <label for="length">Garden Length in Feet:</label>
      <input id="length" type="number" min="1" v-on:change="changeSize" v-model="newGarden.gardenLength" />
    </div>

    <p class="temp">For reference during programming only: {{this.sizeArray}}</p>

    <div id="gridView">
      <span class="width" v-for="arrays in this.newGarden.sizeArray" v-bind:key="arrays">
        <!--  ADD CHECK ALL COLUMN BUTTONS IF TIME PERMITS
                 <input  class="float" type="checkbox">

        -->
        <div class="squares" v-for="height in arrays" v-bind:key="height">
          {{height}}
          <input class="check" type="checkbox" />
        </div>
      </span>
    </div>

    <div class="actions">
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
      <button>Submit</button>
    </div>
<p>Garden ID for Testing:  {{this.newGarden.gardenId}}</p>

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
        gardenLength: 2,
        sizeArray: [
          [1, 2],
          [3, 4],
        ],
      },
    };
  },
  methods: {
    addNewGarden() {
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
      this.newGarden = {};
    },
    changeSize() {
      var x = 1;

      // Create 1D array
      this.newGarden.sizeArray = new Array(this.newGarden.gardenWidth);

      // Loop to create 2D array using 1D array
      for (var w = 0; w < this.newGarden.gardenWidth; w++) {
        this.newGarden.sizeArray[w] = new Array(this.newGarden.gardenLength);
      }

      // Loop to Fill In 2D array elements with Numbers.
      for (var wi = 0; wi < this.newGarden.gardenWidth; wi++) {
        for (var l = 0; l < this.newGarden.gardenLength; l++) {
          this.newGarden.sizeArray[wi][l] = x++;
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

input {
  width: 5ch;
}

#name {
  width: 20ch;
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