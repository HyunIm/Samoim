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
        <img src="../../assets/climbing.jpeg">
      </v-list-item-avatar>
      <v-list-item-content>
        <div class="text-overline">
          모집 중
        </div>
        <v-list-item-title class="text-h5 mb-1">
          클라이밍 할 사람!
        </v-list-item-title>
          <v-row>
            &nbsp;
            <v-chip
              class="ma-2 text-center"
              color="green lighten-5"
              text-color="green"
              small
            >
              D-15
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
              성북구∙8.20(토)
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
              8.12(금) 오픈
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
        멤버 관리
      </v-btn>
      <v-btn
        outlined
        text
        width="48%"
      >
        채팅방 입장
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
