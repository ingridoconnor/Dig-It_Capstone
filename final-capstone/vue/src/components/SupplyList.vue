<template>
  <form id="supply-selector">
    <div id="supplies">
      <div class="supply" v-for="supply in this.$store.state.supplies" v-bind:key="supply.index">
        <input
          type="checkbox"
          class="checkboxes"
          v-bind:id="`Supply-${supply.supplyId}`"
          v-bind:value="supply.supplyId"
          v-on:change="selectSupply($event)"
        />
        <label v-bind:for="`Supply-${supply.supplyId}`">{{supply.supplyName}} {{ supply.supplyCost | currency }}</label>
      </div>
    </div>
  </form>
</template>

<script>
import SupplyService from "../services/SupplyService";

export default {
  created() {
    SupplyService.getAllSupplies()
      .then((response) => {
        this.$store.commit("SET_SUPPLIES", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Supply data not available.");
          this.$router.push("/");
        }
      });
  },

  name: "supply-data",
  components: {},
  data() {
    return {
      supply: {
        supplyId: "",
        supplyName: "",
        supplyCost: ""
       },
       selectedSupplies: [],
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
#supply-selector {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 25px;
}

#supplies {
  display: flex;
  flex-direction: column;
  height: 40vh;
  width: 100%;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-items: center;
}

.supply {
  display: flex;
  width: 40ch;
  align-items: center;
  /* margin: 3px 3px;
  background-color: #85a183;
  border: 1px solid #85a183;
  border-radius: 5px; */

}

.supply label {
  margin: 0px;
}
.checkboxes {
  width: 13px;
  margin-bottom: 5px;
}
</style>
