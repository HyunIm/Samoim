<template>
  <div>
    <v-row>
      <v-tabs
        align-with-title
        color="black"
      >
        <v-col cols="4">
          <v-tab @click="partClick">신청한 모임</v-tab>
        </v-col>
        <v-col cols="4">
          <v-tab @click="progClick">개설한 모임</v-tab>
        </v-col>
        <v-col cols="4">
          <v-tab @click="wishClick">찜한 모임</v-tab>
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
