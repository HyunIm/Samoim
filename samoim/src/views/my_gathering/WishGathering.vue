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
        <img src="../../assets/mountaineering.jpeg">
      </v-list-item-avatar>
      <v-list-item-content>
        <div class="text-overline">
          정원 마감
        </div>
        <v-list-item-title class="text-h5 mb-1">
          참 즐거운 산악 동호회
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
              강북구∙8.20(토)
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
              12/16
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
        참여 신청
      </v-btn>
      <v-btn
        outlined
        text
        width="48%"
      >
        찜 취소
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
