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
        ></v-carousel-item>
      </v-carousel>
    </v-row>

    <!-- 로그인 사용자 정보 -->
    <v-row>
      - 로그인 email(임시표시) : {{ this.$store.state.loginUser }}
    </v-row>

    <!-- 모임 리스트 -->
    <v-row class="mx-3 mt-10">
      <h2>{{ title }}</h2>
    </v-row>

    <v-row>
        <v-list-item
          v-for="(item, index) in classData"
          :key="index"
          >
          <router-link
            style="text-decoration: none; color: inherit;" 
            :to="{name: 'GatheringInformation', params: {classId: item.id}}"
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
                  size="80"
                  color="grey"
                ></v-list-item-avatar>
                <v-list-item-content>
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



export default {
  name: 'Main',

  components: {
    TopBar,
    //BottomBar
  },

  mounted() {
      this.getClassList();
      this.suggestionCategory();
    },

  data: () => ({
    test: 'SAMOIM MAIN PAGE',
    suggestionItems: [
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
    recommendData: undefined
  }),

  methods: {
      getClassList() {
        this.$axios.get('/api/classes')
        .then((res) => {
          this.classData = res.data;
          //console.log(this.classData);
        })
        .catch((error) => {
          console.log(error);
        });
      },
      fillterData(value) {
        this.classData = value;
        this.title = "필터링한 사모임"
        this.suggestion = false;
      },
      suggestionCategory() {
        this.$axios.get('/api/recommend/' + this.$store.state.loginUser)
        .then((res) => {
          this.recommendData = res.data;
          //console.log(this.recommendData);

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
