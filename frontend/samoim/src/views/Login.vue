<template>
  <v-container >
    <v-row>
      <v-col>
        <BackButton/>
      </v-col>
      <v-col>
        
      </v-col>
    </v-row>

    <v-row class="ml-2">
      <v-img
        max-height="40"
        max-width="150"
        :src="samoimLogo"
      ></v-img>
    </v-row>

    <form class="mt-10">
      <v-row class="mx-6">
        <h5 class="font-weight-black">이메일</h5>
      </v-row>
      <v-row class="mx-4">
        <v-text-field 
          outlined
          label="이메일을 입력해 주세요."
          persistent-hint
          solo
          v-model="loginForm.email"
          :counter="20"
          :rules="emailRules"
          required
          flat
          dense
          @input="loginChange()"
        >
        </v-text-field>
      </v-row>

      <v-row class="mx-6">
        <h5 class="font-weight-black">비밀번호</h5>
      </v-row>
      <v-row class="mx-4">
        <v-text-field 
          outlined
          label="비밀번호를 입력해 주세요."
          persistent-hint
          solo
          v-model="loginForm.password"
          :counter="20"
          required
          flat
          dense
          :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
          :type="show ? 'text' : 'password'"
          @click:append="show = !show"
          @input="loginChange()"
        >
        </v-text-field>
      </v-row>

      <v-row class="justify-center mx-1 mt-4">
        <v-col>
          <!--
          <router-link
            to="/main"
            style="text-decoration: none; color: inherit;"  
          >
          -->
          <v-btn
            class="mr-4"
            x-large
            color="primary"
            @click="login()"
            block
            rounded
            :disabled="!buttonActive"
          >
            <h3 class="font-weight-black">로그인</h3>
          </v-btn>
        </v-col>
      </v-row>
    </form>

    <v-row class="mt-3">
      <v-spacer/>
      <router-link
        to="/signup"
        style="text-decoration: none; color: inherit;"  
      >
      <v-btn 
        class="mr-7"
        text
        color="grey"
      >
        <h4 class="font-weight-black">회원가입하기</h4>
      </v-btn>
      </router-link>
    </v-row>
  </v-container>
</template>

<script>
import BackButton from '../components/common/BackButton.vue'
import Logo from '../assets/samoimLogo.png';

  export default {
    name: 'Login',

    components: {
      BackButton,
    },

    methods: {
      login(){
        // 로그인 api 호출
        this.$axios.post('/api/login', this.loginForm)
          .then((res) => {
            if(res.data) {
              // 로그인 성공
              // this.$store.state.loginUser = this.loginForm.email;
              this.$store.commit('changeUser', this.loginForm.email);

              //메인페이지로 이동
              this.$router.replace('/main')

            } else {
              // 로그인 실패 
              

              //로그인 실패 팝업 제공
              this.$swal({
                title: '로그인 실패',
                text: '이메일 또는 비밀번호를 다시 확인해 주세요',
                icon: 'warning',
                confirmButtonText: '확인'
              }).then(() => {
                this.loginForm.email = "";
                this.loginForm.password = "";
                this.buttonActive = false;
              });
            }

          })
          .catch((error) => {
            console.log(error);
          });
        
      },
      loginChange() {
        if(this.loginForm.email == "" || this.loginForm.password == "") {
          this.buttonActive = false;
        } else {
          this.buttonActive = true;
        }
      }
    },

    data: () => ({
      samoimLogo: Logo,
      emailRules: [
        v => !!v || '이메일을 입력해주세요',
        v => /.+@.+/.test(v) || '유효한 이메일 주소가 아닙니다',
      ],
      loginForm: {
        email: '',
        password: '',
      },
      show: false,
      buttonActive: false,
    }),
  }
</script>
