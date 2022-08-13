<template>
  <div>
    <h2>&nbsp;프로필</h2>
    <br> <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-badge
          bordered
          bottom
          color="grey"
          icon="mdi-pencil"
          offset-x="35"
          offset-y="35"
        >
          <v-list-item-avatar
            tile
            size="80"
          >
            <img src="../../assets/wyw.png">
          </v-list-item-avatar>
        </v-badge>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            &nbsp;우영우
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
      제 이름은 똑바로 읽어도 거꾸로 읽어도 우영우입니다. <br>
      기러기, 토마토, 스위스, 인도인, 별똥별, 우영우. <br>
      ...역삼역?
    </v-card>

    <br><br>
    <v-img
      src="../../assets/temperature.png">
    </v-img>


    <br><br>
    <v-autocomplete
      v-model="values"
      :items="items"
      outlined
      dense
      chips
      small-chips
      label="관심사"
      multiple
    ></v-autocomplete>
  </div>
</template>

<script>
  export default {
    name: 'Profile',

    data: () => ({
      items: ['운동', '여행', '문화', '음악', '창작', '성장', '봉사', '요리'],
      values: ['운동', '음악'],
      value: null,
    }),
  }
</script>
