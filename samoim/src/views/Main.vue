<template>
  <v-container>

    <!-- TopBar -->
    <TopBar></TopBar>

    <!-- 추천 모임 -->
    <v-row>
      <v-carousel height="350" cycle show-arrows-on-hover>
        <v-carousel-item
          v-for="(item,i) in suggestionItems"
          :key="i"
          :src="item.src"
          reverse-transition="fade-transition"
          transition="fade-transition"
        ></v-carousel-item>
      </v-carousel>
    </v-row>

    <!-- 모임 리스트 -->
    <v-row>
        <v-list-item
          v-for="(item, index) in classData"
          :key="index"
          >

          <v-col cols="12">
            <v-card
              color="#385F73"
              dark
            >
              <v-card-title class="text-h5">
                {{ item.name }}
              </v-card-title>

              <v-card-subtitle>
                {{ item.largeCategory }} - {{ item.smallCategory }}
              </v-card-subtitle>

              <v-card-text>
                {{ item.detailContents }}
              </v-card-text>

              <v-card-actions>
                <router-link
                  style="text-decoration: none; color: inherit;" 
                  to="/gatheringinformation" 
                >
                  <v-btn text>
                    상세보기
                  </v-btn>
                </router-link>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-list-item>
    </v-row>

  </v-container>
</template>

<script>
import tennis from '../assets/tennis.png';
import TopBar from '../components/common/TopBar.vue'
//import BottomBar from '../components/common/BottomBar.vue'

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
        src: tennis,
      },
      {
        src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg',
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
          console.log(this.classData);
        })
        .catch((error) => {
          console.log(error);
        });
      },
    }
}
</script>
