<template>
  <div>
    <v-file-input
      class="ma-5"
      label="사진 올리기"
      filled
      prepend-icon="mdi-camera"
    ></v-file-input>

    <v-rating
      color="#FFBC00"
      half-increments
      hover
      length="5"
      size="64"
      value="3"
    ></v-rating>

    <v-container fluid>
      <v-textarea
        autocomplete="어떤 점이 좋았나요?"
        label="어떤 점이 좋았나요?"
      ></v-textarea>
    </v-container>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/completegathering" 
    >
      <v-btn
        align="end"
        block
        dark
        color="#FFBC00"
      >
        작성 완료
      </v-btn>
    </router-link>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>
