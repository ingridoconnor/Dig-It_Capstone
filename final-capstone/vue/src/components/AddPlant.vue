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
  name: "add-plant",
  
  data() {
    return {
      plant: {

        name: "",
        description: "",
        plantsPerSqFoot: "",
        sunRequirements: "",
        region: "",
        seedlingCost: "",
        id: ""

      },
      
      errorMsg: ""
    };
  },
  methods: {
    submitForm() {
      
        plantService
          .addPlant(this.plant)
          .then(response => {
            if (response.status === 200) {
              alert("Your plant has been added.");
              this.$router.push(`/admin/home`);
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error adding plant. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error adding plant. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error adding plant. Request could not be created.";
            }
          });
      
    },
    cancelForm() {
      this.$router.push(`/admin/home`);
    }
  }
};
</script>


<style>

</style>
