<template>
  <div>
    <h2>&nbsp;내 모임</h2>
    <br>
    <GatheringBar
      @waitClick="waitClick"
      @partClick="partClick"
      @progClick="progClick"
      @wishClick="wishClick"
      />
    <WaitGathering v-if="waitTab"/>
    <WaitGathering v-if="waitTab"/>
    <WaitGathering v-if="waitTab"/>
    <ParticipateGathering v-if="paricipateTab"/>
    <ProgressGathering v-if="progressTab"/>
    <ProgressGathering v-if="progressTab"/>
    <WishGathering v-if="wishTab"/>
    <BottomBar/>
  </div>
</template>

<script>
import GatheringBar from './GatheringBar.vue'
import BottomBar from '../../components/common/BottomBar.vue'
import WaitGathering from './WaitGathering.vue'
import ParticipateGathering from './ParticipateGathering.vue'
import ProgressGathering from './ProgressGathering.vue'
import WishGathering from './WishGathering.vue'
export default {
  data: () => ({
    waitTab: true,
    paricipateTab: false,
    progressTab: false,
    wishTab: false,
  }),
  components: {
    GatheringBar,
    BottomBar,
    WaitGathering,
    ParticipateGathering,
    ProgressGathering,
    WishGathering,
  },
  methods: {
    waitClick() {
      this.waitTab = true
      this.paricipateTab = false
      this.progressTab = false
      this.wishTab = false
    },
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
