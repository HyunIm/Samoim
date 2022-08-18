<template>
  <div>
    <br>
    <v-img
      :src="classInfoData.photoPath"
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
        <v-btn fab class="mt-4" @click="changeFavorite(classInfoData.id)">
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
import climbingImg from '@/assets/class_img/0_climbing.png';
import golfImg from '@/assets/class_img/1_golf.png';
import tennisImg from '@/assets/class_img/2_tennis.png';
import driveImg from '@/assets/class_img/3_drive.png';
import campingImg from '@/assets/class_img/4_camping.png';
import concertImg from '@/assets/class_img/5_concert.png';
import musicalImg from '@/assets/class_img/6_musical.png';
import exhibitionImg from '@/assets/class_img/7_exhibition.png';
import bandImg from '@/assets/class_img/8_band.png';
import compositionImg from '@/assets/class_img/9_composition.png';
import drawingImg from '@/assets/class_img/10_drawing.png';
import writingImg from '@/assets/class_img/11_writing.png';
import readingImg from '@/assets/class_img/12_reading.png';
import studyImg from '@/assets/class_img/13_study.png';
import foreignImg from '@/assets/class_img/14_foreign.png';
import dogImg from '@/assets/class_img/15_dog.png';
import donationImg from '@/assets/class_img/16_donation.png';
import cookingImg from '@/assets/class_img/17_cooking.png';
import dessertImg from '@/assets/class_img/18_dessert.png';
import sojuImg from '@/assets/class_img/19_soju.png';


export default {
  mounted() {
    this.classInfoData = this.$route.params.element;

    // 모임 상세정보 얻어오기
    this.getClassInfo(this.classInfoData.id);
  },

  data: () => ({
    classInfoData:[],
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
    classId: undefined,

    climbingImg : climbingImg,
    golfImg : golfImg,
    tennisImg : tennisImg,
    driveImg : driveImg,
    campingImg : campingImg,
    concertImg : concertImg,
    musicalImg : musicalImg,
    exhibitionImg : exhibitionImg,
    bandImg : bandImg,
    compositionImg : compositionImg,
    drawingImg : drawingImg,
    writingImg : writingImg,
    readingImg : readingImg,
    studyImg : studyImg,
    foreignImg : foreignImg,
    dogImg : dogImg,
    donationImg : donationImg,
    cookingImg : cookingImg,
    dessertImg : dessertImg,
    sojuImg : sojuImg,
  }),

  methods: {
    getClassInfo(classId) {
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

      /*
      this.$axios.get('/api/review/' + classId)
      .then((res) => {
        this.reviewData = res.data;
      })
      .catch((error) => {
        console.log(error);
      });
      */
    },
    changeFavorite(classId) {
      this.likeReq = {
        classId: classId,
        userId: this.$store.state.loginUser
      };

      // 찜 API 호출
      if(this.favorite === false) {
        this.$axios.post('/api/like', this.likeReq)
        .then(() => {
        })
        .catch((error) => {
          console.log(error);
        });
      } else {
        this.$axios.post('/api/like/delete', this.likeReq)
        .then(() => {
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