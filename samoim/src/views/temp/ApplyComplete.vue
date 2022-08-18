<template>
  <div>
    <br><br><br>

    <center>
      <v-img
        max-height="150"
        max-width="150"
        src="../assets/check.gif"
      >
      </v-img>
    </center>
    <br>

    <h1><center>모임 참석</center></h1>
    <h1><center>신청 완료</center></h1>

    <br><br><br>

    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            신청 내역
          </v-list-item-title>
          일정 : 8월 6일 (토) 14:00 ~ 15:00 <br>
          장소 : 볼더프렌즈 클라이밍(홍대입구역) <br>
          금액 : ₩ 50,000 <br>
          잔여 포인트 : 58,750 P
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <br><br><br>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/main" 
    >
      <v-btn
        align="end"
        block
        dark
        color="#FFBC00"
      >
        확인
      </v-btn>
    </router-link>

  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>