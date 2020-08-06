<template>
  <div>
    <h1>Edit Profile</h1>
    <profile-form v-bind:userID="parseInt($route.params.userID)" />
  </div>
</template>

<script>
import ProfileForm from "@/components/ProfileForm";

export default {
  components: {
    ProfileForm
  }
};
</script>
