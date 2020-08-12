<template>
  <div>

  <div class="home logged" v-if="$store.state.token != ''">
    <h1>Hey {{$store.state.userData.firstName}}, let's get digging!</h1>
    <h2>Your profile is always a great place to start.</h2>

  </div>
  <div class="home" v-else>
    <h1>Let's get digging!</h1>
    <h2>Dig It! is an online gardening app that helps you create a vegateble garden.</h2>
  </div>
    <user-steps class="user-steps"/>
  <div class="links">
    <router-link  class="button create btn-lg" v-bind:to="{ name: 'register' }" v-if="$store.state.token === ''">
      Create an Account
    </router-link>
  </div>
  
</div>
  
</template>

<script>
import UserSteps from '@/components/UserSteps'

export default {
  name: "home",
  components: {
    UserSteps
  }
};
</script>

<style>

.home {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  /* background-image: url("../img/HomePic.jpg");
  background-repeat: no-repeat;
  background-size: 200vh;
  background-position: center; */
}

.links {
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-bottom: 20px;
}

.user-steps {
  display: flex;
  justify-content: center;
}


</style>