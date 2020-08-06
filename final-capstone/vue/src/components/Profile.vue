<template>
  <div>
    <div>
      <p>Username: {{this.$store.state.user.username}}</p>
      <p>First Name: {{this.$store.state.userData.data.firstName}}</p>
      <p>Last Name: {{this.$store.state.userData.data.lastName}}</p>
      <p>Email: {{this.$store.state.userData.data.email}}</p>
      <p>City: {{this.$store.state.userData.data.city}}</p>
      <p>State: {{this.$store.state.userData.data.state}}</p>
      <p>Zip: {{this.$store.state.userData.data.zipcode}}</p>
      <p>Region: {{this.$store.state.userData.data.region}}</p>

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
