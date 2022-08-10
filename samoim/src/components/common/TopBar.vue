<template>
  <v-row>
      <v-app-bar
        class=""
        fixed
        style="padding:0 5%"
        flat
      >
        <div class="d-flex align-center">
          <h1>
            <p class="font-2 mb-n1" :style="`color:#FBC02D`">SAMOIM</p>
          </h1>
        </div>

      <v-spacer></v-spacer>
      <v-icon
        large
        color="black darken-2"
        @click="openFillterDialog()"
      >
        mdi-filter-cog-outline
      </v-icon>
      <v-icon
        large
        color="black darken-2"
        class="ml-2"
        @click="searchDialog = !searchDialog"
      >
        mdi-magnify
      </v-icon>

      <!-- fillter dialog -->
      <v-dialog
        fullscreen
        hide-overlay
        transition="dialog-top-transition"
        v-model="fillterDialog"
      >
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
            <v-list-item
              v-for="(item, i) in categoriesData"
              :key="i"
              >
              {{ item.name }}
            </v-list-item>
          </v-card-text>

          <v-card-subtitle class="mt-3">
            <h2>지역</h2>
          </v-card-subtitle>
          <v-card-text>
            API호출 데이터 바인딩
          </v-card-text>

          <v-card-actions>
            <v-btn>
              검색
            </v-btn>
          </v-card-actions>

        </v-card>

      </v-dialog>


      <!-- search dialog -->
      <v-dialog
        fullscreen
        hide-overlay
        transition="dialog-top-transition"
        v-model="searchDialog"
      >
        <v-card>
          <v-card-title>
            <v-btn
              icon
              color="black"
              @click="searchDialog = false"
              class="mb-5"
            >
              <v-icon>mdi-close</v-icon>
            </v-btn>

            <v-spacer></v-spacer>

            <v-text-field
              label="Search"
              solo-inverted
              rounded
              dense
              prepend-inner-icon="mdi-magnify"
            ></v-text-field>
          </v-card-title>

          <v-card-subtitle class="mt-2">
            <h2>인기검색어</h2>
          </v-card-subtitle>
          <v-list
            three-line
            subheader
            class="ml-3"
          >
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title>API호출 데이터 바인딩</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-card>
      </v-dialog>
      </v-app-bar>
    </v-row>
    

</template>

<script>
import axios from 'axios'

  export default {
    name: 'TopBar',

    components: {
    },

    data: () => ({
      fillterDialog: false,
      searchDialog: false,
      categoriesData: [],
      items: [
        { text: 'Real-Time', icon: 'mdi-clock' },
        { text: 'Audience', icon: 'mdi-account' },
        { text: 'Conversions', icon: 'mdi-flag' },
      ],
    }),

    mounted() {
      this.getCategory();
    },

    methods: {
      getCategory: async function() {
        const response = await axios.get('/api/categories');

        if(response.statusText === 'OK') {
          this.categoriesData = response.data;
          console.log(this.categoriesData);
        } else {
          console.log(response);
        }
      },
      openFillterDialog() {
        this.fillterDialog = true;
      }
    }
  }
</script>