<template>

  <form v-on:submit.prevent="submitForm" class="profileForm">
    <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    <div class="form-group">
      <label for="username">Current Username: {{this.$store.state.user.username}}</label>
      <input id="username" type="text" class="form-control" v-model="user.username" autocomplete="off" />

      <label for="email">Current Email: {{this.$store.state.userData.data.email}}</label>
      <input id="email" type="email" class="form-control" v-model="userData.email" autocomplete="off" />
      
      <label for="firstname">Current First name: {{this.$store.state.userData.data.firstName}}</label>
      <input id="firstname" type="text" class="form-control" v-model="userData.firstName" autocomplete="off" />
      
      <label for="lastname">Current Last name: {{this.$store.state.userData.data.lastName}}</label>
      <input id="lastname" type="text" class="form-control" v-model="userData.lastName" autocomplete="off" />  
    
      <label for="city">Current City: {{this.$store.state.userData.data.city}}</label>
      <input id="city" type="text" class="form-control" v-model="userData.city" autocomplete="off" />  
    
      <label for="state">Current State: {{this.$store.state.userData.data.state}}</label>
      <input id="state" type="text" class="form-control" v-model="userData.state" autocomplete="off" />  
    
      <label for="zipcode">Current Zip: {{this.$store.state.userData.data.zipcode}}</label>
      <input id="zipcode" type="text" class="form-control" v-model="userData.zipcode" autocomplete="off" />  
    
    
    </div>
    
    
    <button class="btn-submit" type="submit">Submit</button>
    <button class="btn-cancel" v-on:click.prevent="cancelForm" type="cancel">Cancel</button>
  </form>

</template>



<script>
import userService from "../services/UserService";


export default {
  name: "profile-form",
  props: {
    userID: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      userData: {
        username: "",
        email: "",
        firstname: "",
        lastname: "",
        city: "",
        state: "",
        zipcode: "",
        userID: ""

      },
      user: {
        username: ""
      },
      errorMsg: ""
    };
  },
  methods: {
    submitForm() {
      const newUser = {
        userID: Number(this.$route.params.userID),
        username: this.user.username,
        email: this.userData.data.email,
        firstname: this.userData.datafirstname,
        lastname: this.userData.datalastname,
        city: this.userData.datacity,
        state: this.userData.datastate,
        zipcode: this.userData.datazipcode,
      };

      if (this.userID === 0) {
        // add
        userService
          .addUser(newUser)
          .then(response => {
            if (response.status === 201) {
              this.$router.push(`/profile/`);
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error submitting info. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error submitting info. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error submitting info. Request could not be created.";
            }
          });
      } else {
        // update
        newUser.id = this.userID;
        newUser.username = this.user.username;
        newUser.email = this.user.email;
        newUser.firstname = this.user.firstname;
        newUser.lastname = this.user.lastname;
        newUser.city = this.user.city;
        newUser.state = this.user.state;
        newUser.zipcode = this.user.zipcode;

        userService
          .updateUserInfo(newUser.id)
          .then(response => {
            if (response.status === 200) {
              this.$router.push(`/profile/${newUser.id}`);
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error updating info. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error updating info. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error updating info. Request could not be created.";
            }
          });
      }
    },
    cancelForm() {
      this.$router.push(`/profile/`);
    }
  },
  created() {
    if (this.userID != 0) {
      userService
        .getUserInfo(this.userID)
        .then(response => {
          this.user = response.data;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Profile not available. This user may have been deleted or you have entered invalid info."
            );
            this.$router.push("/");
          }
        });
    }
  }
};
</script>


<style>
.cardForm {
  padding: 10px;
  margin-bottom: 10px;
}
.form-group {
  margin-bottom: 10px;
  margin-top: 10px;
}
label {
  display: inline-block;
  margin-bottom: 0.5rem;
}
.form-control {
  display: block;
  width: 80%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}

.btn-submit {
  color: #fff;
  background-color: #e48438;
  border-color: #e48438;
  width: 150px;
  margin-right: 5px;
  border-radius: 5px; 
}
.btn-cancel {
  color: #fff;
  background-color: #307C55;
  border-color: #307C55;
  width: 150px;
  border-radius: 5px; 
}

.status-message {
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
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


</style>
