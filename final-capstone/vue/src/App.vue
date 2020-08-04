<template>
  <div id="app">
    <img class="logo" src="../public/digit.png" alt="digit logo">
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-view />
      <div id="nav">

      </div>

        
    
  </div>
</template>

<style>
.logo {
  width: 200px;
}

div {
  background-color: #c1c56d;
}
</style>