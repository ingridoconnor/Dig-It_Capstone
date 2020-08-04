<template>
    <form v-on:submit.prevent="addNewGarden">
        <div class="form-element">
            <label for="width">Garden Width: </label>
            <input id="width" type="number" v-model="newGarden.width" />
        </div>
        <div class="form-element">
            <label for="length">Garden Length: </label>
            <input id="length" type="number" v-model="newGarden.length" />
        </div>
        <div class="actions">
            <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
            <button>Submit</button>
        </div>
        </form>
</template>

<script>
export default {
    name: "add-garden",
    data() {
        return {
            newGarden: {
                id:0,
                width: "",
                length: ""

            }
        };
    },
    methods: {
        addNewGarden() {
            const gardenID = this.$route.params.id;
            this.newGarden.id = gardenID;
            this.$store.commit("ADD_GARDEN", this.newGarden);
        },
        resetForm() {
            this.newGarden = {};
        }
    }

}
</script>

<style>

</style>