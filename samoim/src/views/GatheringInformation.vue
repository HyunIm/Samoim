<template>
  <div>
    <br>
    <v-img
      src="../assets/climbing_2.png"
    ></v-img>

    <br>
    <center>
      <h2>{{ classInfoData.name }}</h2>
      <h3 style="color:grey"># {{ classInfoData.smallCategory }}</h3>
    </center>

    <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-2">
            <h5>상세 소개</h5>
          </v-list-item-title>
          <v-list-item>
          {{ classInfoData.detailContents }}
          </v-list-item>
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-2">
            <h5>모임 일정</h5>
          </v-list-item-title>
          <div class="ml-3">
            <v-icon class="mr-2">mdi-calendar-month</v-icon>
            {{ classInfoData.openDate }}
          </div>
          <div class="ml-3">
            <v-icon class="mr-2">mdi-map-marker</v-icon>
            {{ classInfoData.city }} {{ classInfoData.address }}
          </div>
          <div class="ml-3">
            <v-icon class="mr-2">mdi-currency-krw</v-icon>
            { 금액 }
          </div>
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            <h5>모임 리뷰</h5>
          </v-list-item-title>
          <div
            v-for="(item, index) in reviewData"
            :key="index"
            class="ml-2"
          >
            &nbsp; ∙ {{ item.contents }}
          </div>
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <v-row class="mb-5 mt-1 mx-3">
      <v-col cols="2">
        <v-btn fab class="mt-4" @click="changeFavorite()">
          <v-icon color="red" v-if="this.favorite">mdi-heart</v-icon>
          <v-icon v-if="!this.favorite">mdi-cards-heart-outline</v-icon>
        </v-btn>
      </v-col>
      <v-col>
        <router-link
          style="text-decoration: none; color: inherit;" 
          :to="{name: 'GatheringJoin', params: {classId: this.classId}}"
        >
        <v-btn
          align="end"
          color="primary"
          rounded
          x-large
          block
          class="mx-2 mt-5"
        >
          <h3>가입하기</h3>
        </v-btn>
        </router-link>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  mounted() {
    this.classId = this.$route.params.classId;

    // 모임 상세정보 얻어오기
    this.getClassInfo(this.classId);
  },

  data: () => ({
    classInfoData:
      {
        id: 16,
        name: "클라클라 클라이밍",
        largeCategory: "운동·액티비티",
        smallCategory: "클라이밍",
        city: "서울",
        address: "서초구",
        maxMember: 8,
        ownerId: "admin@kb.com",
        openDate: "2022-08-09T00:00:00.000+00:00",
        detailContents: "클라이밍에 처음이신 분들 추천합니다!",
        photoPath: "/photo/path"
      },
    reviewData: [
      {
        class_id: 0,
        user_id: null,
        score: 5,
        contents: "좋아요~",
        photo_path: null,
        create_date: null
      },
    ],
    likeReq: {},
    favorite : false,
    classId: undefined
  }),

  methods: {
    getClassInfo(classId) {
      this.$axios.get('/api/classes/'+ classId)
      .then((res) => {
        this.classInfoData = res.data;
        
        // 찜 여부 확인
        this.$axios.get('/api/like/'+ this.$store.state.loginUser)
        .then((res) => {

          res.data.forEach((array) => {

            if(array.id === classId) {
              this.favorite = true;
            }
          })


        }).catch((error) => {
          console.log(error);

        })
      })
      .catch((error) => {
        console.log(error);
      });

      this.$axios.get('/api/review/' + classId)
      .then((res) => {
        this.reviewData = res.data;
      })
      .catch((error) => {
        console.log(error);
      });
    },
    changeFavorite() {
      this.likeReq = {
        classId: this.classId,
        userId: this.$store.state.loginUser
      };

      // 찜 API 호출
      if(this.favorite === false) {
        this.$axios.post('/api/like', this.likeReq)
        .then((res) => {
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
      } else {
        this.$axios.post('/api/like/delete', this.likeReq)
        .then((res) => {
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
      }
      


      // 하트 색깔 변경
      this.favorite = !this.favorite;
    }
  }
}
</script>

<style>

</style>