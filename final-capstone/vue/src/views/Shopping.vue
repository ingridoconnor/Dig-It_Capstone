<template>
  <div>
      <h1>Shopping List for {{this.$store.state.garden.gardenName}}</h1>
      <shopping-list />
    <supply-list />

  </div>
</template>

<script>
import ShoppingList from "@/components/ShoppingList"
import SupplyList from "@/components/SupplyList"

export default {
    components: {
        ShoppingList,
        SupplyList
    }
}
</script>

<style>

</style>