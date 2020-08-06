<template>
  <form v-on:submit.prevent="addNewGarden">
    <div class="form-element">
      <label for="width">Garden Width in Feet:</label>
      <input id="width" type="number" min="1" v-on:change="changeSize" v-model="newGarden.width" />
    </div>
    <div class="form-element">
      <label for="length">Garden Length in Feet:</label>
      <input id="length" type="number" min="1" v-on:change="changeSize" v-model="newGarden.length" />
    </div>
    <p>{{this.sizeArray}}</p>

    <div id="gridView">
      <span class="width" v-for="arrays in this.sizeArray" v-bind:key="arrays">
        <div class="squares" v-for="height in arrays" v-bind:key="height">{{height}}</div>
      </span>
    </div>

    <div class="actions">
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
      <button>Submit</button>
    </div>
  </form>
</template>

<script>
export default {
  name: "add-garden",
  data() {
    return {
      newGarden: {
        id: 0,
        width: 1,
        length: 1,
      },
      sizeArray: "",
    };
  },
  methods: {
    addNewGarden() {
      const gardenID = this.$route.params.id;
      this.newGarden.id = gardenID;
      this.$store.commit("ADD_GARDEN", this.newGarden);
    },
    resetForm() {
      this.newGarden = {};
    },
    changeSize() {
      var x = 1;

      // Create 1D array
      this.sizeArray = new Array(this.newGarden.width);

      // Loop to create 2D array using 1D array
      for (var w = 0; w < this.newGarden.width; w++) {
        this.sizeArray[w] = new Array(this.newGarden.length);
      }

      // Loop to Fill In 2D array elements with Numbers.
      for (var wi = 0; wi < this.newGarden.width; wi++) {
        for (var l = 0; l < this.newGarden.length; l++) {
          this.sizeArray[wi][l] = x++;
        }
      }
    },
  },
};
</script>

<style>
#gridView {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  border-radius: 20px;
  background-color: #422207b7;

}

.width {
    display: flex;
    flex-direction: column;

}

.squares {
display: grid;
align-content: center;
  min-height: 50px;
  max-height: 100px;
  min-width: 50px;
  max-width: 100px;

  text-align: center;
  


  background-color: rgb(158, 110, 48);
  border: 2px;
  border-style: solid;
  border-color: #422207b7;
}
</style>