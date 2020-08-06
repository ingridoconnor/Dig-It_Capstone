<template>
  <div>
    <profile />

  <router-link :to="{ name: 'add-garden' }" >Add a Garden</router-link>
</div>
</template>

<script>
import Profile from '@/components/Profile';

export default {
  components: {
    Profile
  }
};
</script>