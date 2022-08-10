<template>
<div>
  <v-bottom-navigation v-model="value" background-color="#FBC02D">
    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/progressgathering" 
    >
      <v-btn
        color="#FFBC00"
        block>
        진행
      </v-btn>
    </router-link>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/completegathering" 
    >
      <v-btn
        color="#FFBC00"
        block>
        완료
      </v-btn>
    </router-link>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/wishgathering" 
    >
      <v-btn
        color="#FFBC00"
        block>
        찜
      </v-btn>
    </router-link>
  </v-bottom-navigation>


  <v-card
    class="mx-auto ma-5"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <v-list-item-title class="text-h5 mb-1">
          등신: 등반의 신
        </v-list-item-title>
        &nbsp; • 인원: 7명/15명 <br>
        &nbsp; • 스포츠 > 등산 <br>
        &nbsp; • 지역 : 수원(영통구)
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
      >
        <img src="../../assets/mountaineering.jpeg">
      </v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text
      >
        상세 페이지
      </v-btn>
    </v-card-actions>
  </v-card>


  <v-card
    class="mx-auto ma-5"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <v-list-item-title class="text-h5 mb-1">
          테니스의 왕자
        </v-list-item-title>
        &nbsp; • 인원: 5명/10명 <br>
        &nbsp; • 스포츠 > 테니스 <br>
        &nbsp; • 지역 : 서울(강남구)
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
      >
        <img src="../../assets/tennis.png">
      </v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text
      >
        상세 페이지
      </v-btn>
    </v-card-actions>
  </v-card>


  <v-card
    class="mx-auto ma-5"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <v-list-item-title class="text-h5 mb-1">
          와인 럽
        </v-list-item-title>
        &nbsp; • 인원: 4명/6명 <br>
        &nbsp; • 사교 > 와인 <br>
        &nbsp; • 지역 : 일산
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
      >
        <img src="../../assets/wine.jpeg">
      </v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text
      >
        상세 페이지
      </v-btn>
    </v-card-actions>
  </v-card>
</div>
</template>

<script>
  export default {
  }
</script>

<style>

</style>
