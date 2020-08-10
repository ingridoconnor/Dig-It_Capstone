<template>
  <div id="app">
          <div id="header">
              <a href="/"><img v-bind:class="isHome ? '' : 'shrink-nav' " class="logo" src="./img/digit.png" alt="digit logo"></a>
              <div id="nav">
                  <router-link class="button" v-bind:to="{ name: 'home' }" v-if="!isHome">Home</router-link>
                  <router-link class="button" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''" v-show="!isLogin">Login</router-link>
                  <router-link class="button" v-bind:to="{ name: 'profile' }" v-if="$store.state.token != '' && $route.name != 'profile'">Profile</router-link>
                  <router-link class="button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
              </div>
          </div>

          <div id="main-view">
            <router-view />
          </div>

        
    
  </div>
</template>

<script>
export default {
  computed: {
    isHome() {
      return this.$route.name === 'home';
    },
    isLogin() {
      return this.$route.name === 'login';
    }
  }

};
</script>

<style>
#app {
  background-color: #c1c56d;

  display: flex;
  flex-direction: column;
  justify-content: space-between;
  font-family: 'Raleway', sans-serif;

}

#header {
  margin: 30px 40px 20px 40px;
  display: flex;
  flex-grow: 1;
  align-items: center;
  max-height: 15%;
}

.logo {
  margin-right: 40px;
  width: 250px;
}

.shrink-nav {
  width: 150px;
}

#nav {
  margin-left: 40px;
  display: flex;
  flex-grow: 1;
  justify-content: flex-end;
  align-items: center;
}

.button {
  padding: 20px;
  height: 28px;
  border-radius: 28px;
  width: 80px;
  margin-left: 20px;
  color: white;
  font-size: 1.2em;
  font-weight: 200;
  text-align: center;
  text-decoration: none;
  align-items: center;
  background-color: #e48438 ;
}

.btn-lg {
  margin: 20px 0px;
  width: 250px;
  font-size: 1.4em;
  display: flex;
  justify-content: center;
  align-content: center;
  text-align: center;
  border: none;
}

#NeedAn, #AlreadyHave {
  margin: 20px 0px;
}


h1, h2, h3, h4 {
font-family: 'Kameron', serif;
}

#main-view {
  min-height: 80vh;
  margin: 40px 100px 40px 100px;
  background-color: #c1c56d;
}









</style>