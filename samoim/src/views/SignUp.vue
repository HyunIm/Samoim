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
          v-model="email"
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
          v-model="password"
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
            :class="{ choice : man }"
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
            :class="{ choice : woman }"
            @click="changeGender('woman')"
          >
            여성
          </v-btn>
        </v-col>
      </v-row>
    </div>

    <div v-if="this.$store.getters.getSignUpPage === 4">
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

      <v-row class="mt-15"/>
        
      <v-row class="mx-3 mt-15">
        
      </v-row>
    </div>

    <div v-if="this.$store.getters.getSignUpPage === 5">
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
        } else {
          this.man = false;
          this.woman = true;
        }
      }
    },

    computed: {
      changePage() {
        return this.$store.state.signupPage
      }
    },

    watch: {
      changePage() {
        this.progress = 20 * this.$store.state.signupPage
      }
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
      activePicker: 'YEAR',
      date: null,
      menu: true,
      firstname: '',
      lastname: '',
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
      items: ['서울특별시', '경기도', '부산광역시', '대구광역시', '인천광역시', '충북', '충남',
       '세종', '대전', '경상도', '전라도'],
      items2: ['강남구', '강동구', '강북구', '강서구', '관악구']
    
    }),
  }
</script>

<style scoped>
.choice {
    border: 4px solid #1976D2;
    border-radius: 7px 7px 7px 7px;
}
</style>
