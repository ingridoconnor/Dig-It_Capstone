<template>
  <div>
    <div>

      <p>City: {{this.$store.state.userData.data.city}}</p>
      <p>State: {{this.$store.state.userData.data.state}}</p>
      <p>Zip: {{this.$store.state.userData.data.zipcode}}</p>
      <p>Zone Name: {{this.$store.state.userData.data.region}}</p>
      <p>Start of Growing Season: {{this.$store.state.zone.lastFrostMonth}} {{this.$store.state.zone.lastFrostDay}}</p>
      <p>End of Growing Season: {{this.$store.state.zone.firstFrostMonth}} {{this.$store.state.zone.firstFrostDay}}</p>
      <p>Average Annual Number of Growing Days: {{this.$store.state.zone.avgGrowingDays}}</p>

    </div>
    <img src="../img/grow_zones.png" alt="grow zones map">

      
  <router-link :to="{ name: 'add-garden' }" >Add a Garden</router-link>
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

  name: "zone-data",
  components: {},
  data() {
    return {};
  },
};
</script>

<style>

</style>
