<template>
  <v-app>
    <!-- top bar -->

    <!-- Main View -->
    <v-main>
      <router-view></router-view>
    </v-main>

    <!-- bottom bar -->

    <v-footer padless fixed=true>
        <v-bottom-navigation v-model="value" dark background-color="#FBC02D">
          <router-link 
            style="text-decoration: none; color: inherit;" 
            to="/main" 
          >
            <v-btn value="recent" color="#FBC02D" class="mt-1">
              <span>홈</span>
              <v-icon>mdi-home</v-icon>
            </v-btn>
          </router-link>

          <router-link 
            style="text-decoration: none; color: inherit;" 
            to="/make"
          >
            <v-btn value="favorites" color="#FBC02D" class="mt-1">
              <span>만들기</span>
              <v-icon>mdi-plus-circle-outline</v-icon>
            </v-btn>
          </router-link>

          <router-link 
            style="text-decoration: none; color: inherit;" 
            to="/progressGathering"
          >
            <v-btn value="nearby" color="#FBC02D" class="mt-1">
              <span>내 모임</span>
              <v-icon>mdi-calendar-month</v-icon>
            </v-btn>
          </router-link>

          <router-link 
            style="text-decoration: none; color: inherit;" 
            to="/profile"
          >
            <v-btn value="nearby" color="#FBC02D" class="mt-1">
              <span>프로필</span>
              <v-icon>mdi-account</v-icon>
            </v-btn>
          </router-link>  
        </v-bottom-navigation>
    </v-footer>

  </v-app>
</template>

<script>

export default {
  name: 'App',

  components: {
  },

  data: () => ({
    //
  }),
};
</script>
