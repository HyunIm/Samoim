<template>
  <v-container >
    <form>
      <v-row>
        <h3 class="ma-3">모임 만들기</h3>
      </v-row>

      <v-row>
        <v-text-field
          v-model="name"
          :error-messages="nameErrors"
          :counter="20"
          label="name"
          required
          class="mx-3"
        ></v-text-field>
      </v-row>

      <v-row>
        <v-select
          v-model="select"
          :items="items"
          :error-messages="selectErrors"
          label="largeCategory"
          required
          @change="$v.select.$touch()"
          @blur="$v.select.$touch()"
          class="ml-3"
        ></v-select>

        <v-select
          v-model="select"
          :items="items"
          :error-messages="selectErrors"
          label="smallCategory"
          required
          @change="$v.select.$touch()"
          @blur="$v.select.$touch()"
          class="mr-3"
        ></v-select>
      </v-row>

      <v-row>
        <v-select
          v-model="select"
          :items="items"
          :error-messages="selectErrors"
          label="city"
          required
          @change="$v.select.$touch()"
          @blur="$v.select.$touch()"
          class="ml-3"
        ></v-select>

        <v-select
          v-model="select"
          :items="items"
          :error-messages="selectErrors"
          label="address"
          required
          @change="$v.select.$touch()"
          @blur="$v.select.$touch()"
          class="mr-3"
        ></v-select>
      </v-row>

      <v-row>
        <v-textarea
          outlined
          name="input-7-4"
          label="detailContents"
          v-model="name"
          class="mx-3"
        ></v-textarea>
      </v-row>

      <v-row>
        <v-file-input
          :rules="rules"
          accept="image/png, image/jpeg, image/bmp"
          placeholder="Pick Image"
          prepend-icon="mdi-camera"
          label="Image"
          class="mx-3"
        ></v-file-input>
      </v-row>

      <v-row class="justify-center">
        <v-btn
          class="mr-4"
          x-large
          color="success"
          dark
          @click="submit"
        >
          create
        </v-btn>
        <v-btn 
          x-large
          color="red"
          dark
          @click="clear"
        >
          clear
        </v-btn>
      </v-row>

    </form>
  </v-container>
</template>

<script>
  export default {
    name: 'MakeClass',

    data: () => ({
      
    }),
  }
</script>
