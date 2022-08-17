<template>
  <div>
    <v-row>
      <v-col>
        <BackButton/>
      </v-col>
      <v-col class="mt-3">
        <h3>
          <center>
              내 모임
          </center>
        </h3>
      </v-col>
      <v-col></v-col>
    </v-row>
    <br>
    <GatheringBar
      @partClick="partClick"
      @progClick="progClick"
      @wishClick="wishClick"
    />
    <br>
    <!--<WaitGathering v-if="waitTab"/>-->
    <ParticipateGathering v-if="paricipateTab"/>
    <ProgressGathering v-if="progressTab"/>
    <WishGathering v-if="wishTab"/>

    <br><br><br><br>
    <BottomBar/>
  </div>
</template>

<script>
import GatheringBar from './GatheringBar.vue'
import BottomBar from '../../components/common/BottomBar.vue'
//import WaitGathering from './WaitGathering.vue'
import ParticipateGathering from './ParticipateGathering.vue'
import ProgressGathering from './ProgressGathering.vue'
import WishGathering from './WishGathering.vue'
import BackButton from '../../components/common/BackButton.vue'
export default {
  data: () => ({
    //waitTab: true,
    paricipateTab: true,
    progressTab: false,
    wishTab: false,
  }),
  components: {
    GatheringBar,
    BottomBar,
    //WaitGathering,
    ParticipateGathering,
    ProgressGathering,
    WishGathering,
    BackButton,
  },
  methods: {
    /*
    waitClick() {
      this.waitTab = true
      this.paricipateTab = false
      this.progressTab = false
      this.wishTab = false
    },
    */
    partClick() {
      this.waitTab = false
      this.paricipateTab = true
      this.progressTab = false
      this.wishTab = false
    },
    progClick() {
      this.waitTab = false
      this.paricipateTab = false
      this.progressTab = true
      this.wishTab = false
    },
    wishClick() {
      this.waitTab = false
      this.paricipateTab = false
      this.progressTab = false
      this.wishTab = true
    },
  }
}
</script>

<style>

</style>
