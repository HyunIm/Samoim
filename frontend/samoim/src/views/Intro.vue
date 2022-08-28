<template>
  <v-container class="bg">
    <div style="height: 500px;"></div>

    <template>
      <v-row class="justify-center">
        <v-btn
            dark
            x-large
            disabled
        >
            스타뱅킹으로 5초만에 시작하기(추후 연동)
        </v-btn>
      </v-row>
      <v-row class="justify-center">
        <router-link
          to="/login"
          style="text-decoration: none; color: inherit;"  
        >
          <v-btn
            x-large
            color="#FFBC00"
            min-width="350"
          >
            다른 방법으로 시작하기
          </v-btn>
        </router-link>
      </v-row>
    </template>

  </v-container>
</template>

<script>
  export default {
    name: 'Intro',

    data: () => ({
      test: 'SAMOIM Intro PAGE',
    }),
  }
</script>

<style scoped>
.bg {
  background: url('../assets/intro.png');
  background-size: cover;
  height: 100vh;
}
</style>
