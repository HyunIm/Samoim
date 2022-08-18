<template>
  <v-container >
    <v-row>
      <v-col>
        <BackButton/>
      </v-col>
      <v-col class="mt-3">
        <h3>
          <center>
              모임 가입
          </center>
        </h3>
      </v-col>
      <v-col></v-col>
    </v-row>


    <div v-if="joinStep === 1">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <v-row class="mt-15 mx-3">
        <h2><v-icon color="red">mdi-alert-circle</v-icon> 모두가 즐거운 모임이</h2>
        <h2>될 수 있도록 함께 지켜주세요.</h2>
      </v-row>

      <v-row class="mx-3 mt-15">
        <v-stepper
          v-model="e6"
          vertical
        >
          <v-stepper-step
            :complete="e6 > 1"
            step="1"
          >
            모임 약속 지키기
          </v-stepper-step>

          <v-stepper-content step="1">
            <v-card
              class="mb-2"
              height="60"
              outlined
            >
              모임 시작 전 부득이하게 참여가 어려워진 경우,
              반드시 주최자에게 미리 알려주세요.
            </v-card>
            <v-btn
              color="primary"
              @click="e6 = 2"
            >
              계속
            </v-btn>
          </v-stepper-content>

          <v-stepper-step
            :complete="e6 > 2"
            step="2"
          >
            의견 존중하기
          </v-stepper-step>

          <v-stepper-content step="2">
            <v-card
              class="mb-2"
              height="60"
              outlined
            >
              나와 다른 의견에도 귀 기울이며, 함께하는
              멤버들을 존중하는 태도로 지켜주세요.
            </v-card>
            <v-btn
              color="primary"
              @click="e6 = 3"
            >
              계속
            </v-btn>
          </v-stepper-content>

          <v-stepper-step
            :complete="e6 > 3"
            step="3"
          >
            모임 이용 규칙
          </v-stepper-step>

          <v-stepper-content step="3">
            <v-card
              class="mb-2"
              height="90"
              outlined
            >
              무단으로 불참하거나, 함께하는 멤버들을
              존중하지 않고 피해를 주는 경우
              신고 제도를 통해 사모임 이용에 제재를 받게 됩니다.
            </v-card>
            <v-btn
              color="primary"
              @click="promiseComplete()"
            >
              확인
            </v-btn>
          </v-stepper-content>
        </v-stepper>
      </v-row>
      <br>
    </div>


    <div v-if="joinStep === 2">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>
      <v-row class="mt-15 mx-3">
        <h1>결제 금액</h1>
      </v-row>
        <h1 align="right">{{ this.price }} P</h1>
      <v-divider></v-divider>
      <v-row class="mt-15 mx-3">
      <h1>보유 포인트</h1>
      </v-row>
      <h1 align="right">{{ this.userPoint }} P</h1>
      <v-divider></v-divider>
      <br>

      <v-row class="mt-15 mx-3" justify="center">
        <v-dialog
          v-model="dialog"
          persistent
          max-width="290"
        >
          <template v-slot:activator="{ on, attrs }">
              <v-btn
                lass="mr-4"
                x-large
                color="primary"
                dark
                block
                rounded
                v-bind="attrs"
                v-on="on"
                @click="payment()"
              >
                <h3>결제하기</h3>
              </v-btn>
          </template>
          <v-card>
            <v-card-title class="text-h5">
              추천 보험
            </v-card-title>
            <v-img src="../assets/insurance.png"></v-img>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                color="green darken-1"
                text
                @click="nextPage()"
              >
                안 하기
              </v-btn>
              <v-btn
                color="green darken-1"
                text
                @click="insurance()"
              >
                가입하기
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-row>
      <br>
    </div>

    <div v-if="joinStep === 3">
      <v-row class="mt-1">
        <template>
          <v-progress-linear :value="progress"></v-progress-linear>
        </template>
      </v-row>

      <center class="mt-15 mx-3">
        <v-img
          max-height="150"
          max-width="150"
          src="../assets/check.gif"
        >
        </v-img>
      </center>
      <br>

      <h1><center>모임 참석</center></h1>
      <h1><center>신청 완료</center></h1>

      <v-row class="mt-15 mx-3">
        <v-card
          class="mx-auto"
          width="350"
          outlined
        >
          <v-list-item three-line>
            <v-list-item-content>
              <v-list-item-title class="text-h5 mb-1">
                신청 내역
              </v-list-item-title>
              일정 : 날짜 바인딩 필요 <br>
              장소 : 장소 바인딩 필요 <br>
              금액 : {{ this.price }} P<br>
              잔여 포인트 : {{ this.userPoint - this.price }} P
            </v-list-item-content>
          </v-list-item>
        </v-card>
      </v-row>
      <br>
    </div>


    <v-footer class="mb-2" color="white" v-if="joinStep !== 2">
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
import BackButton from '../components/common/BackButton.vue'
export default {
  components: { BackButton },

  data: () => ({
    joinStep: 1,
    progress: 100/3,
    nextCheck: true,
    e6: 1,
    dialog: false,
    userPoint: undefined,
    price: 20000,
    payInfo: undefined,
    joinInfo: undefined,
    classId: undefined
  }),

  mounted() {
    this.getPoint();

    this.classId = this.$route.params.classId;
  },

  methods: {
    nextPage() {
      if(this.joinStep === 3) {
        this.$router.replace('/main')
      } else {
        this.joinStep += 1
        this.progress += 100/3
      }

      this.nextCheck = true
      if (this.joinStep === 3) {
        this.nextCheck = false
      }
    },


    insurance() {
      window.open('https://m.kbinsure.co.kr:8543/MG302030001.ec', '_blank')
      this.nextPage()
    },


    getPoint() {
      this.$axios.get('/api/balance/' + this.$store.state.loginUser)
      .then((res) => {
        //console.log(res);

        this.userPoint = res.data;
      })
      .catch((error) => {
        console.log(error);
      });
    },


    payment() {
      if (this.userPoint < this.price) {
        this.$router.replace('/failjoin')
      }

      this.payInfo = {
        email: this.$store.state.loginUser,
        point: this.price
      };

      this.$axios.put('/api/balance/update', this.payInfo)
      .then(() => {
        //console.log(res);

        //모임 참석 API 호출
        this.joinInfo = {classId : this.classId, userId : this.$store.state.loginUser};

        this.$axios.post('/api/join', this.joinInfo)
        .then(() => {
          //console.log(res);

          // 신청완료 Data 생성
          

        })
        .catch((error) => {
          console.log(error);
        });

      })
      .catch((error) => {
        console.log(error);
      });
    },


    promiseComplete() {
      this.e6 = 4;
      this.nextCheck = false;
    },
  },
}
</script>

<style>

</style>
