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

    <img class="zonemap" src="../img/zone3.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '3a' || this.$store.state.userData.data.region == '3b'">
    <img class="zonemap" src="../img/zone4.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '4a' || this.$store.state.userData.data.region == '4b'">
    <img class="zonemap" src="../img/zone5.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '5a' || this.$store.state.userData.data.region == '5b'">
    <img class="zonemap" src="../img/zone6.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '6a' || this.$store.state.userData.data.region == '6b'">
    <img class="zonemap" src="../img/zone7.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '7a' || this.$store.state.userData.data.region == '7b'">
    <img class="zonemap" src="../img/zone8.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '8a' || this.$store.state.userData.data.region == '8b'">
    <img class="zonemap" src="../img/zone9.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '9a' || this.$store.state.userData.data.region == '9b'">
    <img class="zonemap" src="../img/zone10.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '10a' || this.$store.state.userData.data.region == '10b'">

      
  <router-link :to="{ name: 'add-garden' }" >Add a Garden</router-link>
  </div>
</template>

<script>
// import UserService from "../services/UserService";

export default {
//   created() {
//     UserService.getUserInfo(this.$store.state.user.id)
//       .then((response) => {
//         this.$store.commit("SET_USER_DATA", response);
//       })
//       .catch((error) => {
//         if (error.response && error.response.status === 404) {
//           alert("User Data not available.");
//           this.$router.push("/");
//         }
//       });
//   },

  name: "zone-data",
  components: {},
  data() {
    return {};
  },
};
</script>

<style>

    .zonemap {
        width: 400px;
    }

</style>
