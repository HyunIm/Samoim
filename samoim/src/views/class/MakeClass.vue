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
        class="ml-3"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/large_category/0_workout.png" :class="{ choice : isWorkout }" @click="largeCategorySelect('isWorkout')">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/large_category/1_travel.png" :class="{ choice : isTravel }" @click="largeCategorySelect('isTravel')">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ml-3"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/large_category/2_culture.png" :class="{ choice : isCulture }" @click="largeCategorySelect('isCulture')">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/large_category/3_music.png" :class="{ choice : isMusic }" @click="largeCategorySelect('isMusic')">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ml-3"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/large_category/4_create.png" :class="{ choice : isCreate }" @click="largeCategorySelect('isCreate')">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/large_category/5_growth.png" :class="{ choice : isGrowth }" @click="largeCategorySelect('isGrowth')">
        </v-list-item-avatar>
      </v-list-item>

      <v-list-item
        class="ml-3"
      >
        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/large_category/6_volunteer.png" :class="{ choice : isVolunteer }" @click="largeCategorySelect('isVolunteer')">
        </v-list-item-avatar>

        <v-list-item-avatar
          tile
          size="150"
        >
          <img src="../../assets/large_category/7_cook.png" :class="{ choice : isCook }" @click="largeCategorySelect('isCook')">
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
        <h2>어떤 모임을 열어볼까요?</h2>
      </v-row>

      <v-row class="mt-15 mx-3"/>

      <div v-if="isWorkout">
        <center>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/0_climbing.png" 
            :class="{ choice : isClimbing }" 
            @click="smallCategorySelect('isClimbing')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/1_golf.png" 
            :class="{ choice : isGolf }" 
            @click="smallCategorySelect('isGolf')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/2_tennis.png" 
            :class="{ choice : isTennis }" 
            @click="smallCategorySelect('isTennis')"
          >
        </center>
      </div>


      <div v-if="isTravel">
        <center>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/3_drive.png" 
            :class="{ choice : isDrive }" 
            @click="smallCategorySelect('isDrive')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/4_camping.png" 
            :class="{ choice : isCamping }" 
            @click="smallCategorySelect('isCamping')"
          >
        </center>
      </div>


      <div v-if="isCulture">
        <center>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/5_concert.png" 
            :class="{ choice : isConcert }" 
            @click="smallCategorySelect('isConcert')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/6_musical.png" 
            :class="{ choice : isMusical }" 
            @click="smallCategorySelect('isMusical')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/7_exhibition.png" 
            :class="{ choice : isExhibition }" 
            @click="smallCategorySelect('isExhibition')"
          >
        </center>
      </div>


      <div v-if="isMusic">
        <center>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/8_band.png" 
            :class="{ choice : isBand }" 
            @click="smallCategorySelect('isBand')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/9_composition.png" 
            :class="{ choice : isComposition }" 
            @click="smallCategorySelect('isComposition')"
          >
        </center>
      </div>


      <div v-if="isCreate">
        <center>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/10_drawing.png" 
            :class="{ choice : isDrawing }" 
            @click="smallCategorySelect('isDrawing')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/11_writing.png" 
            :class="{ choice : isWriting }" 
            @click="smallCategorySelect('isWriting')"
          >
        </center>
      </div>


      <div v-if="isGrowth">
        <center>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/12_reading.png" 
            :class="{ choice : isReading }" 
            @click="smallCategorySelect('isReading')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/13_study.png" 
            :class="{ choice : isStudy }" 
            @click="smallCategorySelect('isStudy')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/14_foreign.png" 
            :class="{ choice : isForeign }" 
            @click="smallCategorySelect('isForeign')"
          >
        </center>
      </div>


      <div v-if="isVolunteer">
        <center>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/15_dog.png" 
            :class="{ choice : isDog }" 
            @click="smallCategorySelect('isDog')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/16_donation.png" 
            :class="{ choice : isDonation }" 
            @click="smallCategorySelect('isDonation')"
          >
        </center>
      </div>


      <div v-if="isCook">
        <center>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/17_cooking.png" 
            :class="{ choice : isCooking }" 
            @click="smallCategorySelect('isCooking')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/18_dessert.png" 
            :class="{ choice : isDessert }" 
            @click="smallCategorySelect('isDessert')"
          >
          <br>
          <img
            height="180"
            width="338"
            src="../../assets/small_category/19_soju.png" 
            :class="{ choice : isSoju }" 
            @click="smallCategorySelect('isSoju')"
          >
        </center>
      </div>
    </div>


    <div v-if="makeStep === 3">
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


    <div v-if="makeStep === 4">
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


    <div v-if="makeStep === 5">
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


    <div v-if="makeStep === 6">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2>어디서 만날까요?</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        모임 장소를 입력해주세요. (추후 전국구 추가 예정)
      </v-row>

      <v-row class="mt-15"/>

      <v-radio-group 
        class="ml-15"
        v-model="makeClassForm.address"
        ref="makeClassForm.address"
        row>
        <v-radio
          class="ml-5"
          v-for="(item, index) in locationData"
          :key="index"
          :label="item.ADDRESS"
          :value="item.ADDRESS"
        ></v-radio>
      </v-radio-group>
    </div>


    <div v-if="makeStep === 7">
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


    <div v-if="makeStep === 8">
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
      <br><br><br>
    </v-footer>
  </v-container>
</template>

<script>
import BackButton from '../../components/common/BackButton.vue'
export default {
  components: { BackButton },

  data: () => ({
    makeStep: 1,
    progress: 100/8,
    nextCheck: true,

    makeClassForm: {
      address: "",
      city: "서울",
      detail_contents: "",
      id: 0,
      large_category: "",
      max_member: 3,
      name: "",
      open_date: null,
      owner_id: "",
      photo_path: "",
      small_category: "",
    },

    locationData: [
      { CITY: '서울', ADDRESS: '강남구' },
      { CITY: '서울', ADDRESS: '영등포구' },
    ],
    
    isWorkout: false,
    isTravel: false,
    isCulture: false,
    isMusic: false,
    isCreate: false,
    isGrowth: false,
    isVolunteer: false,
    isCook: false,

    isClimbing: false,
    isGolf: false,
    isTennis: false,
    isDrive: false,
    isCamping: false,
    isConcert: false,
    isMusical: false,
    isExhibition: false,
    isBand: false,
    isComposition: false,
    isDrawing: false,
    isWriting: false,
    isReading: false,
    isStudy: false,
    isForeign: false,
    isDog: false,
    isDonation: false,
    isCooking: false,
    isDessert: false,
    isSoju: false,

    activePicker: null,
    menu: false,
  }),

  mounted() {
    //this.getLocation();
  },

  watch: {
    menu(val) {
      val && setTimeout(() => (this.activePicker = 'DATE'))
    },

    makeStep: function() {
      if (this.makeStep === 8) {
        this.nextCheck = false
      } else if (this.makeStep === 7) {
        this.nextCheck = false
      }
    },

    makeClassForm: {
      handler() {
        if (this.makeStep === 3) {
          if (this.makeClassForm.name.length >= 1) {
            this.nextCheck = false
          } else {
            this.nextCheck = true
          }
        } else if (this.makeStep === 4) {
          if (this.makeClassForm.detail_contents.length >= 1) {
            this.nextCheck = false
          } else {
            this.nextCheck = true
          }
        } else if (this.makeStep === 5) {
          if (this.makeClassForm.open_date.length >= 1) {
            this.nextCheck = false
          } else {
            this.nextCheck = true
          }
        } else if (this.makeStep === 6) {
          if (this.makeClassForm.address.length >= 1) {
            this.nextCheck = false
          } else {
            this.nextCheck = true
          }
        } else if (this.makeStep === 7) {
          this.nextCheck = false
        }
      },
      deep: true,
    },
  },

  methods: {
    nextPage() {
      if(this.makeStep === 8) {
        this.$router.replace('/main')
        this.$axios.post('/api/create/' + this.$store.state.loginUser, this.makeClassForm)
        .then(() => {
          //console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
      } else {
        this.makeStep += 1
        this.progress += 100/8
      }

      this.nextCheck = true
    },

    save (open_date) {
      this.$refs.menu.save(open_date)
    },

    getLocation() {
      this.$axios.get('/api/location')
      .then((res) => {
        this.locationData = res.data;
        //console.log(this.locationData);
      })
      .catch((error) => {
        console.log(error);
      });
    },

    largeCategorySelect(category) {
      this.isWorkout =  false
      this.isTravel = false
      this.isCulture = false
      this.isMusic = false
      this.isCreate = false
      this.isGrowth = false
      this.isVolunteer = false
      this.isCook = false

      if (category === 'isWorkout') {
        this.isWorkout = true
        this.makeClassForm.large_category = "운동"
      } else if (category === 'isTravel') {
        this.isTravel = true
        this.makeClassForm.large_category = "여행"
      } else if (category === 'isCulture') {
        this.isCulture = true
        this.makeClassForm.large_category = "문화"
      } else if (category === 'isMusic') {
        this.isMusic = true
        this.makeClassForm.large_category = "음악"
      } else if (category === 'isCreate') {
        this.isCreate = true
        this.makeClassForm.large_category = "창작"
      } else if (category === 'isGrowth') {
        this.isGrowth = true
        this.makeClassForm.large_category = "성장"
      } else if (category === 'isVolunteer') {
        this.isVolunteer = true
        this.makeClassForm.large_category = "봉사"
      } else if (category === 'isCook') {
        this.isCook = true
        this.makeClassForm.large_category = "요리"
      }

      this.nextCheck = false
    },

    smallCategorySelect(category) {
      this.isClimbing = false
      this.isGolf = false
      this.isTennis = false
      this.isDrive = false
      this.isCamping = false
      this.isConcert = false
      this.isMusical = false
      this.isExhibition = false
      this.isBand = false
      this.isComposition = false
      this.isDrawing = false
      this.isWriting = false
      this.isReading = false
      this.isStudy = false
      this.isForeign = false
      this.isDog = false
      this.isDonation = false
      this.isCooking = false
      this.isDessert = false
      this.isSoju = false

      if (category === 'isClimbing') {
        this.isClimbing = true
        this.makeClassForm.small_category = "클라이밍"
        this.makeClassForm.photo_path="../../assets/small_category_img/0_climbing.png"
      } else if (category === 'isGolf') {
        this.isGolf = true
        this.makeClassForm.small_category = "골프"
        this.makeClassForm.photo_path="1_golf.png"
      } else if (category === 'isTennis') {
        this.isTennis = true
        this.makeClassForm.small_category = "테니스"
        this.makeClassForm.photo_path="2_tennis.png"
      } else if (category === 'isDrive') {
        this.isDrive = true
        this.makeClassForm.small_category = "드라이브"
        this.makeClassForm.photo_path="3_drive.png"
      } else if (category === 'isCamping') {
        this.isCamping = true
        this.makeClassForm.small_category = "캠핑"
        this.makeClassForm.photo_path="4_camping.png"
      } else if (category === 'isConcert') {
        this.isConcert = true
        this.makeClassForm.small_category = "콘서트"
        this.makeClassForm.photo_path="5_concert.png"
      } else if (category === 'isMusical') {
        this.isMusical = true
        this.makeClassForm.small_category = "뮤지컬"
        this.makeClassForm.photo_path="6_musical.png"
      } else if (category === 'isExhibition') {
        this.isExhibition = true
        this.makeClassForm.small_category = "전시"
        this.makeClassForm.photo_path="7_exhibition.png"
      } else if (category === 'isBand') {
        this.isBand = true
        this.makeClassForm.small_category = "밴드"
        this.makeClassForm.photo_path="8_band.png"
      } else if (category === 'isComposition') {
        this.isComposition = true
        this.makeClassForm.small_category = "작곡"
        this.makeClassForm.photo_path="9_composition.png"
      } else if (category === 'isDrawing') {
        this.isDrawing = true
        this.makeClassForm.small_category = "드로잉"
        this.makeClassForm.photo_path="10_drawing.png"
      } else if (category === 'isWriting') {
        this.isWriting = true
        this.makeClassForm.small_category = "글쓰기"
        this.makeClassForm.photo_path="11_writing.png"
      } else if (category === 'isReading') {
        this.isReading = true
        this.makeClassForm.small_category = "독서"
        this.makeClassForm.photo_path="12_reading.png"
      } else if (category === 'isStudy') {
        this.isStudy = true
        this.makeClassForm.small_category = "스터디"
        this.makeClassForm.photo_path="13_study.png"
      } else if (category === 'isForeign') {
        this.isForeign = true
        this.makeClassForm.small_category = "외국어"
        this.makeClassForm.photo_path="14_foreign.png"
      } else if (category === 'isDog') {
        this.isDog = true
        this.makeClassForm.small_category = "유기견봉사"
        this.makeClassForm.photo_path="15_dog.png"
      } else if (category === 'isDonation') {
        this.isDonation = true
        this.makeClassForm.small_category = "재능기부"
        this.makeClassForm.photo_path="16_donation.png"
      } else if (category === 'isCooking') {
        this.isCooking = true
        this.makeClassForm.small_category = "요리"
        this.makeClassForm.photo_path="17_cooking.png"
      } else if (category === 'isDessert') {
        this.isDessert = true
        this.makeClassForm.small_category = "디저트"
        this.makeClassForm.photo_path="18_dessert.png"
      } else if (category === 'isSoju') {
        this.isSoju = true
        this.makeClassForm.small_category = "전통주"
        this.makeClassForm.photo_path="19_soju.png"
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
