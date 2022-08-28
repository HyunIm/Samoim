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

      <v-textarea
        outlined
        label="상세 모임 내용을 입력해 주세요."
        solo
        :counter="80"
        required
        dense
        ref="makeClassForm.detailContents"
        v-model="makeClassForm.detailContents"
        class="mx-3"
      >
      </v-textarea>
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
            v-model="makeClassForm.openDate"
            ref="makeClassForm.openDate"
            label="모임 날짜"
            prepend-icon="mdi-calendar"
            readonly
            v-bind="attrs"
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker
          v-model="makeClassForm.openDate"
          ref="makeClassForm.openDate"
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
        참여 인원 : {{ makeClassForm.maxMember }} 명
      </v-row>
      <v-row class="mt-15"/>

      <v-card>
        <v-card-text>
          <v-slider
            ref="makeClassForm.maxMember"
            v-model="makeClassForm.maxMember"
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

      <v-row class="mt-15 mx-3">
        <h2>리브똑똑 오픈채팅방이 있다면 
          <br/>
          입력해 주세요.</h2>
      </v-row>
      <v-row class="mt-5 mx-3">
        * 향후 리브똑똑 오픈채팅방 자동생성 및 연결 기능 제공
      </v-row>

      <v-row class="mt-15"/>

      <v-row class="mx-3 mt-15">
        <v-text-field 
          outlined
          label="리브똑똑 URL!"
          persistent-hint
          solo
          flat
          dense
          v-model="liivchatInfo.url"
        >
        </v-text-field>
      </v-row>

    </div>


    <div v-if="makeStep === 9">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <center class="mt-15 mx-3">
        <v-img
          max-height="150"
          max-width="150"
          src="../../assets/check.gif"
        >
        </v-img>
      </center>
      <br>

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
      detailContents: "",
      id: 0,
      largeCategory: "",
      maxMember: 3,
      name: "",
      openDate: null,
      ownerId: "",
      photoPath: "",
      smallCategory: "",
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

    liivchatInfo: {
      classId: "",
      url: ""
    }
  }),

  mounted() {
    //this.getLocation();
  },

  watch: {
    menu(val) {
      val && setTimeout(() => (this.activePicker = 'DATE'))
    },

    makeStep: function() {
      if (this.makeStep === 9) {
        this.nextCheck = false
      } else if (this.makeStep === 8) {
        this.nextCheck = false
      }else if (this.makeStep === 7) {
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
          if (this.makeClassForm.detailContents.length >= 1) {
            this.nextCheck = false
          } else {
            this.nextCheck = true
          }
        } else if (this.makeStep === 5) {
          if (this.makeClassForm.openDate.length >= 1) {
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
      if(this.makeStep === 9) {
        this.$router.replace('/main')

        console.log(this.makeClassForm);

      } else if(this.makeStep === 7) {

        this.$axios.post('/api/create/' + this.$store.state.loginUser, this.makeClassForm)
        .then((res) => {
          console.log(res);
          this.makeStep += 1
          this.progress += 100/8

          if(res.data !== 0) {
            this.liivchatInfo.classId = res.data;
          }
        })
        .catch((error) => {
          console.log(error);
        });

      } else if(this.makeStep === 8) {

        if(this.liivchatInfo.url !== "" && this.liivchatInfo.classId !== "") {
          this.$axios.post('/extraservice/liivchat/save', this.liivchatInfo)
          .then(() => {
            this.makeStep += 1
            this.progress += 100/8
          })
          .catch((error) => {
            console.log(error);
          });
        } else {
          this.makeStep += 1
          this.progress += 100/8
        }
      } else {
        this.makeStep += 1
        this.progress += 100/8
      }

      this.nextCheck = true
    },

    save (openDate) {
      this.$refs.menu.save(openDate)
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
        this.makeClassForm.largeCategory = "운동"
      } else if (category === 'isTravel') {
        this.isTravel = true
        this.makeClassForm.largeCategory = "여행"
      } else if (category === 'isCulture') {
        this.isCulture = true
        this.makeClassForm.largeCategory = "문화"
      } else if (category === 'isMusic') {
        this.isMusic = true
        this.makeClassForm.largeCategory = "음악"
      } else if (category === 'isCreate') {
        this.isCreate = true
        this.makeClassForm.largeCategory = "창작"
      } else if (category === 'isGrowth') {
        this.isGrowth = true
        this.makeClassForm.largeCategory = "성장"
      } else if (category === 'isVolunteer') {
        this.isVolunteer = true
        this.makeClassForm.largeCategory = "봉사"
      } else if (category === 'isCook') {
        this.isCook = true
        this.makeClassForm.largeCategory = "요리"
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
        this.makeClassForm.smallCategory = "클라이밍"
        this.makeClassForm.photoPath="climbingImg"
      } else if (category === 'isGolf') {
        this.isGolf = true
        this.makeClassForm.smallCategory = "골프"
        this.makeClassForm.photoPath="golfImg"
      } else if (category === 'isTennis') {
        this.isTennis = true
        this.makeClassForm.smallCategory = "테니스"
        this.makeClassForm.photoPath="tennisImg"
      } else if (category === 'isDrive') {
        this.isDrive = true
        this.makeClassForm.smallCategory = "드라이브"
        this.makeClassForm.photoPath="driveImg"
      } else if (category === 'isCamping') {
        this.isCamping = true
        this.makeClassForm.smallCategory = "캠핑"
        this.makeClassForm.photoPath="campingImg"
      } else if (category === 'isConcert') {
        this.isConcert = true
        this.makeClassForm.smallCategory = "콘서트"
        this.makeClassForm.photoPath="concertImg"
      } else if (category === 'isMusical') {
        this.isMusical = true
        this.makeClassForm.smallCategory = "뮤지컬"
        this.makeClassForm.photoPath="musicalImg"
      } else if (category === 'isExhibition') {
        this.isExhibition = true
        this.makeClassForm.smallCategory = "전시"
        this.makeClassForm.photoPath="exhibitionImg"
      } else if (category === 'isBand') {
        this.isBand = true
        this.makeClassForm.smallCategory = "밴드"
        this.makeClassForm.photoPath="bandImg"
      } else if (category === 'isComposition') {
        this.isComposition = true
        this.makeClassForm.smallCategory = "작곡"
        this.makeClassForm.photoPath="compositionImg"
      } else if (category === 'isDrawing') {
        this.isDrawing = true
        this.makeClassForm.smallCategory = "드로잉"
        this.makeClassForm.photoPath="drawingImg"
      } else if (category === 'isWriting') {
        this.isWriting = true
        this.makeClassForm.smallCategory = "글쓰기"
        this.makeClassForm.photoPath="writingImg"
      } else if (category === 'isReading') {
        this.isReading = true
        this.makeClassForm.smallCategory = "독서"
        this.makeClassForm.photoPath="readingImg"
      } else if (category === 'isStudy') {
        this.isStudy = true
        this.makeClassForm.smallCategory = "스터디"
        this.makeClassForm.photoPath="studyImg"
      } else if (category === 'isForeign') {
        this.isForeign = true
        this.makeClassForm.smallCategory = "외국어"
        this.makeClassForm.photoPath="foreignImg"
      } else if (category === 'isDog') {
        this.isDog = true
        this.makeClassForm.smallCategory = "유기견봉사"
        this.makeClassForm.photoPath="dogImg"
      } else if (category === 'isDonation') {
        this.isDonation = true
        this.makeClassForm.smallCategory = "재능기부"
        this.makeClassForm.photoPath="donationImg"
      } else if (category === 'isCooking') {
        this.isCooking = true
        this.makeClassForm.smallCategory = "요리"
        this.makeClassForm.photoPath="cookingImg"
      } else if (category === 'isDessert') {
        this.isDessert = true
        this.makeClassForm.smallCategory = "디저트"
        this.makeClassForm.photoPath="dessertImg"
      } else if (category === 'isSoju') {
        this.isSoju = true
        this.makeClassForm.smallCategory = "전통주"
        this.makeClassForm.photoPath="sojuImg"
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
