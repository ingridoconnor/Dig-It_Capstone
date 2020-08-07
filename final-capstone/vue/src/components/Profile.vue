<template>
  <div>
    <div>
      <p>Gardens: <span v-for="garden in this.$store.state.gardens" v-bind:key="garden"> {{garden.gardenName}} </span></p>
      <p>Username: {{this.$store.state.user.username}}</p>
      <p>ID: {{this.$store.state.userData.data.id}}</p>
      <p>First Name: {{this.$store.state.userData.data.firstName}}</p>
      <p>Last Name: {{this.$store.state.userData.data.lastName}}</p>
      <p>Email: {{this.$store.state.userData.data.email}}</p>
      <p>City: {{this.$store.state.userData.data.city}}</p>
      <p>State: {{this.$store.state.userData.data.state}}</p>
      <p>Zip: {{this.$store.state.userData.data.zipcode}}</p>
      <p>Region: {{this.$store.state.userData.data.region}}</p>
        <router-link
        tag="button"
        :to="{ name: 'EditProfile', params: {cardID: $route.params.cardID} }"
        class="button"
      >Edit Profile</router-link>
      <button class="button" v-on:click="deleteProfile">Delete Profile</button>
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      
  <router-link :to="{name: 'add-garden'}" >Add a Garden</router-link>
    </div>
  </div>
</template>

<script>
import UserService from "../services/UserService";

export default {
  created() {
    UserService.getUserInfo(this.$store.state.user.id)
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
};
</script>

<style>

</style>
