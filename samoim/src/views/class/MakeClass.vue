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
          <img src="../../assets/interest/workout.png" :class="{ choice : isWorkout }" @click="isWorkout = !isWorkout">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/culture.png" :class="{ choice : isCulture }" @click="isCulture = !isCulture">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ma-6"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/music.png" :class="{ choice : isMusic }" @click="isMusic = !isMusic">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/camping.png" :class="{ choice : isCamping }" @click="isCamping = !isCamping">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ma-6"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/art.png" :class="{ choice : isArt }" @click="isArt = !isArt">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/interest/cook.png" :class="{ choice : isCook }" @click="isCook = !isCook">
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
        label="내용을 입력해 주세요. (선택)"
        persistent-hint
        solo
        :counter="80"
        required
        flat
        dense
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
            v-model="date"
            label="모임 날짜"
            prepend-icon="mdi-calendar"
            readonly
            v-bind="attrs"
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker
          v-model="date"
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
        outlined
        label="서울특별시 영등포구"
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
        참여 인원 : {{people}} 명
      </v-row>
      <v-row class="mt-15"/>

      <v-card>
        <v-card-text>
          <v-slider
            v-model="people"
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
        dark
        @click="nextPage()"
        block
        rounded
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
    name: 'MakeClass',

    data: () => ({
      makeStep: 1,
      progress: 100/7,
      isWorkout: false,
      isCulture: false,
      isMusic: false,
      isCamping: false,
      isCook: false,
      isArt: false,
      activePicker: null,
      date: null,
      menu: false,
      people: 3,
    }),

    watch: {
      menu (val) {
        val && setTimeout(() => (this.activePicker = 'DATE'))
      },
    },

    methods: {
      nextPage() {
        if(this.makeStep === 7) {
          this.$router.replace('/main')
        } else {
          this.makeStep += 1
          this.progress += 100/7
        }
        
      },
      save (date) {
        this.$refs.menu.save(date)
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
