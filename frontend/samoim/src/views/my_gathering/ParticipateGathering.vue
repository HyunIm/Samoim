<template>
  <div>
    <v-list-item
      v-for="(item, index) in classData"
      :key="index"
    >
      <v-card
        class="ma-5"
        width="350"
        outlined
      >
        <v-list-item three-line>
        <v-list-item-avatar
          tile
          size="80"
        >
        <v-img :src="item.photoPath"></v-img>
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
                {{ item.city}} {{item.address}}
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
                {{ item.currentmember }} / {{ item.maxMember }}
              </v-chip>
            </v-row>
        </v-list-item-content>
      </v-list-item>

      <v-list-item>
        <v-row>
          <v-col>
            <v-btn
              block
              outlined
              text
              @click="openLiivChat(item.id)"
            >
              리브똑똑 채팅방
            </v-btn>
          </v-col>

          <v-col>
            <router-link
              style="text-decoration: none; color: inherit;" 
              :to="{name: 'GatheringInformation', params: {element: item}}"
            >
            <v-btn
              outlined
              text
              block
            >
              상세보기
            </v-btn>
            </router-link>
          </v-col>
        </v-row>
      </v-list-item>
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
        <h2>참여 신청한 모임이 없네요</h2>
      </center>
    </v-container>
  </div>
</template>

<script>
import Empty from '@/assets/starfriends/empty3.png';

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

  data: () => ({
    classData: [],
    empty: Empty,
    isEmpty: false,

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

  mounted() {
    this.getClassList();
  },

  methods: {
    getClassList() {
      this.$axios.get('/api/myJoinClass/' + this.$store.state.loginUser)
      .then((res) => {
        this.classData = res.data;

        if(this.classData.length > 0) {
          this.isEmpty = false;
          
          for(var i=0; i<this.classData.length; i++) {
            if(this.classData[i].photoPath === "climbingImg"){
              this.classData[i].photoPath = this.climbingImg;
            } else if(this.classData[i].photoPath === "golfImg"){
              this.classData[i].photoPath = this.golfImg;
            } else if(this.classData[i].photoPath === "tennisImg"){
              this.classData[i].photoPath = this.tennisImg;
            } else if(this.classData[i].photoPath === "campingImg"){
              this.classData[i].photoPath = this.campingImg;
            } else if(this.classData[i].photoPath === "driveImg"){
              this.classData[i].photoPath = this.driveImg;
            } else if(this.classData[i].photoPath === "concertImg"){
              this.classData[i].photoPath = this.concertImg;
            } else if(this.classData[i].photoPath === "musicalImg"){
              this.classData[i].photoPath = this.musicalImg;
            } else if(this.classData[i].photoPath === "exhibitionImg"){
              this.classData[i].photoPath = this.exhibitionImg;
            } else if(this.classData[i].photoPath === "bandImg"){
              this.classData[i].photoPath = this.bandImg;
            } else if(this.classData[i].photoPath === "compositionImg"){
              this.classData[i].photoPath = this.compositionImg;
            } else if(this.classData[i].photoPath === "drawingImg"){
              this.classData[i].photoPath = this.drawingImg;
            } else if(this.classData[i].photoPath === "writingImg"){
              this.classData[i].photoPath = this.writingImg;
            } else if(this.classData[i].photoPath === "readingImg"){
              this.classData[i].photoPath = this.readingImg;
            } else if(this.classData[i].photoPath === "studyImg"){
              this.classData[i].photoPath = this.studyImg;
            } else if(this.classData[i].photoPath === "foreignImg"){
              this.classData[i].photoPath = this.foreignImg;
            } else if(this.classData[i].photoPath === "dogImg"){
              this.classData[i].photoPath = this.dogImg;
            } else if(this.classData[i].photoPath === "donationImg"){
              this.classData[i].photoPath = this.donationImg;
            } else if(this.classData[i].photoPath === "cookingImg"){
              this.classData[i].photoPath = this.cookingImg;
            } else if(this.classData[i].photoPath === "dessertImg"){
              this.classData[i].photoPath = this.dessertImg;
            } else if(this.classData[i].photoPath === "sojuImg"){
              this.classData[i].photoPath = this.sojuImg;
            } 
          }

        } else {
          this.isEmpty = true;
        }
        
      })
      .catch((error) => {
        console.log(error);
      });
    },
    openLiivChat(classId) {

      this.$axios.get('/extraservice/liivchat/url', {params: {classId: classId}})
      .then((res) => {
        console.log(res);

        if(res.data.length !== 0) {
          //오픈채팅방 연결
          window.open(res.data.url);
        } else {
          this.$swal({
            title: '오픈 불가',
            text: '리브똑똑 채팅방을 등록하지 않은 모임입니다.',
            icon: 'warning',
            confirmButtonText: '확인'
          }).then(() => {
            this.loginForm.email = "";
            this.loginForm.password = "";
            this.buttonActive = false;
          });
        }
      })
      .catch((error) => {
        console.log(error);
      });
    }
  },

}
</script>

<style>

</style>
