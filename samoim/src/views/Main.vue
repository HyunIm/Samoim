<template>
  <v-container>

    <!-- TopBar -->
    <TopBar></TopBar>

    <!-- 추천 모임 -->
    <v-row>
      <v-carousel 
        height="300" 
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
      임시로 표시 : {{ this.$store.state.loginUser }}
    </v-row>

    <!-- 모임 리스트 -->
    <v-row class="mx-3 mt-5">
      <h2>내 주변 사모임</h2>
    </v-row>

    <v-row>
        <v-list-item
          v-for="(item, index) in classData"
          :key="index"
          >
          <router-link
            style="text-decoration: none; color: inherit;" 
            to="/gatheringinformation" 
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
                    현재인원 / {{ item.maxMember }}
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

import football from '../assets/main/football.jpg';
import band from '../assets/main/band.jpg';
import surfing from '../assets/main/surfing.jpg';
import camping from '../assets/main/camping.jpg';

export default {
  name: 'Main',

  components: {
    TopBar,
    //BottomBar
  },

  mounted() {
      this.getClassList();
    },

  data: () => ({
    test: 'SAMOIM MAIN PAGE',
    suggestionItems: [
      {
        src: football,
      },
      {
        src: band,
      },
      {
        src: surfing,
      },
      {
        src: camping,
      },
    ],
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
    ]
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
    }
}
</script>
