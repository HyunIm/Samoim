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
            color="grey"
          >
          </v-list-item-avatar>
          <v-list-item-content>
            <div class="text-overline">
              {{ item.largeCategory }} > {{ item.smallCategory }}
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
                    {{ item.city }} {{ item.address }}
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
                    {{item.currentMember}} /{{ item.maxMember }}
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

        <router-link
          style="text-decoration: none; color: inherit;" 
          :to="{name: 'GatheringInformation', params: {classId: item.id}}"
        >
          <v-btn
            outlined
            block
            text
          >
            상세 보기
          </v-btn>
        </router-link>
      </v-card>
    </v-list-item>

    <v-container v-if="isEmpty">
      <br><br><br>
      <center>
        <v-img
          max-height="400"
          max-width="200"
          :src="empty"
          class="ml-8"
        ></v-img>
        <br>
        <h2>찜하신 모임이 없네요</h2>
      </center>
    </v-container>
  </div>
</template>

<script>
import Empty from '@/assets/starfriends/empty.png';

export default {
  data: () => ({
    classData: [],
    likeReq: {},
    isEmpty: false,
    empty: Empty
  }),

  mounted() {
    this.getClassList();
  },

  methods: {
    getClassList() {
      this.$axios.get('/api/like/' + this.$store.state.loginUser)
      .then((res) => {
        this.classData = res.data;

        //console.log(res.data.length);
        
        if(res.data.length > 0) {
          for(let i = 0; i < res.data.length; i++) {
            this.classData[i].openDate = this.classData[i].openDate.toString().substr(5,5);
          }
        } else {
          this.isEmpty = true;
        }
      })
      .catch((error) => {
        console.log(error);
      });
    },

    wishCancle(selectId) {
      this.likeReq = {
        classId: selectId,
        userId: this.$store.state.loginUser,
      }
      this.$axios.post('/api/like/delete', this.likeReq)
      .then(() => {
        //console.log(res);
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
