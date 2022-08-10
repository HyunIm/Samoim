<template>
<div>
  <v-bottom-navigation v-model="value" background-color="#FBC02D">
    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/progressgathering" 
    >
      <v-btn
        color="#FFBC00"
        block>
        진행
      </v-btn>
    </router-link>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/completegathering" 
    >
      <v-btn
        color="#FFBC00"
        block>
        완료
      </v-btn>
    </router-link>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/wishgathering" 
    >
      <v-btn
        color="#FFBC00"
        block>
        찜
      </v-btn>
    </router-link>
  </v-bottom-navigation>

  <v-card
    class="mx-auto ma-5"
    max-width="400"
  >
    <v-img
      class="white--text align-end"
      height="200px"
      src="../../assets/climbing.jpeg"
    >
      <v-card-title>오르락 내리락! 떨어질랑말랑!</v-card-title>
    </v-img>

    <v-card-text class="text--primary">
      일정 : 8월 6일 (토) 14:00 ~ 15:00 <br>
      장소 : 볼더프렌즈 클라이밍(홍대입구역) <br>
      금액 : ₩ 50,000
    </v-card-text>

    <v-card-actions>
      <v-btn
        color="orange"
        text
      >
        정산하기
      </v-btn>

      <router-link
        style="text-decoration: none; color: inherit;" 
        to="/reviewwrite" 
      >
        <v-btn
          color="orange"
          text
        >
          리뷰작성
        </v-btn>
      </router-link>
    </v-card-actions>
  </v-card>

  <v-card
    class="mx-auto ma-5"
    max-width="400"
  >
    <v-img
      class="white--text align-end"
      height="200px"
      src="../../assets/wine.jpeg"
    >
      <v-card-title>와인 럽</v-card-title>
    </v-img>

    <v-card-text class="text--primary">
      일정 : 8월 14일 (일) 19:00 ~ 23:00 <br>
      장소 : 펍(홍대입구역) <br>
      금액 : ₩ 80,000
    </v-card-text>

    <v-card-actions>
      <v-btn
        color="orange"
        text
      >
        정산하기
      </v-btn>

      <v-btn
        color="orange"
        text
      >
        리뷰작성
      </v-btn>
    </v-card-actions>
  </v-card>
</div>
</template>

<script>
export default {

}
</script>

<style>

</style>
