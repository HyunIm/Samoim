<template>
  <v-container >
    <form>
      <v-row>
        <h3 class="ma-3">로그인</h3>
      </v-row>

      <v-row>
        <v-text-field
          v-model="name"
          :error-messages="nameErrors"
          :counter="20"
          label="ID"
          required
          class="mx-3"
        ></v-text-field>
      </v-row>
      <v-row>
        <v-text-field
          v-model="name"
          :error-messages="nameErrors"
          :counter="20"
          label="PASSWORD"
          required
          class="mx-3"
        ></v-text-field>
      </v-row>

      <v-row class="justify-center">
        <router-link
          to="/main"
          style="text-decoration: none; color: inherit;"  
        >
          <v-btn
            class="mr-4"
            x-large
            color="success"
            dark
            @click="submit"
          >
            Login
          </v-btn>
        </router-link>
      </v-row>

    </form>
  </v-container>
</template>

<script>
  export default {
    name: 'Login',

    data: () => ({
      
    }),
  }
</script>
