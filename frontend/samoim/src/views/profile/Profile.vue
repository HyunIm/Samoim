<template>
  <div>
    <v-row>
      <v-col>
        <BackButton/>
      </v-col>
      <v-col class="mt-3">
        <h3>
          <center>
              프로필
          </center>
        </h3>
      </v-col>
      <v-col></v-col>
    </v-row>

    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <!--
        <v-badge
          bordered
          bottom
          color="grey"
          icon="mdi-pencil"
          offset-x="35"
          offset-y="35"
        >
        -->
          <v-list-item-avatar
            tile
            size="80"
          >
            <img :src="photoPath">
          </v-list-item-avatar>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            {{ this.name }} &nbsp;&nbsp;
            <v-chip
              @click="logout()"
            >
              로그아웃
            </v-chip>
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <v-row>
      <v-img
        class="mx-10 mt-10"
        src="../../assets/temperature.png">
      </v-img>
    </v-row>

    <v-row class="mx-8 mt-10">
      <v-autocomplete
        v-model="values"
        :items="items"
        outlined
        dense
        chips
        small-chips
        label="관심사"
        multiple
      ></v-autocomplete>
    </v-row>

    <v-row class="mx-8 mt-10">
      <v-btn
        x-large
        color="primary"
        dark
        @click="updateUserInfo()"
        block
        rounded
      >
        <h3 class="font-weight-black">수정하기</h3>
      </v-btn>
    </v-row>
  </div>
</template>

<script>
import coli from '@/assets/starfriends/coli.png';
import bb from '@/assets/starfriends/bb.png';
import force from '@/assets/starfriends/force.png';
import kiki from '@/assets/starfriends/kiki.png';
import ramu from '@/assets/starfriends/ramu.png';
import BackButton from '../../components/common/BackButton.vue';

  export default {
  components: { BackButton },
    name: 'Profile',

    data: () => ({
      items: ["운동", "여행", "문화", "음악", "창작", "성장", "봉사", "요리"],
      values: [],
      interest: "",
      name: undefined,
      updateInfo: {},
      photoPath: undefined,
      coli: coli,
      bb: bb,
      force: force,
      kiki: kiki,
      ramu: ramu,
    }),

    mounted() {
      this.getUserInfo();
    },

    methods: {
      getUserInfo() {
        this.$axios.get('/api/info/' + this.$store.state.loginUser)
        .then((res) => {
          // name
          this.name = res.data.name;

          // interest
          this.values = res.data.interest.split(',');

          //photo
          this.photoPath = res.data.photoPath;
          if(this.photoPath === "coli") {
            this.photoPath = this.coli
          } else if(this.photoPath === "bb") {
            this.photoPath = this.bb
          } else if(this.photoPath === "force") {
            this.photoPath = this.force
          } else if(this.photoPath === "kiki") {
            this.photoPath = this.kiki
          } else if(this.photoPath === "ramu") {
            this.photoPath = this.ramu
          }

        })
        .catch((error) => {
          console.log(error);
        });
      },
      updateUserInfo() {

        //interest string화
        this.interest = "";
        
        this.values.forEach(element => {
          this.interest = this.interest + element + ","
        });

        this.updateInfo = {email : this.$store.state.loginUser, interest: this.interest}

        this.$axios.put('/api/user/interest', this.updateInfo)
        .then(() => {
          //console.log(res);
          //수정완료 팝업 제공
          this.$swal({
            title: '수정 완료',
            text: '관심사 수정이 완료되었습니다.',
            icon: 'success',
            confirmButtonText: '확인'
          });
        })
        .catch((error) => {
          console.log(error);
        });
      },

      
      logout() {
        this.$router.replace('/intro')
      },
    },


  }
</script>
