<template>
     <v-footer padless fixed>
        <v-bottom-navigation dark background-color="#ffbc00">
          <router-link 
            style="text-decoration: none; color: inherit;" 
            to="/main"
            class="mx-2"
          >
            <v-btn value="recent" color="#ffbc00" class="mt-1">
              <span>홈</span>
              <v-icon>mdi-home</v-icon>
            </v-btn>
          </router-link>

          <router-link 
            style="text-decoration: none; color: inherit;" 
            to="/make"
            class="mx-2"
          >
            <v-btn value="favorites" color="#ffbc00" class="mt-1">
              <span>만들기</span>
              <v-icon>mdi-plus-circle-outline</v-icon>
            </v-btn>
          </router-link>

          <router-link 
            style="text-decoration: none; color: inherit;"
            to="/mygathering"
            class="mx-2"
          >
            <v-btn value="nearby" color="#ffbc00" class="mt-1">
              <span>내 모임</span>
              <v-icon>mdi-calendar-month</v-icon>
            </v-btn>
          </router-link>

          <router-link 
            style="text-decoration: none; color: inherit;" 
            to="/profile"
            class="mx-2"
          >
            <v-btn value="nearby" color="#ffbc00" class="mt-1">
              <span>프로필</span>
              <v-icon>mdi-account</v-icon>
            </v-btn>
          </router-link>  
        </v-bottom-navigation>
    </v-footer>
</template>

<script>
  export default {
    name: 'BottomBar',

    data: () => ({
    }),
  }
</script>