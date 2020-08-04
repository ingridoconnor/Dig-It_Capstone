<template>
  <div>
  <div class="home">
    <h1>Home</h1>
    <p></p>
  </div>

  <div class="links">
    <router-link class="link" v-bind:to="{ name: 'login' }" v-if="$store.state.token != ''">
      Login
    </router-link>
    <router-link class="link" v-bind:to="{ name: 'register' }" v-if="$store.state.token != ''">
      Register
    </router-link>
  </div>
  
</div>
  
</template>

<script>
export default {
  name: "home"
};
</script>

<style>
.home {
  display: flex;
  margin: 100px;
  justify-content: center;
  background-color: #c1c56d;
}

.links {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  font-size: 2em;
  color: #e48438;
}
</style>