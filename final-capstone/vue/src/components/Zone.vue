<template>
  <div>
    
    <div class="map">
      <h1>Your Plant Hardiness Zone</h1>
        <h1>Zone {{this.$store.state.userData.data.region}}</h1>
        <img class="zonemap" src="../img/zonemaps/zone3.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '3a' || this.$store.state.userData.data.region == '3b'">
        <img class="zonemap" src="../img/zonemaps/zone4.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '4a' || this.$store.state.userData.data.region == '4b'">
        <img class="zonemap" src="../img/zonemaps/zone5.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '5a' || this.$store.state.userData.data.region == '5b'">
        <img class="zonemap" src="../img/zonemaps/zone6.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '6a' || this.$store.state.userData.data.region == '6b'">
        <img class="zonemap" src="../img/zonemaps/zone7.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '7a' || this.$store.state.userData.data.region == '7b'">
        <img class="zonemap" src="../img/zonemaps/zone8.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '8a' || this.$store.state.userData.data.region == '8b'">
        <img class="zonemap" src="../img/zonemaps/zone9.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '9a' || this.$store.state.userData.data.region == '9b'">
        <img class="zonemap" src="../img/zonemaps/zone10.png" alt="grow zones map" v-if="this.$store.state.userData.data.region == '10a' || this.$store.state.userData.data.region == '10b'">
      <h2>{{this.$store.state.userData.data.city}}, {{this.$store.state.userData.data.state}}, {{this.$store.state.userData.data.zipcode}}</h2>
      <h3>Start of Growing Season: {{this.$store.state.zone.lastFrostMonth}} {{this.$store.state.zone.lastFrostDay}}</h3>
      <h3>End of Growing Season: {{this.$store.state.zone.firstFrostMonth}} {{this.$store.state.zone.firstFrostDay}}</h3>
      <h3>Average Annual Number of Growing Days: {{this.$store.state.zone.avgGrowingDays}}</h3>
    </div>

    <div>
      


    </div>

    <div>
      <br>
        <h1 id="zone3" v-show="mapValue == '3'">Zone {{mapValue}}</h1>
        <img class="zonemap" src="../img/zonemaps/zone3.png" alt="grow zones map" v-show="mapValue == '3'">
        <h1 id="zone4" v-show="mapValue == '4'">Zone {{mapValue}}</h1>
        <img class="zonemap" src="../img/zonemaps/zone4.png" alt="grow zones map" v-show="mapValue == '4'">
        <h1 id="zone5" v-show="mapValue == '5'">Zone {{mapValue}}</h1>
        <img class="zonemap" src="../img/zonemaps/zone5.png" alt="grow zones map" v-show="mapValue == '5'">
        <h1 id="zone6" v-show="mapValue == '6'">Zone {{mapValue}}</h1>
        <img class="zonemap" src="../img/zonemaps/zone6.png" alt="grow zones map" v-show="mapValue == '6'">
        <h1 id="zone7" v-show="mapValue == '7'">Zone {{mapValue}}</h1>
        <img class="zonemap" src="../img/zonemaps/zone7.png" alt="grow zones map" v-show="mapValue == '7'">
        <h1 id="zone8" v-show="mapValue == '8'">Zone {{mapValue}}</h1>
        <img class="zonemap" src="../img/zonemaps/zone8.png" alt="grow zones map" v-show="mapValue == '8'">
        <h1 id="zone9" v-show="mapValue == '9'">Zone {{mapValue}}</h1>
        <img class="zonemap" src="../img/zonemaps/zone9.png" alt="grow zones map" v-show="mapValue == '9'">
        <h1 id="zone10" v-show="mapValue == '10'">Zone {{mapValue}}</h1>
        <img class="zonemap" src="../img/zonemaps/zone10.png" alt="grow zones map" v-show="mapValue == '10'">
        
        <p>See other Hardiness Zones</p>
        <select name="mapValue" id="hzones" v-model="mapValue">
          <option selected disabled value="0">Choose Zone</option>
          <option value="3">Zones 3A and 3B</option>
          <option value="4">Zones 4A and 4B</option>
          <option value="5">Zones 5A and 5B</option>
          <option value="6">Zones 6A and 6B</option>
          <option value="7">Zones 7A and 7B</option>
          <option value="8">Zones 8A and 8B</option>
          <option value="9">Zones 9A and 9B</option>
          <option value="10">Zones 10A and 10B</option>
        </select>
    </div>

  </div>
</template>

<script>



  import ZoneService from "../services/ZoneService";
  import userService from "../services/UserService";

export default {
  created() {
    ZoneService.getZoneInfo(this.$store.state.user)
      .then((response) => {
        this.$store.commit("SET_ZONE", response);
      });
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

  name: "zone-data",
  components: {},

  data() {
    return {
      mapValue: "",
      zone: {
        zoneName: "",
        lastFrostMonth: "",
        lastFrostDay: "",
        firstFrostMonth: "",
        firstFrostDay: "",
        avgGrowingDays: ""
    },
    };

  },
};
</script>

<style>

    .zonemap {
      text-align: center;
      width: 400px;
      display: inline-block;
    }

    h3 {
      text-align: left;
      padding-left: 100px;
    }

    #hzones {
      cursor: pointer;
    }

    .map {
      text-align: center;
      background-color: #85A183;
      border-radius: 50px;
      margin: 0px 100px 0px 100px;
      padding: 50px 0px 50px 0px;
    }

    #zone3 {
      font-size: 45px;
      color: #E58BE1;
      text-shadow: 3px 3px 3px #5f5f5f;
    }

    #zone4 {
      font-size: 45px;
      color: #886FB1;
      text-shadow: 3px 3px 3px #5f5f5f;
    }
    
    #zone5 {
      font-size: 45px;
      color: #80ACFB;
      text-shadow: 3px 3px 3px #5f5f5f;
    }

    #zone6 {
      font-size: 45px;
      color: #49AD4B;
      text-shadow: 3px 3px 3px #5f5f5f;
    }

    #zone7 {
      font-size: 45px;
      color: #AFE651;
      text-shadow: 3px 3px 3px #5f5f5f;
    }

    #zone8 {
      font-size: 45px;
      color: #F9EA61;
      text-shadow: 3px 3px 3px #5f5f5f;
    }

    #zone9 {
      font-size: 45px;
      color: #DFBA45;
      text-shadow: 3px 3px 3px #5f5f5f;
    }

    #zone10 {
      font-size: 45px;
      color: #E48028;
      text-shadow: 3px 3px 3px #5f5f5f;
    }

</style>
