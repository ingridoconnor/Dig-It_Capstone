<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />

      <label for="email" class="sr-only">Email</label>
      <input
        type="email"
        id="email"
        class="form-control"
        placeholder="user@site.com"
        v-model="user.email"
        required
      />

     <label for="firstName" class="sr-only">First Name</label>
      <input
        type="text"
        id="firstName"
        class="form-control"
        placeholder="First Name"
        v-model="user.firstName"
        required
      />

     <label for="lastName" class="sr-only">Last Name</label>
      <input
        type="text"
        id="lastName"
        class="form-control"
        placeholder="Last Name"
        v-model="user.lastName"
        required
      />

      <label for="city" class="sr-only">City</label>
      <input
        type="text"
        id="city"
        class="form-control"
        placeholder="city"
        v-model="user.city"
        required
      />
      
      <label for="state" class="sr-only">State</label>
      <input
        type="text"
        id="state"
        class="form-control"
        placeholder="State"
        v-model="user.state"
        required
      />

      <label for="zip" class="sr-only">Zip</label>
      <input 
        id="zip" 
        name="zip" 
        type="text" 
        inputmode="numeric" 
        pattern="^(?(^00000(|-0000))|(\d{5}(|-\d{4})))$"
        class="form-control"
        placeholder="XXXXX"
        v-model="user.zip"
        required
      />

      <router-link :to="{ name: 'login' }" id="AlreadyHave">Already have an account?</router-link>
      <button  type="submit" class="button btn btn-lg btn-primary btn-block">
        Submit
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        email: '',
        firstName: '',
        lastName: '',
        city: '',
        state: '',
        zip: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
#register {
  display: flex;
  flex-direction: column;
  justify-content: flex-start; 
    align-items: center;
  margin: 20px 100px 20px 100px;

}

.form-register {
  display: flex;
  flex-direction: column;




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
