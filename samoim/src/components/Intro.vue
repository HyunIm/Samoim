<template>
  <v-container class="bg">
    <div style="height: 750px;"></div>

    <template>
        <v-btn
            block
            dark
            color="#FFBC00"
        >
            스타뱅킹으로 5초만에 시작하기
        </v-btn>
    </template>

    <template>
        <v-btn block>
            다른 방법으로 시작하기
        </v-btn>
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
