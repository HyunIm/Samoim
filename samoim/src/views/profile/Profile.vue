<template>
  <div>
    <br> <br>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-avatar
          tile
          size="80"
        >
          <img src="../../assets/wyw.png">
        </v-list-item-avatar>
        <v-list-item-content>
          <v-list-item-title class="text-h5 mb-1">
            우영우
          </v-list-item-title>
          <v-list-item-subtitle>이상한 변호사</v-list-item-subtitle>
        </v-list-item-content>
        <v-card-actions>
          <v-btn
            outlined
            rounded
            text
          >
            >
          </v-btn>
        </v-card-actions>
      </v-list-item>
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
      items: ['운동', '문화', '음악', '캠핑', '예술', '요리'],
      values: ['운동', '캠핑'],
      value: null,
    }),
  }
</script>
