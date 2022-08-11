<template>
  <div>
  <h1>
    <center>
        회원가입
    </center>
  </h1>

  <v-form v-model="valid">
    <v-container>
      <v-row>
        <!-- 
        NAME / 이름
        BIRTH / 생년월일 ex 19940414

        GENDER / 성별 -> 라디어 버튼

        PHONE / 전화번호
        EMAIL / 이메일
        PASSWORD / 비밀번호
        PASSWORD / 비밀번호 확인
              

        CITY / 시도
        ADDRESS / 구군 -->
        <v-col
          cols="12"
          md="4"
        >
          <v-text-field
            v-model="firstname"
            :rules="nameRules"
            label="이름"
            required
          ></v-text-field>
          <v-text-field
            v-model="birth"
            :rules="birthRules"
            label="생년월일"
            required
          ></v-text-field>
          <v-select
            :items="sex"
            label="성별"
          ></v-select>
        <v-text-field
            label="전화번호"
            required
          ></v-text-field>
          <v-text-field
            v-model="email"
            :rules="emailRules"
            label="이메일"
            required
          ></v-text-field>

          <v-text-field
            v-model="pw"
            :rules="pwRules"
            label="비밀번호"
            required
          ></v-text-field>

        <v-text-field
            v-model="pwCheck"
            :rules="pwRules"
            label="비밀번호 확인"
            required
          ></v-text-field>
          <v-select
            :items="items"
            label="시/도"
          ></v-select>
          <v-select
            :items="items2"
            label="군/구"
          ></v-select>
        </v-col>
      </v-row>
    </v-container>
  </v-form>

<template>
        <v-btn
            block
            dark
            color="#FFBC00"
        >
            가입하기
        </v-btn>
    </template>
  </div>
</template>

<script>
  export default {
    data: () => ({
      valid: false,
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