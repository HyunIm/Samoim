<template>
  <v-btn
    icon x-large
    @click="goBack()"
  >
    <v-icon>
      mdi-chevron-left
    </v-icon>
  </v-btn>
</template>

<script>
  export default {
    name: 'BackButton',

    data: () => ({
      
    }),

    methods: {
      goBack() {
        this.$router.go(-1);
      }
    },
  }
</script>
