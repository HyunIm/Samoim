<template>
  <v-app>
    <!-- top bar -->

    <!-- Main View -->
    <v-main>
      <router-view></router-view>
    </v-main>

    <!-- bottom bar -->
    <BottomBar 
      v-if="this.$route.path === '/main'
      || this.$route.path === '/make'
      || this.$route.path === '/progressgathering'
      || this.$route.path === '/completegathering'
      || this.$route.path === '/wishgathering'
      || this.$route.path === '/profile'
      "
    ></BottomBar>
    <NextButton
      v-if="this.$route.path === '/signup'"
    >
    </NextButton>
  </v-app>
</template>

<script>
import BottomBar from './components/common/BottomBar.vue';
import NextButton from './components/common/NextButton.vue';

export default {
  name: 'App',

  components: {
    BottomBar,
    NextButton
  },

  data: () => ({
    //
  }),
};
</script>
