<template>
  <div>
    <v-tabs
      align-with-title
      color="black">
      <v-tab @click="waitClick">대기</v-tab>
      <v-tab @click="partClick">참여</v-tab>
      <v-tab @click="progClick">진행</v-tab>
      <v-tab @click="wishClick">찜</v-tab>
    </v-tabs>
  </div>
</template>

<script>
export default {
  methods: {
    waitClick() {
      this.$emit('waitClick', 'waitClick')
    },
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
