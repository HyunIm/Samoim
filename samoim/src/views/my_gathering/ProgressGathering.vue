<template>
  <div>
    <v-list-item
      v-for="(item, index) in classData"
      :key="index"
    >
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
            <img src="Todo">
          </v-list-item-avatar>
          <v-list-item-content>
            <div class="text-overline">
              {{ item.LARGE_CATEGORY }} > {{ item.SMALL_CATEGORY }}
            </div>
            <v-list-item-title class="text-h5 mb-1">
              {{ item.NAME }}
            </v-list-item-title>
              <v-row>
                &nbsp;
                <!-- <v-chip
                  class="ma-2 text-center"
                  color="green lighten-5"
                  text-color="green"
                  small
                >
                  D-15
                </v-chip> -->
                <v-chip
                  class="ma-2 text-center"
                  outlined
                  small
                  text-color="grey darken-2"
                >
                  <v-icon left>
                    mdi-map-marker-outline
                  </v-icon>
                  <small>
                    {{ item.CITY }} {{ item.ADDRESS }} 
                  </small>
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
                  <small>
                    현재원/{{ item.MAX_MEMBER }}
                  </small>
                </v-chip>
              </v-row>
          </v-list-item-content>
        </v-list-item>

        <v-card-actions>
          <!--
          <v-btn
            outlined
            text
            width="48%"
          >
            채팅방 입장(연동 필요)
          </v-btn>
          -->
          <v-btn
            block
            outlined
            text
            width="48%"
          >
            <router-link
              style="text-decoration: none; color: inherit;" 
              :to="{name: 'GatheringInformation', params: {classId: item.CLASS_ID}}"
            >
            상세보기
            </router-link>
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-list-item>
  </div>
</template>

<script>
export default {
  data: () => ({
    classData: [
      {
        id: 12,
        name: "api 못 불러옴",
        largeCategory: "요리",
        smallCategory: "디저트",
        city: "서울",
        address: "성북구",
        maxMember: 4,
        ownerId: "null",
        openDate: "08-26",
        detailContents: "나는 아무거나",
        photoPath: "18_dessert.png"
      },
    ],
  }),

  mounted() {
    this.getClassList();
  },

  methods: {
    getClassList() {
      this.$axios.get('/api/myClass/' + this.$store.state.loginUser)
      .then((res) => {
        console.log(res);
        this.classData = res.data;
        
        /*
        for(let i = 0; i < res.data.length; i++) {
          this.classData[i].openDate = this.classData[i].openDate.toString().substr(5,5);
        }
        */
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
