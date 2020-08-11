<template>
  <div>
      <h1>Shopping List for {{this.$store.state.garden.gardenName}}</h1>
      <shopping-list>
      </shopping-list>
  </div>
</template>

<script>
import ShoppingList from "@/components/ShoppingList"

export default {
    components: {
        ShoppingList
    }
}
</script>

<style>

</style>