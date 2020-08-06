<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">DIG IT!</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      
      <div class="field">
      <label for="username" class="sr-only">username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="username"
        v-model="user.username"
        required
        autofocus
      /></div>

      <div class="field">
      <label for="password" class="sr-only">password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="password"
        v-model="user.password"
        required
      /></div>
      
      <router-link :to="{ name: 'register' }" id="NeedAn">Need an account?</router-link>
      <button type="submit" class="button btn btn-lg btn-primary btn-block">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/profile");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style>
#login {
  display: flex;
  flex-direction: column;
  justify-content: flex-start; 
  align-items: center;
  background-color: #85A183;
  margin: 0px 30% 0px 30%;
}

.form-signin {
  display: flex;
  flex-direction: column;
  align-items: center;

}

.field {
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

label {
  margin-top: 15px;
  line-height: 2em;
}

input {
  width: 50ch;
  margin-top: 5px;
}

</style>