<template>
  <div>
    <div>
      <p>Gardens: <span v-for="garden in this.$store.state.gardens" v-bind:key="garden"> {{garden.newGarden.gardenName}} </span></p>
      <p>Username: {{this.$store.state.user.username}}</p>
      <p>ID: {{this.$store.state.userData.data.id}}</p>
      <p>First Name: {{this.$store.state.userData.data.firstName}}</p>
      <p>Last Name: {{this.$store.state.userData.data.lastName}}</p>
      <p>Email: {{this.$store.state.userData.data.email}}</p>
      <p>City: {{this.$store.state.userData.data.city}}</p>
      <p>State: {{this.$store.state.userData.data.state}}</p>
      <p>Zip: {{this.$store.state.userData.data.zipcode}}</p>
      <p>Region: {{this.$store.state.userData.data.region}}
        <router-link class="zonelink" :to="{ name: 'zone'}">View my region details</router-link>
      </p>
        
        <router-link
        tag="button"
        :to="{ name: 'edit-profile', params: {userID: $route.params.userID} }"
        class="btn-submit"
      >Edit Profile</router-link>

      <button class="btn-cancel" v-on:click="deleteUser">Delete Profile</button>
      
      


  <router-link :to="{name: 'add-garden'}" >Add a Garden</router-link>
    </div>
  </div>
</template>

<script>
import userService from "../services/UserService";
//import profileForm from "../components/ProfileForm";

export default {
  created() {
    userService.getUserInfo(this.$store.state.user.id)
      .then((response) => {
        this.$store.commit("SET_USER_DATA", response);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("User Data not available.");
          this.$router.push("/");
        }
      });
  },

  name: "profile-data",
  components: {},
  data() {
    return {};
  },
 methods: {
    deleteUser() {
      if (
        confirm(
          "Are you sure you want to delete this user? This action cannot be undone."
        )
      ) {
        userService
          .deleteUser(this.user.id)
          .then(response => {
            if (response.status === 200) {
              alert("User successfully deleted");
              this.$router.push(`/`);
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error deleting user. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting user. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting user. Request could not be created.";
            }
          });
      }
    }
  }
};
</script>

<style>
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
</style>
