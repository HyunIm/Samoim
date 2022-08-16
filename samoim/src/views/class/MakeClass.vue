<template>
  <v-container >
    <v-row>
      <v-col>
        <BackButton/>
      </v-col>
      <v-col class="mt-3">
        <h3>
          <center>
              모임 만들기
          </center>
        </h3>
      </v-col>
      <v-col></v-col>
    </v-row>


    <div v-if="makeStep === 1">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>어떤 모임을 열어볼까요?</h2>
      </v-row>

      <v-list-item
        class="ma-6"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/workout.png" :class="{ choice : isWorkout }" @click="interestPick('isWorkout')">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/culture.png" :class="{ choice : isCulture }" @click="interestPick('isCulture')">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ma-6"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/music.png" :class="{ choice : isMusic }" @click="interestPick('isMusic')">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/camping.png" :class="{ choice : isCamping }" @click="interestPick('isCamping')">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ma-6"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/art.png" :class="{ choice : isArt }" @click="interestPick('isArt')">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/cook.png" :class="{ choice : isCook }" @click="interestPick('isCook')">
        </v-list-item-avatar>
      </v-list-item>
    </div>


    <div v-if="makeStep === 2">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>모임 제목을 작성해볼까요?</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        모임에 사용할 제목을 입력해주세요.
      </v-row>

      <v-row class="mt-15"/>

      <v-row class="mx-3 mt-15">
        <v-text-field 
          outlined
          label="여의도로 산책 하러가요!"
          persistent-hint
          solo
          :counter="40"
          required
          flat
          dense
          ref="makeClassForm.name"
          v-model="makeClassForm.name"
        >
        </v-text-field>
      </v-row>
    </div>


    <div v-if="makeStep === 3">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>모임을 소개해볼까요?</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        자세히 작성할 수록 멤버들의 신청률도 높아져요!
      </v-row>

      <v-row class="mt-15"/>

      <v-file-input
        label="사진 추가"
        filled
        prepend-icon="mdi-camera"
      ></v-file-input>

      <v-text-field 
        outlined
        label="내용을 입력해 주세요."
        persistent-hint
        solo
        :counter="80"
        required
        flat
        dense
        ref="makeClassForm.detail_contents"
        v-model="makeClassForm.detail_contents"
      >
      </v-text-field>
    </div>


    <div v-if="makeStep === 4">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>언제 만날까요?</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        모임 하루 전, 자동으로 신청이 마감됩니다.
      </v-row>

      <v-row class="mt-15"/>

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
            v-model="makeClassForm.open_date"
            ref="makeClassForm.open_date"
            label="모임 날짜"
            prepend-icon="mdi-calendar"
            readonly
            v-bind="attrs"
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker
          v-model="makeClassForm.open_date"
          ref="makeClassForm.open_date"
          :active-picker.sync="activePicker"
          :min="(new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)"
          @change="save"
        ></v-date-picker>
      </v-menu>
    </div>


    <div v-if="makeStep === 5">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>어디서 만날까요?</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        모임 장소를 입력해주세요.
      </v-row>

      <v-row class="mt-15"/>

      <v-text-field
        ref="makeClassForm.address"
        v-model="makeClassForm.address"
        outlined
        label="서울 영등포구"
        persistent-hint
        solo
        :counter="80"
        required
        flat
        dense
      >
      </v-text-field>
    </div>


    <div v-if="makeStep === 6">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>몇 명이서 함께 할까요?</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        본인을 포함한 총 참여 인원 수를 알려주세요.
      </v-row>

      <v-row class="mt-15"/>

      <v-row class="mt-5 mx-3">
        참여 인원 : {{ makeClassForm.max_member }} 명
      </v-row>
      <v-row class="mt-15"/>

      <v-card>
        <v-card-text>
          <v-slider
            ref="makeClassForm.max_member"
            v-model="makeClassForm.max_member"
            step=1
            thumb-label
            ticks
            min=3
            max=8
          ></v-slider>
        </v-card-text>
      </v-card>
    </div>


    <div v-if="makeStep === 7">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <center class="mt-15 mx-3">
        <v-img
          max-height="128"
          max-width="128"
          src="../../assets/check.png"
        >
        </v-img>
      </center>

      <h1><center>만들기 완료</center></h1>
    </div>


    <v-footer class="mb-2" color="white">
      <v-btn
        class="mr-4"
        x-large
        color="primary"
        @click="nextPage()"
        block
        rounded
        :disabled="nextCheck"
      >
        <h3 class="font-weight-black">다음</h3>
      </v-btn>
    </v-footer>
  </v-container>
</template>

<script>
import BackButton from '../../components/common/BackButton.vue'
export default {
  components: { BackButton },

  data: () => ({
    makeStep: 1,
    progress: 100/7,
    nextCheck: true,

    makeClassForm: {
      address: "",
      city: "서울",
      detail_contents: "",
      id: 0,
      large_category: "string",
      max_member: 3,
      name: "",
      open_date: null,
      owner_id: "",
      photo_path: "string",
      small_category: "string",
    },
    
    isWorkout: false,
    isCulture: false,
    isMusic: false,
    isCamping: false,
    isCook: false,
    isArt: false,

    activePicker: null,
    menu: false,
  }),

  watch: {
    menu(val) {
      val && setTimeout(() => (this.activePicker = 'DATE'))
    },

    makeStep: function() {
      if (this.makeStep === 7) {
        this.nextCheck = false
      } else if (this.makeStep === 6) {
        this.nextCheck = false
      }
    },

    makeClassForm: {
      handler(val) {
        if (this.makeStep === 2) {
          if (this.makeClassForm.name.length >= 1) {
            this.nextCheck = false
          } else {
            this.nextCheck = true
          }
        } else if (this.makeStep === 3) {
          if (this.makeClassForm.detail_contents.length >= 1) {
            this.nextCheck = false
          } else {
            this.nextCheck = true
          }
        } else if (this.makeStep === 4) {
          if (this.makeClassForm.open_date.length >= 1) {
            this.nextCheck = false
          } else {
            this.nextCheck = true
          }
        } else if (this.makeStep === 5) {
          if (this.makeClassForm.address.length >= 1) {
            this.nextCheck = false
          } else {
            this.nextCheck = true
          }
        } else if (this.makeStep === 6) {
          this.nextCheck = false
        }
      },
      deep: true,
    },
  },

  methods: {
    nextPage() {
      if(this.makeStep === 7) {
        this.$router.replace('/main')
        this.$axios.post('/api/create/' + this.$store.state.loginUser, this.makeClassForm)
        .then((res) => {
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
      } else {
        this.makeStep += 1
        this.progress += 100/7
      }

      this.nextCheck = true
    },

    save (open_date) {
      this.$refs.menu.save(open_date)
    },

    interestPick(interest) {
      this.isWorkout =  false
      this.isCulture = false
      this.isMusic = false
      this.isCamping = false
      this.isCook = false
      this.isArt = false

      if (interest === 'isWorkout') {
        this.isWorkout = true
        this.makeClassForm.large_category = "운동"
      } else if (interest === 'isCulture') {
        this.isCulture = true
        this.makeClassForm.large_category = "문화"
      } else if (interest === 'isMusic') {
        this.isMusic = true
        this.makeClassForm.large_category = "음악"
      } else if (interest === 'isCamping') {
        this.isCamping = true
        this.makeClassForm.large_category = "캠핑"
      } else if (interest === 'isCook') {
        this.isCook = true
        this.makeClassForm.large_category = "요리"
      } else if (interest === 'isArt') {
        this.isArt = true
        this.makeClassForm.large_category = "예술"
      }

      this.nextCheck = false
    },
  },
}
</script>

<style scoped>
.choice {
    border: 5px solid #1976D2;
    border-radius: 20px 20px 20px 20px;
}
</style>
