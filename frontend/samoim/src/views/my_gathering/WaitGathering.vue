<template>
  <v-card
    class="mx-auto ma-5"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-avatar
        tile
        size="80"
      >
        <img src="../../assets/tennis.png">
      </v-list-item-avatar>
      <v-list-item-content>
        <div class="text-overline">
          모집 중
        </div>
        <v-list-item-title class="text-h5 mb-1">
          테니스 초보 환영
        </v-list-item-title>
          <v-row>
            &nbsp;
            <v-chip
              class="ma-2 text-center"
              color="green lighten-5"
              text-color="green"
              small
            >
              D-8
            </v-chip>
            <v-chip
              class="ma-2 text-center"
              outlined
              small
              text-color="grey darken-2"
            >
              <v-icon left>
                mdi-map-marker-outline
              </v-icon>
              종로구∙8.20(토)
            </v-chip>
          </v-row>
        <v-list-item-subtitle>
          <v-row>
            &nbsp;
            <v-chip
              class="ma-2 text-center"
              outlined
              small
              text-color="grey darken-2"
            >
              8.12(금) 신청
            </v-chip>
            <v-chip
              class="ma-2 text-center"
              outlined
              small
              text-color="grey darken-2"
            >
              <v-icon left>
                mdi-account-group
              </v-icon>
              1/4
            </v-chip>
          </v-row>
        </v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        text
        width="48%"
      >
        호스트 문의
      </v-btn>
      <v-btn
        outlined
        text
        width="48%"
      >
        대기 취소
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {

}
</script>

<style>

</style>
