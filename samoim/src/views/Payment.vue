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
    
    <v-row justify="center">
      <v-dialog
        v-model="dialog"
        persistent
        max-width="290"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            block
            color="#FFBC00"
            dark
            v-bind="attrs"
            v-on="on"
          >
            결제하기
          </v-btn>
        </template>
        <v-card>
          <v-card-title class="text-h5">
            추천 보험
          </v-card-title>
          <v-img src="../assets/insurance.png"></v-img>
          <v-card-actions>
            <v-spacer></v-spacer>
            <router-link
              style="text-decoration: none; color: inherit;" 
              to="/applycomplete" 
            >
              <v-btn
                color="green darken-1"
                text
                @click="dialog = false"
              >
                안 하기
              </v-btn>
            </router-link>
            <router-link
              style="text-decoration: none; color: inherit;" 
              to="/applycomplete"
            >
              <v-btn
                color="green darken-1"
                text
                @click="url = true"
              >
                가입하기
              </v-btn>
            </router-link>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>

<script>
export default {
  data () {
    return {
      dialog: false,
      url: false,
    }
  },
  watch: {
      url () {
        window.open('https://m.kbinsure.co.kr:8543/MG302030001.ec', '_blank')
      },
    },
}
</script>

<style>

</style>
