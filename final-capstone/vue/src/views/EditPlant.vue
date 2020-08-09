<template>
  <div>
    <h1>Edit Plant</h1>
    <edit-plant v-bind:id="parseInt($route.params.id)" />
  </div>
</template>

<script>
import EditPlant from "@/components/EditPlant";

export default {
   
  components: {
    EditPlant
  }
};
</script>