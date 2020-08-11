<template>


  <form v-on:submit.prevent="submitForm" class="editplant">
    <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    <div class="form-group">

      <div v-for="plant in this.$store.state.plants" v-bind:key="plant">
        <input type="radio" >  {{plant.name}} 
      </div>
     
      <label for="plantname">Plant name: </label>
      <input id="plantname" type="text" class="form-control" v-model="plant.name" autocomplete="off" />
      
      <label for="description">Description: </label>
      <input id="description" type="text" class="form-control" v-model="plant.description" autocomplete="off" />
      
      <label for="plantspersq">Plants per square foot: </label>
      <input id="plantspersq" type="text" class="form-control" v-model="plant.plantspersq" autocomplete="off" />  
    
      <label for="sunrequirements">Sun Requirements: </label>
      <input id="sunrequirements" type="text" class="form-control" v-model="plant.sunrequirements" autocomplete="off" />  
    
      <label for="region">Region: </label>
      <input id="region" type="text" class="form-control" v-model="plant.region" autocomplete="off" />  
    
      <label for="cost">Seedling cost: </label>
      <input id="cost" type="text" class="form-control" v-model="plant.cost" autocomplete="off" />  
    
    
    </div>
    
    
    <button class="btn-submit" type="submit">Submit</button>
    <button class="btn-cancel" v-on:click.prevent="cancelForm" type="cancel">Cancel</button>
  </form>

</template>



<script>
import plantService from "../services/PlantService";


export default {
  name: "edit-plant",
  
  data() {
    return {
      plant: {

        name: this.$store.state.plant.data.name,
        description: this.$store.state.plant.data.description,
        plantspersq: this.$store.state.plant.data.plantspersq,
        sunrequirements: this.$store.state.plant.data.sunrequirements,
        region: this.$store.state.plant.data.region,
        cost: this.$store.state.plant.data.cost,
        id: this.$store.state.plant.data.id

      },
      
      errorMsg: ""
    };
  },
  methods: {
    submitForm() {
      
        plantService
          .updatePlantInfo(this.plant)
          .then(response => {
            if (response.status === 200) {
              this.$store.commit("SET_PLANT_DATA", response);
              this.$router.push(`/editplant/`);
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error updating info. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error updating info. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error updating info. Request could not be created.";
            }
          });
      
    },
    cancelForm() {
      this.$router.push(`/editplant/`);
    }
  },
  created() {
    if (this.id != 0) {
      plantService
        .getUserInfo(this.id)
        .then(response => {
          this.user = response.data;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Plant not available. This plant may have been deleted or you have entered invalid info."
            );
            this.$router.push("/");
          }
        });
    }
  }
};
</script>


<style>
.cardForm {
  padding: 10px;
  margin-bottom: 10px;
}
.form-group {
  margin-bottom: 10px;
  margin-top: 10px;
}
label {
  display: inline-block;
  margin-bottom: 0.5rem;
}
.form-control {
  display: block;
  width: 80%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}

.btn-submit {
  color: #fff;
  background-color: #e48438;
  border-color: #e48438;
  width: 150px;
  margin-right: 5px;
  border-radius: 5px; 
}
.btn-cancel {
  color: #fff;
  background-color: #307C55;
  border-color: #307C55;
  width: 150px;
  border-radius: 5px; 
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

.button {
  padding: 20px;
  height: 28px;
  border-radius: 28px;
  width: 80px;
  margin-left: 20px;
  color: white;
  font-size: 1.2em;
  font-weight: 200;
  text-align: center;
  text-decoration: none;
  align-items: center;
  background-color: #e48438 ;
}


</style>
