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

    <v-container v-if="isEmpty">
      <br><br><br>
      <center>
        <v-img
          max-height="400"
          max-width="200"
          :src="empty"
        ></v-img>
        <br>
        <h2>개설하신 모임이 없네요</h2>
      </center>
    </v-container>
  </div>
</template>

<script>
import Empty from '@/assets/starfriends/empty2.png';

export default {
  data: () => ({
    classData: [],
    empty: Empty,
    isEmpty: false,
  }),

  mounted() {
    this.getClassList();
  },

  methods: {
    getClassList() {
      this.$axios.get('/api/myClass/' + this.$store.state.loginUser)
      .then((res) => {
        this.classData = res.data;

        if(this.classData.length > 0) {
          this.isEmpty = false;
        } else {
          this.isEmpty = true;
        }

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
