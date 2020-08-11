<template>
  <div>
  
  <div class="home logged" v-if="$store.state.token != ''">
    <h1>Hey {{$store.state.userData.firstName}}, let's get digging!</h1>
    <p>Your profile is always a great place to start.</p>
  </div>
  <div class="home" v-else>
    <h1>Let's get digging!</h1>
    <p>Dig It! is an online gardening app that helps you create a vegateble garden.</p>
  </div>

  <div class="links">

    <router-link  class="button create btn-lg" v-bind:to="{ name: 'register' }" v-if="$store.state.token === ''">
      Create an Account
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
  flex-direction: column;
  align-items: center;
  justify-content: center;
  
}

.links {
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-bottom: 20px;
}

</style>