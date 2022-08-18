<template>
<div>
  <v-row>
    <v-col class="mt-3">
      <h3>
        <center>
            모임 가입
        </center>
      </h3>
    </v-col>
  </v-row>
  <v-row class="mt-1">
    <template>
        <v-progress-linear :value="progress"></v-progress-linear>
    </template>
    </v-row>

    <center class="mt-15 mx-3">
    <v-img
        max-height="128"
        max-width="128"
        src="../assets/check.png"
    >
    </v-img>
    </center>

    <h1><center>모임 참석</center></h1>
    <h1><center>신청 완료</center></h1>

    <v-row class="mt-15 mx-3">
    <v-card
        class="mx-auto"
        width="350"
        outlined
    >
        <v-list-item three-line>
        <v-list-item-content>
            <v-list-item-title class="text-h5 mb-1">
            신청 내역
            </v-list-item-title>
            일정 : 날짜 바인딩 필요 <br>
            장소 : 장소 바인딩 필요 <br>
            금액 : {{ this.price }} P<br>
            잔여 포인트 : {{ this.userPoint - this.price }} P
        </v-list-item-content>
        </v-list-item>
    </v-card>
  </v-row>
  <br>
</div>
</template>

<script>
export default {
  data: () => ({
    progress: 100,
  }),

}
</script>

<style>

</style>
