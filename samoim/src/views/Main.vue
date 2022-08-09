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
        <v-col cols="12">
          <v-card
            color="#385F73"
            dark
          >
            <v-card-title class="text-h5">
              Unlimited music now
            </v-card-title>

            <v-card-subtitle>Listen to your favorite artists and albums whenever and wherever, online and offline.</v-card-subtitle>

            <v-card-actions>
              <v-btn text>
                Listen Now
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>

        <v-col cols="12">
          <v-card
            color="#385F73"
            dark
          >
            <v-card-title class="text-h5">
              Unlimited music now
            </v-card-title>

            <v-card-subtitle>Listen to your favorite artists and albums whenever and wherever, online and offline.</v-card-subtitle>

            <v-card-actions>
              <v-btn text>
                Listen Now
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>

        <v-col cols="12">
          <v-card
            color="#385F73"
            dark
          >
            <v-card-title class="text-h5">
              Unlimited music now
            </v-card-title>

            <v-card-subtitle>Listen to your favorite artists and albums whenever and wherever, online and offline.</v-card-subtitle>

            <v-card-actions>
              <v-btn text>
                Listen Now
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>

        <v-col cols="12">
          <v-card
            color="#385F73"
            dark
          >
            <v-card-title class="text-h5">
              Unlimited music now
            </v-card-title>

            <v-card-subtitle>Listen to your favorite artists and albums whenever and wherever, online and offline.</v-card-subtitle>

            <v-card-actions>
              <v-btn text>
                Listen Now
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>

    </v-row>

    <BottomBar></BottomBar>

  </v-container>
</template>

<script>
import tennis from '../assets/tennis.png';
import TopBar from '../components/common/TopBar.vue'
import BottomBar from '../components/common/BottomBar.vue'

export default {
  name: 'Main',

  components: {
    TopBar,
    BottomBar
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
  }),
}
</script>
