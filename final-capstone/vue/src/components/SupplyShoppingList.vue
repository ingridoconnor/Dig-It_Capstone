<template>
  <div class="shopping-list-container">
    <div class="plant-list-items">
        <h3>Supply/Tool Items:</h3>
        <ul class="plant-costs">
           <li class="field-headings"><span class="itemNameField">Item Name</span> <span class="itemQuantityField">Qty.</span> <span class="itemCostField">Each</span> <span class="itemCostField">Total</span></li>
            <li class="line-items" v-for="list in this.ShoppingLists" v-bind:key="list.index"><span class="itemNameField">{{list.itemName}}</span> <span class="itemQuantityField">{{list.itemQuantity}}</span> <span class="itemCostField">{{ (list.cost/list.itemQuantity) | currency}}</span> <span class="itemCostField">{{list.cost | currency}}</span></li>
          </ul>
          {{this.$store.state.shoppingLists}}
      </div>

  </div>
</template>

<script>
// import ShoppingService from "@/services/ShoppingService.js";
// import GardenService from "@/services/GardenService";

export default {
   created() {
     this.ShoppingLists = this.$store.state.shoppingLists;
   },
  name: "supply-shopping-list",
  data() {
    return {
      PlotsLoaded: false,
      plotList: this.$store.state.plots,
      ShoppingLists: [{
        cost: 0,
        itemName: '',
        itemQuantity: '',
      }],

    };
  },
}
</script>

<style>
#plant-list-items, h3 {
display: flex;
justify-content: flex-start;
text-justify: left;
margin-bottom: 0px;
}

.plant-costs {
  margin-top: 3px;
}

.field-headings {
  font-family: 'Kameron', serif;
  font-weight: 700;
  display: flex;
  margin-top: 0px;
}

.line-items {
  font-family: 'Kameron', serif;
  font-weight: 100;
  display: flex;
}

.itemNameField {
  width: 200px;
  text-align: left;
  word-wrap: none;

}
.itemQuantityField {
  width: 70px;
  text-align: right;
}
.itemCostField {
  width: 120px;
  text-align: right;
}


</style>