<template>
  <div>
    <br>
    <v-img
      src="../assets/climbing_2.png"
    ></v-img>

    <br>
    <center>
      <h2>{{ classInfoData.name }}</h2>
      <h2># {{ classInfoData.smallCategory }}</h2>
    </center>

    <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            상세 소개
          </v-list-item-title>
          {{ classInfoData.detailContents }}
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            모임 일정
          </v-list-item-title>
          일정 : {{ classInfoData.openDate }} <br>
          장소 : {{ classInfoData.city }} {{ classInfoData.address }} <br>
          금액 : ₩ { 금액 }
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            모임 리뷰
          </v-list-item-title>
          <v-list-item
            v-for="(item, index) in reviewData"
            :key="index"
          >
            &nbsp; ∙ {{ item.contents }}
          </v-list-item>
        </v-list-item-content>
      </v-list-item>
    </v-card>

    <br>
    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/termsaccept" 
    >
      <v-btn
        align="end"
        class="mr-4"
        x-large
        color="primary"
        dark
        @click="submit"
        block
        rounded
      >
        <h3>가입하기</h3>
      </v-btn>
    </router-link>

    <br><br><br>
  </div>
</template>

<script>
export default {
  mounted() {
    this.getClassInfo();
  },

  data: () => ({
    classInfoData:
      {
        id: 16,
        name: "클라클라 클라이밍",
        largeCategory: "운동·액티비티",
        smallCategory: "클라이밍",
        city: "서울",
        address: "서초구",
        maxMember: 8,
        ownerId: "admin@kb.com",
        openDate: "2022-08-09T00:00:00.000+00:00",
        detailContents: "클라이밍에 처음이신 분들 추천합니다!",
        photoPath: "/photo/path"
      },
    reviewData: [
      {
        class_id: 0,
        user_id: null,
        score: 5,
        contents: "좋아요~",
        photo_path: null,
        create_date: null
      },
    ]
  }),

  methods: {
    getClassInfo() {
      this.$axios.get('/api/classes/1')
      .then((res) => {
        this.classInfoData = res.data;
        console.log(this.classInfoData);
      })
      .catch((error) => {
        console.log(error);
      });

      this.$axios.get('/api/review/1')
      .then((res) => {
        this.reviewData = res.data;
        console.log(this.reviewData);
      })
      .catch((error) => {
        console.log(error);
      });
    },
  }
}
</script>

<style>

</style>