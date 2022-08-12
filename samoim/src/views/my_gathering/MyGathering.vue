<template>
  <div>
    <h2>&nbsp;내 활동</h2>
    <GatheringBar/>
    <ProgressGathering/>
    <ParticipateGathering/>
    <WaitGathering/>
    <WishGathering/>
    <BottomBar/>
  </div>
</template>

<script>
import GatheringBar from './GatheringBar.vue'
import BottomBar from '../../components/common/BottomBar.vue'
import ProgressGathering from './ProgressGathering.vue'
import ParticipateGathering from './ParticipateGathering.vue'
import WaitGathering from './WaitGathering.vue'
import WishGathering from './WishGathering.vue'
export default {
  components: {
    GatheringBar,
    ProgressGathering,
    BottomBar,
    ParticipateGathering,
    WaitGathering,
    WishGathering,
  }
}
</script>

<style>

</style>
