<template>
  <div>
    <h1>Edit Plot</h1>
    <plot-form v-bind:cardID="parseInt($route.params.plotID)" />
  </div>
</template>

<script>
import PlotForm from "@/components/PlotForm";

export default {
  components: {
    PlotForm
  }
};
</script>
