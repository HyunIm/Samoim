<template>
  <div>
    <v-banner class=ma-3>개인(신용) 정보 수집·이용 동의</v-banner>
    <h2 class=ma-3>개인(신용) 정보 수집·이용 동의하고</h2>
    <h2 class=ma-3>사모임 결제 서비스를 시작해 보세요.</h2>
    <v-checkbox
      class=ma-5
      v-model="checkbox"
      label="약관에 전체 동의"
    ></v-checkbox>
    <v-checkbox
      class=ma-5
      v-model="checkbox"
      label="결제 관련 사용정보 동의"
    ></v-checkbox>
    <v-checkbox
      class=ma-5
      v-model="checkbox"
      label="개인정보 관련 사용정보 동의"
    ></v-checkbox>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/payment" 
    >
      <v-btn
        align="end"
        block
        dark
        color="#FFBC00"
      >
        동의하기
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