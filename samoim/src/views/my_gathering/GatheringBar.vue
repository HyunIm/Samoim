<template>
  <div>
    <v-row>
    <v-tabs
      align-with-title
      color="black">
      <v-col cols="4">
      <v-tab @click="partClick">참여</v-tab>
      </v-col>
      <v-col cols="4">
      <v-tab @click="progClick">진행</v-tab>
      </v-col>
      <v-col cols="4">
      <v-tab @click="wishClick">찜</v-tab>
      </v-col>
    </v-tabs>
    </v-row>
  </div>
</template>

<script>
export default {
  methods: {
    partClick() {
      this.$emit('partClick', 'partClick')
    },
    progClick() {
      this.$emit('progClick', 'progClick')
    },
    wishClick() {
      this.$emit('wishClick', 'wishClick')
    },
  }
}
</script>

<style>

</style>
