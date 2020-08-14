<template>
  <form v-on:submit.prevent="submitForm" id="editplant">
    <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    
    <div class="form-group-edit-plant">
      <div class="field-container-plants">
        <label class="label-plant-form" for="plantname">Plant name:</label>
        <input
          id="plantname"
          type="text"
          class="form-control-edit-plant"
          v-model="plant.name"
          autocomplete="off"
        />
      </div>
      <div class="field-container-plants">
        <label class="label-plant-form"  for="description">Description:</label>
        <input
          id="description"
          type="text"
          class="form-control-edit-plant"
          v-model="plant.description"
          autocomplete="off"
        />
      </div>
      <div class="field-container-plants">
        <label class="label-plant-form"  for="plantspersq">Plants per square foot:</label>
        <input
          id="plantspersq"
          type="text"
          class="form-control-edit-plant"
          v-model="plant.plantsPerSqFoot"
          autocomplete="off"
        />
      </div>
      <div class="field-container-plants">
        <label class="label-plant-form"  for="sunrequirements">Sun Requirements:</label>
        <input
          id="sunrequirements"
          type="text"
          class="form-control-edit-plant"
          v-model="plant.sunRequirements"
          autocomplete="off"
        />
      </div>
      <div class="field-container-plants">
        <label class="label-plant-form"  for="region">Region:</label>
        <input
          id="region"
          type="text"
          class="form-control-edit-plant"
          v-model="plant.region"
          autocomplete="off"
        />
      </div>
      <div class="field-container-plants">
        <label class="label-plant-form"  for="cost">Seedling cost:</label>
        <input
          id="cost"
          type="text"
          class="form-control-edit-plant"
          v-model="plant.seedlingCost"
          autocomplete="off"
        />
      </div>
    </div>

    <div class="button-container-edit-plant">
      <a href="#" @click.prevent="submitForm" class="btn-submit-profile">Submit</a>
      <a href="#" v-on:click.prevent="cancelForm" class="btn-submit-profile-cancel">Cancel</a>
    </div>
  </form>
</template>



<script>
import plantService from "../services/PlantService";

export default {
  name: "edit-plant",

  data() {
    return {
      plant: {
        name: this.$store.state.vegetable.name,
        description: this.$store.state.vegetable.description,
        plantsPerSqFoot: this.$store.state.vegetable.plantsPerSqFoot,
        sunRequirements: this.$store.state.vegetable.sunRequirements,
        region: this.$store.state.vegetable.region,
        seedlingCost: this.$store.state.vegetable.seedlingCost,
        id: this.$store.state.vegetable.id,
      },

      errorMsg: "",
    };
  },
  methods: {
    submitForm() {
      plantService
        .updatePlantInfo(this.plant)
        .then((response) => {
          if (response.status === 200) {
            alert("Your changes have been made.");
            this.$router.push(`/admin/home`);
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg =
              "Error updating info. Response received was '" +
              error.response.statusText +
              "'.";
          } else if (error.request) {
            this.errorMsg = "Error updating info. Server could not be reached.";
          } else {
            this.errorMsg =
              "Error updating info. Request could not be created.";
          }
        });
    },
    cancelForm() {
      this.$router.push(`/admin/home`);
    },
  },
};
</script>


<style>
#editPlant {
  display: flex;
  flex-grow: 1;
    width: 100%;
}

.form-group-edit-plant {
  display: flex;
  flex-direction: column;
  width: 100%;
  margin-bottom: 10px;
  margin-top: 10px;
}

.field-container-edit-plants {
  display: flex;
  flex-direction: row;
  flex-grow: 1;
  width: 100%;
}

.label-plant-form {
  display: flex;
  flex-grow: 1;

}
.form-control-edit-plant {
  display: flex;
  width: 100ch; 
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-control-edit-plant {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}

.button-container-edit-plant {
display: flex;
flex-grow: 1;
width: 100%;
}


.status-message {
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
}


</style>
