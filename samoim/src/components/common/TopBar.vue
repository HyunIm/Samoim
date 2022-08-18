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
            @click="refreshAll()"
          ></v-img>
        </div>

      <v-spacer></v-spacer>
      <!-- <v-icon
        class="mr-5"
        x-large
        color="black darken-2"
        @click="openFillterDialog()"
      >
        mdi-magnify
      </v-icon> -->
      <router-link 
        style="text-decoration: none; color: inherit;" 
        to="/profile"
      >
        <v-avatar
          size="40"
          color="black"
        >
          <img :src="this.myAvatar">
        </v-avatar>
      </router-link>
      <!--
      <v-icon
        color="black darken-2"
        class="ml-2"
        @click="searchDialog = !searchDialog"
      >
        mdi-magnify
      </v-icon>
      -->

      <!-- <v-bottom-sheet v-model="fillterDialog">
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
      </v-bottom-sheet> -->


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
import coli from '@/assets/starfriends/coli.png';
import bb from '@/assets/starfriends/bb.png';
import force from '@/assets/starfriends/force.png';
import kiki from '@/assets/starfriends/kiki.png';
import ramu from '@/assets/starfriends/ramu.png';

  export default {
    name: 'TopBar',

    components: {
    },

    data: () => ({
      samoimLogo: Logo,
      fillterDialog: false,
      searchDialog: false,
      categoriesData: [],
      locationData: [
        { CITY: '서울', ADDRESS: '강남구' },
        { CITY: '서울', ADDRESS: '영등포구' }
      ],
      testData: [],
      address: undefined,
      category: [],
      fillterData: {},
      classData: [],
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
      myAvatar: undefined,
      coli: coli,
      bb: bb,
      force: force,
      kiki: kiki,
      ramu: ramu,
    }),

    mounted() {
      // this.getCategory();
      this.getMyInfo();
      //this.getLocation();

      //console.log(this.$store.state.loginUser);
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
      // getCategory() {
      //   this.$axios.get('/api/categories')
      //   .then((res) => {
      //     this.categoriesData = res.data;
      //     //console.log(this.categoriesData);
      //   })
      //   .catch((error) => {
      //     console.log(error);
      //   });
      // },


      // getLocation() {
      //   this.$axios.get('/api/location')
      //   .then((res) => {
      //     this.locationData = res.data;
      //     //console.log(this.locationData);
      //   })
      //   .catch((error) => {
      //     console.log(error);
      //   });
      // },
      openFillterDialog() {
        this.fillterDialog = true;
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
          this.$emit("fillterData", this.classData);
          
        })
        .catch((error) => {
          console.log(error);
        });
      },
      refreshAll() {
        window.location.reload();
      },


      getMyInfo() {
        this.$axios.get('/api/info/' + this.$store.state.loginUser)
        .then((res) => {
          this.myAvatar = res.data.photoPath;
          if(this.myAvatar === "coli") {
            this.myAvatar = this.coli
          } else if(this.myAvatar === "bb") {
            this.myAvatar = this.bb
          } else if(this.myAvatar === "force") {
            this.myAvatar = this.force
          } else if(this.myAvatar === "kiki") {
            this.myAvatar = this.kiki
          } else if(this.myAvatar === "ramu") {
            this.myAvatar = this.ramu
          }
        })
        .catch((error) => {
          console.log(error);
        });
      },
    }
  }
</script>