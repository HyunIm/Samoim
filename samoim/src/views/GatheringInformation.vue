<template>
  <div>
    <br>
    <v-img
      src="../assets/climbing_2.png"
    ></v-img>

    <br>
    <center>
      <h2>오르락 내리락! 떨어질랑말랑!</h2>
      <h2># 클라이밍</h2>
    </center>

    <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            상세 소개
          </v-list-item-title>
          초보도 쉽게 배울 수 있는 클라이밍 모임 <br>
          몸만 오세요! 장비는 모두 대여해 드립니다! <br>
          한번 해보면 빠져나올 수 없는 매력을 가진 <br>
          클라이밍초보도 쉽게 배울 수 있는 클라이밍 모임 <br>
          몸만 오세요! 장비는 모두 대여해 드립니다! <br>
          한번 해보면 빠져나올 수 없는 클라이밍
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            모임 일정
          </v-list-item-title>
          일정 : 8월 6일 (토) 14:00 ~ 15:00 <br>
          장소 : 볼더프렌즈 클라이밍(홍대입구역) <br>
          금액 : ₩ 50,000
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            모임 리뷰
          </v-list-item-title>
          혼자서 처음 참가해보았는데 모임장님이 <br>
          친절하게 잘 알려주시고, 장비도 대여할 <br>
          수 있어서 좋았습니다.
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <br>
    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/termsaccept" 
    >
      <v-btn
        align="end"
        block
        dark
        color="#FFBC00"
      >
        가입하기
      </v-btn>
    </router-link>

    <br><br><br>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>