<template>
  <div>
  <h1>
    <center>
        관심사가 무엇인가요?
    </center>
  </h1>

    

    <v-list-item
        class="ma-6"
    >
        <v-list-item-avatar
                tile
                size="150"
            >
                <img src="../assets/interest/workout.png" :class="{ choice : isWorkout }" @click="isWorkout = !isWorkout">
        </v-list-item-avatar>

        <v-list-item-avatar
                tile
                size="150"
            >
                <img src="../assets/interest/culture.png" :class="{ choice : isCulture }" @click="isCulture = !isCulture">
        </v-list-item-avatar>
    </v-list-item>

    <v-list-item
        class="ma-6"
    >
        <v-list-item-avatar
                tile
                size="150"
            >
                <img src="../assets/interest/music.png" :class="{ choice : isMusic }" @click="isMusic = !isMusic">
        </v-list-item-avatar>

        <v-list-item-avatar
                tile
                size="150"
            >
                <img src="../assets/interest/camping.png" :class="{ choice : isCamping }" @click="isCamping = !isCamping">
        </v-list-item-avatar>
    </v-list-item>

    <v-list-item
        class="ma-6"
    >
        <v-list-item-avatar
                tile
                size="150"
            >
                <img src="../assets/interest/art.png" :class="{ choice : isArt }" @click="isArt = !isArt">
        </v-list-item-avatar>

        <v-list-item-avatar
                tile
                size="150"
            >
                <img src="../assets/interest/cook.png" :class="{ choice : isCook }" @click="isCook = !isCook">
        </v-list-item-avatar>
        
    </v-list-item>

<v-btn
    block
    dark
    color="#FFBC00"
>
    가입하기
</v-btn>


    
</div>
</template>

<script>
  export default {
    data: () => ({
        isWorkout : false,
        isCulture : false,
        isMusic : false,
        isCamping : false,
        isCook : false,
        isArt : false,
    }),
  }
</script>


<style scoped>
.choice {
    border: 5px solid #FFBC00;
    border-radius: 20px 20px 20px 20px;
}
</style>
