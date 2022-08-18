<template>
  <v-container>

    <!-- TopBar -->
    <v-row>
      <TopBar @fillterData="fillterData"></TopBar>
    </v-row>

    <!-- 추천 모임 -->
    <v-row v-if="this.suggestion" class="mt-15">
      <v-carousel 
        height="210" 
        cycle 
        show-arrows-on-hover
        delimiter-icon="mdi-minus"
        hide-delimiter-background
      >
        <v-carousel-item
          v-for="(item,i) in suggestionItems"
          :key="i"
          :src="item.src"
          reverse-transition="fade-transition"
          transition="fade-transition"
          @click="suggestionClick(item.NAME)"
        ></v-carousel-item>
      </v-carousel>
    </v-row>

    <!-- 모임 리스트 -->
    <v-row class="mx-3 mt-10">
      <h2>{{ title }}</h2>
      <v-spacer></v-spacer>
      <v-icon
        class="mr-5"
        x-large
        color="black darken-2"
        @click="openFillterDialog()"
      >
        mdi-magnify
      </v-icon>
    </v-row>

    <v-row>
        <v-list-item
          v-for="(item, index) in classData"
          :key="index"
          >
          <router-link
            style="text-decoration: none; color: inherit;" 
            :to="{name: 'GatheringInformation', params: {element: item}}"
          >
        
          <v-col cols="12">
            <v-card
              class="mx-auto"
              max-width="360"
              outlined
              shaped
            >
              <v-list-item three-line>
                <v-list-item-avatar
                  tile
                  size="100"
                >
                <v-img :src="item.photoPath"></v-img>
                </v-list-item-avatar>
                <v-list-item-content>
                  {{ item.src }}
                  <div class="text-overline">
                    <h4> {{ item.largeCategory }}>{{ item.smallCategory }} </h4>
                  </div>
                  <v-list-item-title class="mb-1">
                    <h3>{{ item.name }}</h3>
                  </v-list-item-title>
                  <v-list-item-subtitle>
                    <v-icon>mdi-map-marker</v-icon>
                    {{ item.city }} {{ item.address }}
                    <v-icon class="ml-2">mdi-account-multiple</v-icon>
                    {{item.currentMember}} / {{ item.maxMember }}
                  </v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
            </v-card>
          </v-col>
          </router-link>
        </v-list-item>
    </v-row>
    <br><br><br><br><br>

    <v-bottom-sheet v-model="fillterDialog">
        <v-card>
          <v-card-title>
            <v-btn
              icon
              color="black"
              @click="fillterDialog = false"
            >
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-card-title>
            
          <v-card-subtitle class="mt-3">
            <h2>카테고리</h2>
          </v-card-subtitle>

          <v-card-text>
            <v-row>
              <v-col
                cols="4"
                v-for="(item, index) in categoriesData"
                :key="index"
                >
                <v-checkbox
                  :label=item.name
                  color="primary"
                  hide-details
                  v-model="category"
                  :value=item.name
                ></v-checkbox>
              </v-col>
            </v-row>
          </v-card-text>

          <v-divider></v-divider>

          <v-card-subtitle class="mt-3">
            <h2>지역</h2>
          </v-card-subtitle>
          <v-card-text>
            <v-radio-group v-model="address" row>
              <v-radio
                v-for="(item, index) in locationData"
                :key="index"
                :label="item.ADDRESS"
                :value="item.ADDRESS"
              ></v-radio>
            </v-radio-group>
          </v-card-text>

          <v-card-actions>
            <v-btn
              class="mb-3"
              x-large
              color="primary"
              dark
              block
              rounded
              @click="fillterClass()"
            >
              <h3 class="font-weight-black">검색</h3>
            </v-btn>
          </v-card-actions>

        </v-card>
      </v-bottom-sheet>

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
          <h2>검색 조건에 맞는 모임이 없네요</h2>
        </center>
      </v-container>
  </v-container>

</template>

<script>
import TopBar from '../components/common/TopBar.vue'

import climbing from '@/assets/small_category_img/0_climbing.png';
import golf from '@/assets/small_category_img/1_golf.png';
import tennis from '@/assets/small_category_img/2_tennis.png';
import drive from '@/assets/small_category_img/3_drive.png';
import camping from '@/assets/small_category_img/4_camping.png';
import concert from '@/assets/small_category_img/5_concert.png';
import musical from '@/assets/small_category_img/6_musical.png';
import exhibition from '@/assets/small_category_img/7_exhibition.png';
import band from '@/assets/small_category_img/8_band.png';
import composition from '@/assets/small_category_img/9_composition.png';
import drawing from '@/assets/small_category_img/10_drawing.png';
import writing from '@/assets/small_category_img/11_writing.png';
import reading from '@/assets/small_category_img/12_reading.png';
import study from '@/assets/small_category_img/13_study.png';
import foreign from '@/assets/small_category_img/14_foreign.png';
import dog from '@/assets/small_category_img/15_dog.png';
import donation from '@/assets/small_category_img/16_donation.png';
import cooking from '@/assets/small_category_img/17_cooking.png';
import dessert from '@/assets/small_category_img/18_dessert.png';
import soju from '@/assets/small_category_img/19_soju.png';


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

import Empty from '@/assets/starfriends/empty.png';


export default {
  name: 'Main',

  components: {
    TopBar,
    //BottomBar,
  },

  mounted() {
      this.getCategory();
      this.getClassList();
      this.suggestionCategory();
      this.getMyInfo();
    },

  data: () => ({
    test: 'SAMOIM MAIN PAGE',
    fillterDialog: false,
    suggestionItems: [
      {
        "PHOTO_PATH": "drive",
        "NAME": "드라이브",
        "src": drive,
      },
      {
        "PHOTO_PATH": "dog",
        "NAME": "유기견봉사",
        "src": dog
      },
    ],
    climbing : climbing,
    golf : golf,
    tennis : tennis,
    drive : drive,
    camping : camping,
    concert : concert,
    musical : musical,
    exhibition : exhibition,
    band : band,
    composition : composition,
    drawing : drawing,
    writing : writing,
    reading : reading,
    study : study,
    foreign : foreign,
    dog : dog,
    donation : donation,
    cooking : cooking,
    dessert : dessert,
    soju : soju,

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

    classData: [
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
    ],
    title: "내 주변 사모임",
    suggestion: true,
    recommendData: undefined,
    myInfo: {
      email: "0818@",
      name: "테스트",
      phone: "",
      password: "1234",
      gender: "남",
      birth: "2016-11-30",
      city: "서울",
      address: "강남구",
      interest: "운동,문화,창작,",
      photoPath: "force",
      tag: null,
      point: 100000
    },
    categoriesData: [],
    locationData: [
      { CITY: '서울', ADDRESS: '강남구' },
      { CITY: '서울', ADDRESS: '영등포구' }
    ],
    address: undefined,
    category: [],

    isEmpty: false,
    empty: Empty,
  }),

  methods: {
      getClassList() {
        var categoryList = [];
        var addressList = [];
        addressList.push(this.myInfo.address);

        this.classData = {"category": categoryList, "area": addressList};

        this.$axios.post('/api/classes', this.classData)
        .then((res) => {
          this.classData = res.data;
          //console.log(this.classData);

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
        })
        .catch((error) => {
          console.log(error);
        });
      },

      getMyInfo() {
        this.$axios.get('/api/info/' + this.$store.state.loginUser)
        .then((res) => {
          this.myInfo = res.data;
        })
        .catch((error) => {
          console.log(error);
        });
      },

      openFillterDialog() {
        this.fillterDialog = true;
      },

      getCategory() {
        this.$axios.get('/api/categories')
        .then((res) => {
          this.categoriesData = res.data;
          //console.log(this.categoriesData);
        })
        .catch((error) => {
          console.log(error);
        });
      },


      fillterData(value) {
        this.classData = value;
        this.title = "필터링한 사모임";
        this.suggestion = false;
      },

      fillterClass() {
        
        var categoryList = [];
        for(var i=0; i<this.category.length; i++) {
          categoryList.push(this.category[i]);
        }

        var addressList = [];
        addressList.push(this.address);

        this.fillterData = {"category": categoryList, "area": addressList}
        
        console.log(this.fillterData);
        //필터 검색 API 호출
        this.$axios.post('/api/classes', this.fillterData)
        .then((res) => {
          this.classData = res.data;

          //리스트 목록 표시에 표시
          this.fillterDialog = false;
          this.title = "필터링한 사모임";
          this.suggestion = false;

          if(this.classData.length === 0) {
            this.isEmpty = true;
          } else {
            this.isEmpty = false;
          }

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
          
        })
        .catch((error) => {
          console.log(error);
        });
      },


      suggestionClick(value) {
        let large = this.small2LargeCategory(value);
        var categoryList = [];
        categoryList.push(large);

        var addressList = [];
        addressList.push(this.myInfo.address);

        var suggestionData = {"category": categoryList, "area": addressList};
        
        //필터 검색 API 호출
        this.$axios.post('/api/classes', suggestionData)
        .then((res) => {
          this.classData = res.data;
          this.title = value + " 사모임";
          this.suggestion = false;

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
        })
        .catch((error) => {
          console.log(error);
        });
      },


      small2LargeCategory(ct) {
        if (ct == "클라이밍" || ct == "골프" || ct == "테니스") {
          return "운동";
        } else if (ct == "드라이브" || ct == "캠핑") {
          return "여행";
        } else if (ct == "콘서트" || ct == "뮤지컬" || ct == "전시") {
          return "문화";
        } else if (ct == "밴드" || ct == "작곡") {
          return "음악";
        } else if (ct == "드로잉" || ct == "글쓰기") {
          return "창작";
        } else if (ct == "독서" || ct == "스터디" || ct == "외국어") {
          return "성장";
        } else if (ct == "유기견봉사" || ct == "재능기부") {
          return "봉사";
        } else if (ct == "유리" || ct == "디저트" || ct == "전통주") {
          return "요리";
        }
      },


      suggestionCategory() {
        this.$axios.get('/api/recommend/' + this.$store.state.loginUser)
        .then((res) => {
          this.recommendData = res.data;
          //console.log(this.recommendData);

          if(this.recommendData.length === 0) {
            this.isEmpty = true;
          } else {
            this.isEmpty = false;
          }

          for(var i=0; i<res.data.length; i++) {
            this.suggestionItems.push({"src" : this.imgObjectReturn(res.data[i].PHOTO_PATH)});
          }
        })
        .catch((error) => {
          console.log(error);
        });
      },


      imgObjectReturn(item){

        if(item === "climbing") {
          return this.climbing;
        } else if(item === "golf") {
          return this.golf;
        } else if(item === "tennis") {
          return this.tennis;
        } else if(item === "drive") {
          return this.drive;
        } else if(item === "camping") {
          return this.camping;
        } else if(item === "concert") {
          return this.concert;
        } else if(item === "musical") {
          return this.musical;
        } else if(item === "exhibition") {
          return this.exhibition;
        } else if(item === "band") {
          return this.band;
        } else if(item === "composition") {
          return this.composition;
        } else if(item === "drawing") {
          return this.drawing;
        } else if(item === "writing") {
          return this.writing;
        } else if(item === "reading") {
          return this.reading;
        } else if(item === "study") {
          return this.study;
        } else if(item === "foreign") {
          return this.foreign;
        } else if(item === "dog") {
          return this.dog;
        } else if(item === "donation") {
          return this.donation;
        } else if(item === "cooking") {
          return this.cooking;
        } else if(item === "dessert") {
          return this.dessert;
        } else if(item === "soju") {
          return this.soju;
        }
      }
    }
}
</script>
