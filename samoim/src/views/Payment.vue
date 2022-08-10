<template>
  <div>
    <v-card
      class="mx-auto ma-10"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            결제 금액
          </v-list-item-title>
          50,000원
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <v-card
      class="mx-auto ma-10"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            보유 포인트
          </v-list-item-title>
          108,750P
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/test" 
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