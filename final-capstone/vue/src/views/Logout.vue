<template>
  <h1>Logout</h1>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    alert("You have been logged out and will be returned to the login screen.");
    this.$router.push("/login");
  }
};
</script>
