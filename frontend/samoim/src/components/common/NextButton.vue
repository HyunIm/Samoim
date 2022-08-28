<template>
  <v-footer class="mb-2" color="white">
    <v-btn
      class="mr-4"
      x-large
      color="primary"
      dark
      @click="nextPage()"
      block
      rounded
    >
      <h3 class="font-weight-black">다음</h3>
    </v-btn>
  </v-footer>
</template>

<script>
  export default {
    name: 'NextButton',

    methods: {
      nextPage() {
        if(this.$store.state.signupPage === 6) {
          //로그인 상태로 메인 페이지 이동
          this.$router.replace('/main')
        } else if(this.$store.state.signupPage === 5) {
          // 회원가입 API 호출

          // response 200이면
          this.$store.commit('changePage');
        } else {
          this.$store.commit('changePage');
        }
        
      }
    },

    data: () => ({
      
    }),
  }
</script>