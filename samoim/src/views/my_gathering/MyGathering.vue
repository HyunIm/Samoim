<template>
  <div>
    <h2>&nbsp;내 활동</h2>
    <GatheringBar/>
    <ProgressGathering/>
    <ProgressGathering/>
    <ProgressGathering/>
    <BottomBar/>
  </div>
</template>

<script>
import GatheringBar from './GatheringBar.vue'
import BottomBar from '../../components/common/BottomBar.vue'
import ProgressGathering from './ProgressGathering.vue'
export default {
  components: {
    GatheringBar,
    ProgressGathering,
    BottomBar,
  }
}
</script>

<style>

</style>
