<template>
  <v-row>
      <v-app-bar
        class=""
        fixed
        style="padding:0 5%"
        flat
        color="white"
      >
        <div>
          <v-img
            max-height="40"
            max-width="150"
            :src="samoimLogo"
          ></v-img>
        </div>

      <v-spacer></v-spacer>
      <v-icon
        color="black darken-2"
        @click="openFillterDialog()"
      >
        mdi-filter-menu-outline
      </v-icon>
      <v-icon
        color="black darken-2"
        class="ml-2"
        @click="searchDialog = !searchDialog"
      >
        mdi-magnify
      </v-icon>

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
            <v-row>
              <v-radio-group v-model="address" row>
                    <v-radio
                      v-for="(item, index) in locationData"
                      :key="index"
                      :label="item.ADDRESS"
                      :value="item.ADDRESS"
                    ></v-radio>
              </v-radio-group>
            </v-row>
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


      <!-- search dialog -->
      <v-bottom-sheet v-model="searchDialog">
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
      </v-bottom-sheet>
      </v-app-bar>
    </v-row>
    

</template>

<script>
import Logo from '../../assets/samoimLogo.png';

  export default {
    name: 'TopBar',

    components: {
    },

    data: () => ({
      samoimLogo: Logo,
      fillterDialog: false,
      searchDialog: false,
      categoriesData: [
        { id: '1', name: '문화/예술' },
      ],
      locationData: [
        { CITY: '서울', ADDRESS: '강남구' },
      ],
      testData: [],
      address: undefined,
      category: [],
    }),

    mounted() {
      this.getCategory();
      this.getLocation();

      console.log(this.$store.state.loginUser);
    },

    methods: {
      /*
      getCategory: async function() {
        const response = await this.$axios.get('/api/categories');

        if(response.statusText === 'OK') {
          this.categoriesData = response.data;
          //console.log(this.categoriesData);
        } else {
          console.log(response);
        }
      },
      */
      getCategory() {
        this.$axios.get('/api/categories')
        .then((res) => {
          this.categoriesData = res.data;
          console.log(this.categoriesData);
        })
        .catch((error) => {
          console.log(error);
        });
      },
      getLocation() {
        this.$axios.get('/api/location')
        .then((res) => {
          this.locationData = res.data;
          console.log(this.locationData);
        })
        .catch((error) => {
          console.log(error);
        });
      },
      openFillterDialog() {
        this.fillterDialog = true;
      },
      fillterClass() {
        console.log(this.address);
        console.log(this.category);

        //필터 검색 API 호출
      }
    }
  }
</script>