<template>
  <form id="mulch-supply-selector">
    <h2>Mulch Calculator</h2>
    <h3>Select a Mulch Type</h3>
    <div id="supplies">
      <div class="supply" v-for="supply in this.Mulches" v-bind:key="supply.index">
        <input
          type="radio"
          class="checkboxes"
          name="mulch"
          v-bind:id="`Supply-${supply.supplyId}`"
          v-bind:value="supply.supplyId"
          v-on:change="selectSupply($event)"
        />
        <label v-bind:for="`Supply-${supply.supplyId}`">{{supply.supplyName.substring(mulchFilter.length)}} <span class="mulch-cost">{{ supply.supplyCost | currency }}/sf</span></label>
      </div>
    </div>
  <div id="supplies">
    <h3>Desired Mulch Thickness in Inches</h3>
    <input 
    type="number"
    min="1"
    max="4"
    v-model="mulchThickness">

</div>
  </form>
</template>

<script>
import SupplyService from "../services/SupplyService";

export default {
  created() {
    SupplyService.getAllSupplies()
      .then((response) => {
        this.Supplies = response.data;
        this.Mulches = this.Supplies.filter((item) => {
        return item.supplyName.toLowerCase().includes(this.filterString.toLowerCase());
        });
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Supply data not available.");
          this.$router.push("/");
        }
      });
  },

  name: "mulch-calculator",
  components: {},
  data() {
    return {
      ShoppingLists: [{
        cost: 0,
        itemName: '',
        itemQuantity: '',
      }],
      Supplies: [{
        supplyId: "",
        supplyName: "",
        supplyCost: "",
        supplyQty: "",
       }],
       Mulches: [{
        supplyId: "",
        supplyName: "",
        supplyCost: "",
        supplyQty: "",
       }],
       selectedSupplies: [],
       filterString: "bagged",
       mulchFilter: "2 cu ft. Bagged ",
       mulchThickness: 2,
    };
  },

  methods: {
    selectSupply(event) {
      if (event.target.checked) {
        this.selectedSupplies.add(this.$store.state.supplies.filter(
          (supply) => {
            if (supply.supplyId == event.target.value) {
              return supply;
            }
          }
        ));
      }
    },
  },
};
</script>

<style>
#mulch-supply-selector {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 25px;
}

#supplies {
  display: flex;
  flex-direction: column;
  width: 100%;
  justify-content: flex-start;
  align-items: center;
}

.supply {
  display: flex;
  width: 40ch; 
  align-items: center;
  margin: 3px 3px;
  color: black;
  font-weight: 700;
  background-color: #c1c56d;
  border: 1px solid #c1c56d;
  border-radius: 5px;

}

.supply label {
  margin: 0px;
  padding-left: 5px;
  width: 50ch;
  display: flex;
  justify-content: space-between;
}
.checkboxes {
  width: 13px;
  margin-bottom: 5px;
}

.mulch-cost {
  padding-right: 20px;  
}
</style>
