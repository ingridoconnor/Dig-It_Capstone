<template>
  <form v-on:submit.prevent="addNewPlot">
    <div class="form-element">
      <label for="type"> Plant type: </label>
      <select id="type" type="option" class="form-control" v-model="plot.plant">
        <option value="carrots">Carrots</option>
        <option value="tomatoes">Tomatoes</option>
        <option value="lettuce">Lettuce</option>
      </select>
    </div>
    <div class="form-element">
            <label for="width">Garden Width: </label>
            <input id="width" type="number" v-model="newGarden.width" />
        </div>
        <div class="form-element">
            <label for="length">Garden Length: </label>
            <input id="length" type="number" v-model="newGarden.length" />
        </div>
        <div class="actions">
            <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
            <button>Submit</button>
        </div>
    <div class="form-element">
  </form>
</template>

<script>
export default {
  name: "plot-form",
  props: {
    plotID: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      plot: {
        type: "",
        width: "",
        length: ""
      }
    }
  },
  methods: {
    submitForm() {
      const newPlot = {
        gardenId: Number(this.$route.params.gardenId),
        type: this.plot.type,
        width: this.plot.width,
        length: this.plot.length
      };

      if (this.plotID === 0) {
        // add
        gardensService
          .addPlot(newPlot)
          .then(response => {
            if (response.status === 201) {
              this.$router.push(`/garden/${newPlot.gardenId}`);
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error submitting new plot. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error submitting new plot. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error submitting new plot. Request could not be created.";
            }
          });
      } else {
        // update
        newPlot.id = this.plotID;
        newPlot.date = this.car.date;
        gardensService
          .updatePlot(newPlot)
          .then(response => {
            if (response.status === 200) {
              this.$router.push(`/board/${newCard.boardId}`);
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error updating card. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error updating card. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error updating card. Request could not be created.";
            }
          });
      }
    },
   cancelForm() {
      this.$router.push(`/board/${this.$route.params.boardID}`);
    }
  },
  created() {
    if (this.cardID != 0) {
      gardensService
        .getCard(this.cardID)
        .then(response => {
          this.card = response.data;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Card not available. This card may have been deleted or you have entered an invalid card ID."
            );
            this.$router.push("/");
          }
        });
    }
  }
};
</script>

<style>

</style>