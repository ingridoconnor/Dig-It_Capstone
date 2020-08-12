<template>
  <div id="main-shopping-container">
      <div id="shopping-list-plants">
          <h1>Shopping List for {{this.$store.state.garden.gardenName}}</h1>
          <plant-shopping-list/>
          <supply-shopping-list/>
      </div>

        <mulch-calculator id="mulch" />
        <supply-list  id="supply-selections" />
      
  </div>
</template>

<script>
import PlantShoppingList from "@/components/PlantShoppingList"
import SupplyShoppingList from "@/components/SupplyShoppingList"
import MulchCalculator from "@/components/MulchCalculator"
import SupplyList from "@/components/SupplyList"

export default {
    components: {
        PlantShoppingList,
        SupplyShoppingList,
        MulchCalculator,
        SupplyList
    },

}
</script>

<style>
#main-shopping-container {
  display: flex;
  flex-grow: 1;


}

#shopping-list-plants {
  display: flex;
  flex-direction: column;
  align-content: center;
  min-height: 65vh;
  max-height: 80vh;
  color: black;
  background-color: white;
  border: 1px solid white;
  border-radius: 25px;
  padding: 20px;
  margin-right: 20px;
}  

#mulch {
   display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-content: center;
  min-height: 65vh;
  max-height: 80vh;
  color: white;
  background-color: black;
  border: 1px solid black;
  border-radius: 25px;
  padding: 20px;
  margin-right: 20px;
}



</style>