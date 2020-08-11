<template>
  <div class="page">
    
    <div class="map">
      <div>
          <p class="description">The plant hardiness zone is a standard that gardeners use to determine which plants are most likely to thrive at a given location.  The hardiness zone of your region is determined by the average annual extreme minimum temperature</p>
          <p class="description">It's important to know which zone your garden is in before deciding which vegetables to grow</p>
        <h1>Your Plant Hardiness Zone</h1>
          <img class="zonemap" src="../img/zonemaps/zone3.png" alt="grow zones map" v-if="this.$store.state.userData.region == '3a' || this.$store.state.userData.region == '3b'">
          <img class="zonemap" src="../img/zonemaps/zone4.png" alt="grow zones map" v-if="this.$store.state.userData.region == '4a' || this.$store.state.userData.region == '4b'">
          <img class="zonemap" src="../img/zonemaps/zone5.png" alt="grow zones map" v-if="this.$store.state.userData.region == '5a' || this.$store.state.userData.region == '5b'">
          <img class="zonemap" src="../img/zonemaps/zone6.png" alt="grow zones map" v-if="this.$store.state.userData.region == '6a' || this.$store.state.userData.region == '6b'">
          <img class="zonemap" src="../img/zonemaps/zone7.png" alt="grow zones map" v-if="this.$store.state.userData.region == '7a' || this.$store.state.userData.region == '7b'">
          <img class="zonemap" src="../img/zonemaps/zone8.png" alt="grow zones map" v-if="this.$store.state.userData.region == '8a' || this.$store.state.userData.region == '8b'">
          <img class="zonemap" src="../img/zonemaps/zone9.png" alt="grow zones map" v-if="this.$store.state.userData.region == '9a' || this.$store.state.userData.region == '9b'">
          <img class="zonemap" src="../img/zonemaps/zone10.png" alt="grow zones map" v-if="this.$store.state.userData.region == '10a' || this.$store.state.userData.region == '10b'">
          <h1>Zone {{this.$store.state.userData.region}}</h1>
        <h2>{{this.$store.state.userData.city}}, {{this.$store.state.userData.state}} {{this.$store.state.userData.zipcode}}</h2>
      <h3>The Growing Season starts {{this.$store.state.zone.avgLastFrostMonth}} {{this.$store.state.zone.avgLastFrostDay}} and ends {{this.$store.state.zone.avgFirstFrostMonth}} {{this.$store.state.zone.avgFirstFrostDay}}</h3>
      <h3>On average, there are {{this.$store.state.zone.avgGrowingDays}} growing days per year</h3>
    </div>
    <div class="info">
          <h3>Suggested vegetables for Zone {{this.$store.state.userData.region}}:</h3>

          <div class="zoneplants" v-for="zonePlant in $store.state.zonePlants" v-bind:key="zonePlant.name">
            <img class="plantimg" v-bind:src="'../img/vegetables/' + zonePlant.name + '.png'"/>
            <h3 id="plantname">{{zonePlant.name}}</h3>
          </div>
          <img class="plantimg" src="../img/vegetables/Corn.png"/>

    </div>
  </div>
<br>

    <div class="otherzones">
        <h2>See other Hardiness Zones</h2>
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
          <img class="zonemap" src="../img/zonemaps/zone3.png" alt="grow zones map" v-show="mapValue == '3'">
        <h1 id="zone3" v-show="mapValue == '3'">Zone {{mapValue}}</h1>
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
        
    </div>



  </div>
</template>

<script>


  import ZoneService from "../services/ZoneService";

export default {
  created() {
    ZoneService.getZoneInfo(this.$route.params.zonename)
      .then((response) => {
        this.$store.commit("SET_ZONE", response.data);
      });

    ZoneService.getZonePlants(this.$route.params.zonename)
      .then((response) => {
        this.$store.commit("SET_ZONE_PLANTS", response.data);
      })
  },

  name: "zone-data",
  components: {},
  data() {
    return {
      mapValue: "",
      zonePlant: {
        id: "",
        name: "",
        description: "",
        plantsPerSqFoot: "",
        sunRequirements: "",
        region: "",
        seedlingCost: "",
      },
    };

  },
};
</script>

<style>

  .plantimg {
    width: 10%;
  }

  #plantname {
    display: inline;
  }

  .zoneplants {
    display: inline;
    margin: 0px 50px;
  }

  .description {
    padding: 0px 100px 0px 100px;
  }

  .page {
    display: flex;
  }

    .zonemap {
      display: flex;
      text-align: center;
      width: 400px;
      display: inline-block;
    }

    h3 {
      text-align: center;
    }

    .map {
      text-align: center;
      background-color: #85A183;
      border-radius: 50px;
      padding: 50px 0px 50px 0px;
    }

    .otherzones {
      width: 70%;
      text-align: center;
      background-color: #c1d8bf;
      border-radius: 50px;
      margin: 0px 50px 0px 50px;
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

    .otherzones {
      background-color: #c1d8bf;
    }

</style>
