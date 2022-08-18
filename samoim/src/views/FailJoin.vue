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
        src="../assets/fail.png"
    >
    </v-img>
    </center>

    <br>
    <h1><center>신청 실패</center></h1>

    <v-row class="mt-15 mx-3">
    <v-card
        class="mx-auto"
        width="350"
        outlined
    >
        <v-list-item three-line>
        <v-list-item-content>
            <v-list-item-title class="text-h5 mb-1">
            금액 부족
            </v-list-item-title>
            금액 부족으로 인한 신청 실패
        </v-list-item-content>
        </v-list-item>
    </v-card>
  </v-row>
  <br>

  <v-footer class="mb-2" color="white">
      <v-btn
        class="mr-4"
        x-large
        color="primary"
        @click="nextPage()"
        block
        rounded
      >
        <h3 class="font-weight-black">다음</h3>
      </v-btn>
    </v-footer>
</div>
</template>

<script>
export default {
  data: () => ({
    progress: 100,
  }),


  methods: {
    nextPage() {
      this.$router.replace('/main')
    },
  },
}
</script>

<style>

</style>
