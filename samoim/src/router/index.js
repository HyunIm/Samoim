import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from '../views/Main.vue';
import Mypage from '../views/mypage/CalendarList.vue';
import Profile from '../views/profile/Profile.vue';
import MakeClass from '../views/class/MakeClass.vue';
import Intro from '../views/Intro.vue';
import MyGathering from '../views/MyGathering.vue';

Vue.use(VueRouter);

export default new VueRouter({
	mode:'history', //해쉬값 제거 방식
    routes: [{
        path: '/', 
        redirect: '/main' 
    },
    {
        path: '/main',
        component: Main
    },
    {
      path: '/mypage',
      component: Mypage
    },
    {
      path: '/profile',
      component: Profile
    },
    {
      path: '/make',
      component: MakeClass
    },
    {
      path: '/intro',
      component: Intro
    },
    {
      path: '/myGathering',
      component: MyGathering
    },
  ]
});