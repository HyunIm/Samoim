<template>
  <v-card
    class="mx-auto ma-5"
    max-width="344"
    outlined
  >
    <v-list-item 
      three-line
      v-for="(item, index) in classData"
      :key="index">
      <v-list-item-avatar
        tile
        size="80"
      >
        <img src="../../assets/wine.jpeg">
      </v-list-item-avatar>
      <v-list-item-content>
        <div class="text-overline">
          {{ item.LARGE_CATEGORY }} > 
        </div>
        <v-list-item-title class="text-h5 mb-1">
          item.name
        </v-list-item-title>
          <v-row>
            &nbsp;
            <v-chip
              class="ma-2 text-center"
              outlined
              small
              text-color="grey darken-2"
            >
              <v-icon left>
                mdi-map-marker-outline
              </v-icon>
              {{ item.CITY}} {{item.ADDRESS}}
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
              현재원/item.MAX_MEMBER
            </v-chip>
          </v-row>
      </v-list-item-content>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        text
        width="48%"
      >
        채팅방 입장(연결 필요)
      </v-btn>
      <v-btn
        outlined
        text
        width="48%"
      >
        상세보기
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {

  data: () => ({
    classData: [],
  }),

  mounted() {
    this.getClassList();
  },

  methods: {
    getClassList() {
      this.$axios.get('/api/myJoinClass/' + this.$store.state.loginUser)
      .then((res) => {
        console.log(res.data);
        this.classData = res.data;
        
      })
      .catch((error) => {
        console.log(error);
      });
    },
  },

}
</script>

<style>

</style>
