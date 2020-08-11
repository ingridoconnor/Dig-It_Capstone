<template>
  <div id="main-garden-container">
         <h1 id="garden-name">{{this.$store.state.garden.gardenName}}</h1>
        <div class="plant-garden-container">
          <plant-details class="plant-details" />
          <garden-details class="garden-details" />
        </div>
        
        <plant-list />

    </div>
</template>

<script>
import GardenDetails from '@/components/GardenDetails'
import PlantList from '@/components/PlantList'
import PlantDetails from '@/components/PlantDetails'

export default {
  components: {
    GardenDetails,
    PlantList,
    PlantDetails
  }
};
</script>

<style>
#garden-name {
  display: flex;
  flex-grow: 1;
  justify-content: center;
}
#main-garden-container {
  display: flex;
  flex-direction: column;
  /* align-items: center; */
  align-content: center;
}
.plant-garden-container {
  display: flex;
  flex-grow: 1;
  justify-content: space-evenly;
  width: 100%;
}

.plant-details {
  display: flex;
  flex-direction: column;
  align-content: center;
  width: 25%;
  color: white;
  background-color: #307c55;
  border: 1px solid #307c55;
  border-radius: 25px;
}
.garden-details {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-items: center;
  width: 70%;
  color: white;
  background-color: #85a183;
  border: 1px solid #85a183;
  border-radius: 25px;
  padding: 20px;
}

</style>