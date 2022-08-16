<template>

  <v-container>
    <v-row>
      <v-col>
        <BackButton/>
      </v-col>
      <v-col class="mt-3">
        <h3>
          <center>
              회원가입
          </center>
        </h3>
      </v-col>
      <v-col></v-col>
    </v-row>

    <div v-if="this.$store.getters.getSignUpPage === 1">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>이메일을 입력해 주세요</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        로그인 시 사용할 이메일을 입력해주세요.
      </v-row>

      <v-row class="mt-15"/>

      <v-row class="mx-3 mt-15">
        <v-text-field 
          outlined
          label="samoim@kb.com"
          persistent-hint
          solo
          v-model="signUpForm.email"
          :counter="20"
          :rules="emailRules"
          required
          flat
          dense
        >
        </v-text-field>
      </v-row>
    </div>

    <!-- password 입력 -->
    <div v-if="this.$store.getters.getSignUpPage === 2">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>비밀번호를 입력해 주세요</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        영문과 숫자를 포함하여 6~15자를 작성해 주세요.
      </v-row>

      <v-row class="mt-15"/>
      
      <v-row class="mx-6  mt-15">
        <h5 class="font-weight-black">비밀번호</h5>
      </v-row>
      <v-row class="mx-3">
        <v-text-field 
          outlined
          label="비밀번호를 입력해 주세요"
          persistent-hint
          solo
          v-model="signUpForm.password"
          :counter="15"
          required
          flat
          dense
          :append-icon="passwordShow ? 'mdi-eye' : 'mdi-eye-off'"
          :type="passwordShow ? 'text' : 'password'"
          @click:append="passwordShow = !passwordShow"
        >
        </v-text-field>
      </v-row>

      <v-row class="mx-6  mt-10">
        <h5 class="font-weight-black">비밀번호 확인</h5>
      </v-row>
      <v-row class="mx-3">
        <v-text-field 
          outlined
          label="비밀번호를 한번 더 입력해주세요."
          persistent-hint
          solo
          v-model="passwordCheck"
          :counter="15"
          required
          flat
          dense
          :append-icon="passwordCheckShow ? 'mdi-eye' : 'mdi-eye-off'"
          :type="passwordCheckShow ? 'text' : 'password'"
          @click:append="passwordCheckShow = !passwordCheckShow"
        >
        </v-text-field>
      </v-row>
    </div>

    <div v-if="this.$store.getters.getSignUpPage === 3">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>이름을 입력해 주세요</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        정확한 본인 이름을 입력해주세요.
      </v-row>

      <v-row class="mt-15"/>

      <v-row class="mx-3 mt-15">
        <v-text-field 
          outlined
          label="김국민"
          persistent-hint
          solo
          v-model="signUpForm.name"
          :counter="20"
          :rules="nameRules"
          required
          flat
          dense
        >
        </v-text-field>
      </v-row>
    </div>

    <div v-if="this.$store.getters.getSignUpPage === 4">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>성별을 선택해 주세요</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        모임 추천 서비스를 위해 필요한 정보입니다.
      </v-row>

      <v-row class="mt-15"/>

      <v-row class="mx-3 mt-15">
        <v-col>
          <v-btn
            x-large
            block
            outlined
            color="grey"
            :class="{ pick : man }"
            @click="changeGender('man')"
          >
            남성
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            x-large
            block
            outlined
            color="grey"
            :class="{ pick : woman }"
            @click="changeGender('woman')"
          >
            여성
          </v-btn>
        </v-col>
      </v-row>
    </div>

    <div v-if="this.$store.getters.getSignUpPage === 5">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>생년월일을 입력해주세요</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        모임 추천 서비스를 위해 필요한 정보입니다.
      </v-row>

      <v-row class="mt-15 mx-3">
        <v-menu
          ref="menu"
          v-model="menu"
          :close-on-content-click="false"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="signUpForm.birth"
              label="생년월일"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker
            v-model="signUpForm.birth"
            :active-picker.sync="activePicker"
            :max="(new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)"
            min="1950-01-01"
            @change="save"
          ></v-date-picker>
        </v-menu>
      </v-row>
        
      <v-row class="mx-3 mt-15">
        
      </v-row>
    </div>

    <div v-if="this.$store.getters.getSignUpPage === 6">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>희망 활동 지역을 선택해주세요</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        모임 추천 서비스를 위해 필요한 정보입니다.
      </v-row>

      <v-row>
        <v-radio-group v-model="signUpForm.address" row>
              <v-radio
                v-for="(item, index) in locationData"
                :key="index"
                :label="item.ADDRESS"
                :value="item.ADDRESS"
              ></v-radio>
        </v-radio-group>
      </v-row>

      <v-row class="mx-3 mt-15">
        
      </v-row>
    </div>

    <div v-if="this.$store.getters.getSignUpPage === 7">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <center class="mt-15 mx-3">
        <v-img
          max-height="128"
          max-width="128"
          src="../assets/check.png"
        >
        </v-img>
      </center>

      <h1><center>가입 완료</center></h1>
    </div>

    <div v-if="this.$store.getters.getSignUpPage === 8">
    <h1>
      <center>
          관심사가 무엇인가요?
      </center>
    </h1>

    <v-list-item
        class="ml-3"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../assets/large_category/0_workout.png" :class="{ choice : isWorkout }" @click="isWorkout = !isWorkout">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../assets/large_category/1_travel.png" :class="{ choice : isTravel }" @click="isTravel = !isTravel">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ml-3"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../assets/large_category/2_culture.png" :class="{ choice : isCulture }" @click="isCulture = !isCulture">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../assets/large_category/3_music.png" :class="{ choice : isMusic }" @click="isMusic = !isMusic">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ml-3"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../assets/large_category/4_create.png" :class="{ choice : isCreate }" @click="isCreate = !isCreate">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../assets/large_category/5_growth.png" :class="{ choice : isGrowth }" @click="isGrowth = !isGrowth">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ml-3"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../assets/large_category/6_volunteer.png" :class="{ choice : isVolunteer }" @click="isVolunteer = !isVolunteer">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../assets/large_category/7_cook.png" :class="{ choice : isCook }" >
        </v-list-item-avatar>
      </v-list-item>
    </div>

    <v-btn
      class="mr-4 mt-10"
      x-large
      color="primary"
      dark
      @click="nextPage()"
      block
      rounded
    >
      <h3 class="font-weight-black">다음</h3>
    </v-btn>

  </v-container>
</template>

<script>
import BackButton from '../components/common/BackButton.vue'

  export default {
    components: {
      BackButton,
    },

    methods: {
      changeGender(gender){
        if(gender === 'man') {
          this.man = true;
          this.woman = false;

          this.signUpForm.gender = "남"
        } else {
          this.man = false;
          this.woman = true;

          this.signUpForm.gender = "여"
        }
      },

      nextPage() {
        if(this.$store.state.signupPage === 8) {

          // 관심사 pick data 생성
          this.signUpForm.interest = ""

          if(this.isWorkout === true) {
            this.signUpForm.interest = 
            this.signUpForm.interest + "운동,"
          } if(this.isTravel === true) {
            this.signUpForm.interest = 
            this.signUpForm.interest + "여행,"
          } if(this.isCulture === true) {
            this.signUpForm.interest = 
            this.signUpForm.interest + "문화,"
          } if(this.isMusic === true) {
            this.signUpForm.interest = 
            this.signUpForm.interest + "음악,"
          } if(this.isCreate === true) {
            this.signUpForm.interest = 
            this.signUpForm.interest + "창작,"
          } if(this.isGrowth === true) {
            this.signUpForm.interest = 
            this.signUpForm.interest + "성장,"
          } if(this.isVolunteer === true) {
            this.signUpForm.interest = 
            this.signUpForm.interest + "봉사,"
          } if(this.isCook === true) {
            this.signUpForm.interest = 
            this.signUpForm.interest + "요리,"
          }

          // 관심사 등록 API
          this.$axios.put('/api/user/interest', this.signUpForm)
          .then((res) => {
            console.log(res);

            //로그인 상태로 메인 페이지로 이동
            this.$router.replace('/main')
          })
          .catch((error) => {
            console.log(error);
          });
        } else if(this.$store.state.signupPage === 6) {
          // 회원가입 API 호출
          this.signUpForm.city = "서울";
          
          this.$axios.post('/api/signUp', this.signUpForm)
          .then((res) => {
            console.log(res);

            // 회원가입 성공시 전역변수에 login 정보 저장
            this.$store.state.loginUser = this.signUpForm.email;

          })
          .catch((error) => {
            console.log(error);
          });

          // response 200이면
          this.$store.commit('changePage');
        } else if(this.$store.state.signupPage === 5) {
          // loaction API 호출
          this.$axios.get('/api/location')
          .then((res) => {
            this.locationData = res.data;
            console.log(this.locationData);
          })
          .catch((error) => {
            console.log(error);
          });

          this.$store.commit('changePage');
        } else {
          this.$store.commit('changePage');
        }
        
      },
      save (date) {
        this.$refs.menu.save(date)
      },
    },

    computed: {
      changePage() {
        return this.$store.state.signupPage
      }
    },

    watch: {
      changePage() {
        this.progress = 17 * this.$store.state.signupPage
      },
      menu (val) {
        val && setTimeout(() => (this.activePicker = 'YEAR'))
      },
    },

    data: () => ({
      man: false,
      woman: false,
      progress: 20,
      valid: false,
      passwordShow: false,
      passwordCheckShow: false,
      password: '',
      passwordCheck: '',
      activePicker: null,
      date: null,
      menu: false,
      firstname: '',
      lastname: '',
      name: '',
      nameRules: [
        v => !!v || '이름을 입력해주세요',
        v => v.length >= 1 || 'Name must be less than 10 characters',
      ],
      birth: '',
      birthRules: [
        v => !!v || '생년월일을 입력해주세요'
      ],
      email: '',
      emailRules: [
        v => !!v || '이메일을 입력해주세요',
        v => /.+@.+/.test(v) || '유효한 이메일 주소가 아닙니다',
      ],
      pw: '',
      pwRules: [
        v => !!v || '비밀번호를 입력해주세요',
        v => /.+@.+/.test(v) || '비밀번호를 입력해주세요',
      ],
      sex: ['남성', '여성'],
      signUpForm:{
        email : "",
        password : "",
        gender : "",
        birth : "",
        city : "",
        address : "",
        name : "",
        phone : "",
        photo_path : "",
        interest : ""
      },

      isWorkout: false,
      isTravel: false,
      isCulture: false,
      isMusic: false,
      isCreate: false,
      isGrowth: false,
      isVolunteer: false,
      isCook: false,

      locationData: [
        { CITY: '서울', ADDRESS: '강남구' },
      ],
    }),
  }
</script>

<style scoped>
.pick {
    border: 4px solid #1976D2;
    border-radius: 7px 7px 7px 7px;
}
</style>

<style scoped>
.choice {
    border: 5px solid #FFBC00;
    border-radius: 20px 20px 20px 20px;
}
</style>
