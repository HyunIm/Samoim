<template>
  <v-app>
        <!-- top bar -->
    <v-row>
      <v-app-bar
        :color="color"
      
        class=""
        fixed
        style="padding:0 5%"
        flat
      >
        <div class="d-flex align-center">
          <h1>
            <p class="font-2 mb-n1" :style="`color:#FBC02D`">SAMOIM</p>
          </h1>
        </div>

      <v-spacer></v-spacer>
      <v-icon
        large
        color="black darken-2"
      >
        mdi-filter-cog-outline
      </v-icon>
      <v-icon
        large
        color="black darken-2"
        class="ml-2"
      >
        mdi-magnify
      </v-icon>
      </v-app-bar>
    </v-row>

    <v-main>
      <Main/>
    </v-main>

    <!-- bottom bar -->
    <v-footer padless fixed=true>
        <v-bottom-navigation v-model="value" dark background-color="#FBC02D">
          <v-btn value="recent" color="#FBC02D" class="mt-2">
            <span>홈</span>
            <v-icon>mdi-home</v-icon>
          </v-btn>

          <v-btn value="favorites" color="#FBC02D" class="mt-2">
            <span>만들기</span>
            <v-icon>mdi-plus-circle-outline</v-icon>
          </v-btn>

          <v-btn value="nearby" color="#FBC02D" class="mt-2">
            <span>내 모임</span>
            <v-icon>mdi-calendar-month</v-icon>
          </v-btn>

          <v-btn value="nearby" color="#FBC02D" class="mt-2">
            <span>프로필</span>
            <v-icon>mdi-account</v-icon>
          </v-btn>
        </v-bottom-navigation>
    </v-footer>


  </v-app>
</template>

<script>
import Main from './components/Main';

export default {
  name: 'App',

  components: {
    Main,
  },

  data: () => ({
    //
  }),
};
</script>
