import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from '../views/Main.vue';
import Profile from '../views/profile/Profile.vue';
import MakeClass from '../views/class/MakeClass.vue';
import Intro from '../views/Intro.vue';
import SignUp from '../views/SignUp.vue';
import CompleteGathering from '../views/my_gathering/CompleteGathering.vue';
import ProgressGathering from '../views/my_gathering/ProgressGathering.vue';
import WishGathering from '../views/my_gathering/WishGathering.vue';
import InterestPick from '../views/InterestPick.vue';

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
      path: '/signup',
      component: SignUp
    },
    {
      path: '/interest',
      component: InterestPick
    },
    {
      path: '/completegathering',
      component: CompleteGathering
    },
    {
      path: '/progressgathering',
      component: ProgressGathering
    },
    {
      path: '/wishgathering',
      component: WishGathering
    },
  ]
});