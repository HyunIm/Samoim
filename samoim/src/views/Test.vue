<template>
  <div>
    <div class="mb-6">Active picker: <code>{{ activePicker || 'null' }}</code></div>
    <v-date-picker
        v-model="date"
        :active-picker.sync='YEAR'
        :max="(new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)"
        min="1950-01-01"
        @change="save"
      ></v-date-picker>
  </div>
</template>

<script>
  export default {
    data: () => ({
      activePicker: 'YEAR',
      date: null,
      menu: false,
    }),
    mounted: {
        activePicker: 'YEAR',
    },
    watch: {
      menu (val) {
        val && setTimeout(() => (this.activePicker = 'YEAR'))
      },
    },
    methods: {
      save (date) {
        this.$refs.menu.save(date)
      },
    },
  }
</script>

<style>

</style>