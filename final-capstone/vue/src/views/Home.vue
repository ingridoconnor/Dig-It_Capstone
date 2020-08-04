<template>
  <div>
  <div class="home">
    <h1>dig it! is an online gardening app that let's you create a garden!</h1>
  </div>
  <div class="home">
    <h1>Let's get digging!</h1>
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
  margin: 40px 100px 40px 100px;
  justify-content: center;
  background-color: #c1c56d;
}

.links {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  font-size: 2em;
  color: #e48438;
  margin: 40px;
}
</style>