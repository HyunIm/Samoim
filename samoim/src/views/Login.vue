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
      <v-img>
        <v-img
          max-height="40"
          max-width="150"
          :src="samoimLogo"
        ></v-img>
      </v-img>
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
          v-model="email"
          :counter="20"
          :rules="emailRules"
          required
          flat
          dense
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
          v-model="password"
          :counter="20"
          required
          flat
          dense
          :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
          :type="show ? 'text' : 'password'"
          @click:append="show = !show"
        >
        </v-text-field>
      </v-row>

      <v-row class="justify-center mx-1 mt-4">
        <v-col>
          <router-link
            to="/main"
            style="text-decoration: none; color: inherit;"  
          >
            <v-btn
              class="mr-4"
              x-large
              color="primary"
              dark
              @click="submit"
              block
              rounded
            >
              <h3 class="font-weight-black">로그인</h3>
            </v-btn>
          </router-link>
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
        <h5 class="font-weight-black">회원가입하기</h5>
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

    data: () => ({
      samoimLogo: Logo,
      email: '',
      emailRules: [
        v => !!v || '이메일을 입력해주세요',
        v => /.+@.+/.test(v) || '유효한 이메일 주소가 아닙니다',
      ],
      password: '',
      show: false
    }),
  }
</script>
