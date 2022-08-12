<template>
  <v-app>
    <!-- top bar -->

    <!-- Main View -->
    <v-main>
      <router-view></router-view>
    </v-main>

    <!-- bottom bar -->
    <BottomBar 
      v-if="this.$route.path === '/'
      || this.$route.path === '/main'
      || this.$route.path === '/make'
      || this.$route.path === '/progressgathering'
      || this.$route.path === '/completegathering'
      || this.$route.path === '/wishgathering'
      || this.$route.path === '/profile'
      "
    ></BottomBar>

  </v-app>
</template>

<script>
import BottomBar from './components/common/BottomBar.vue';

export default {
  name: 'App',

  components: {
    BottomBar
  },

  data: () => ({
    //
  }),
};
</script>
