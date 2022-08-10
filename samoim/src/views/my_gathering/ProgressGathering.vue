<template>
<div>
  <v-bottom-navigation v-model="value" background-color="#FBC02D">
    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/progressgathering" 
    >
      <v-btn
        color="#FFBC00"
        block>
        진행
      </v-btn>
    </router-link>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/completegathering" 
    >
      <v-btn
        color="#FFBC00"
        block>
        완료
      </v-btn>
    </router-link>

    <router-link
      style="text-decoration: none; color: inherit;" 
      to="/wishgathering" 
    >
      <v-btn
        color="#FFBC00"
        block>
        찜
      </v-btn>
    </router-link>
  </v-bottom-navigation>
  <v-sheet height="400">
    <v-calendar
      ref="calendar"
      v-model="value"
      :weekdays="weekday"
      :type="type"
      :events="events"
      :event-overlap-mode="mode"
      :event-overlap-threshold="30"
      :event-color="getEventColor"
      @change="getEvents"
    ></v-calendar>
  </v-sheet>

  <v-card
    class="mx-auto ma-10"
    max-width="370"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">
          모임 일정
        </div>
        <v-list-item-title class="text-h5 mb-1">
          오르락 내리락!
        </v-list-item-title>
        <v-list-item-subtitle>
          일정 : 8월 6일 (토) 14:00 ~ 15:00<br>
          장소 : 볼더프렌즈 클라이밍(홍대입구역)<br>
          금액 : ₩ 50,000
        </v-list-item-subtitle>
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
      >
        <img
          src="../../assets/climbing.jpeg"
        >
      </v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text
      >
        상세 페이지
      </v-btn>
    </v-card-actions>
  </v-card>
</div>
</template>

<script>
export default {

}
</script>

<script>
  export default {
    data: () => ({
      type: 'month',
      types: ['month', 'week', 'day', '4day'],
      mode: 'stack',
      modes: ['stack', 'column'],
      weekday: [0, 1, 2, 3, 4, 5, 6],
      weekdays: [
        { text: 'Sun - Sat', value: [0, 1, 2, 3, 4, 5, 6] },
        { text: 'Mon - Sun', value: [1, 2, 3, 4, 5, 6, 0] },
        { text: 'Mon - Fri', value: [1, 2, 3, 4, 5] },
        { text: 'Mon, Wed, Fri', value: [1, 3, 5] },
      ],
      value: '',
      events: [],
      colors: ['blue', 'indigo', 'deep-purple', 'cyan', 'green', 'orange', 'grey darken-1'],
      names: ['클라이밍', '테니스', '와인'],
    }),
    methods: {
      getEvents ({ start, end }) {
        const events = []

        const min = new Date(`${start.date}T00:00:00`)
        const max = new Date(`${end.date}T23:59:59`)
        const days = (max.getTime() - min.getTime()) / 86400000
        const eventCount = 5

        for (let i = 0; i < eventCount; i++) {
          const allDay = true
          const firstTimestamp = this.rnd(min.getTime(), max.getTime())
          const first = new Date(firstTimestamp - (firstTimestamp % 900000))
          const secondTimestamp = this.rnd(2, allDay ? 288 : 8) * 900000
          const second = new Date(first.getTime() + secondTimestamp)

          events.push({
            name: this.names[this.rnd(0, this.names.length - 1)],
            start: first,
            end: second,
            color: this.colors[this.rnd(0, this.colors.length - 1)],
            timed: !allDay,
          })
        }

        this.events = events
      },
      getEventColor (event) {
        return event.color
      },
      rnd (a, b) {
        return Math.floor((b - a + 1) * Math.random()) + a
      },
    },
  }
</script>

<style>

</style>
