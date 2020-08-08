<template>
  <div>
        <garden-details />
        <plant-list />
    </div>
</template>

<script>
import GardenDetails from '@/components/GardenDetails';
import PlantList from '@/components/PlantList'

export default {
  components: {
    GardenDetails,
    PlantList
  }
};
</script>