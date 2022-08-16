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
            <img src="../../assets/mountaineering.jpeg">
          </v-list-item-avatar>
          <v-list-item-content>
            <div class="text-overline">
              { 정원 마감 }
            </div>
            <v-list-item-title class="text-h5 mb-1">
              {{ item.name }}
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
                  <small>
                    {{ item.address }}∙{{ item.openDate }}
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
                    { 1 }/{{ item.maxMember }}
                  </small>
                </v-chip>
              </v-row>
            <!-- <v-list-item-subtitle>
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
            </v-list-item-subtitle> -->
          </v-list-item-content>
        </v-list-item>

        <v-card-actions>
          <v-row>
            <v-col cols="6">
              <router-link
                style="text-decoration: none; color: inherit;" 
                :to="{name: 'GatheringInformation', params: {classId: item.id}}"
              >
                <v-btn
                  width="160"
                  outlined
                  text
                >
                  참여 신청
                </v-btn>
              </router-link>
            </v-col>
            <v-col cols="6">
              <v-btn
                width="160"
                outlined
                text
              >
                찜 취소
              </v-btn>
            </v-col>
          </v-row>
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
        name: "api Test",
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
      this.$axios.get('/api/like/' + this.$store.state.loginUser)
      .then((res) => {
        this.classData = res.data;
        
        for(let i = 0; i < res.data.length; i++) {
          this.classData[i].openDate = this.classData[i].openDate.toString().substr(5,5);
        }

        console.log(this.classData);
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
