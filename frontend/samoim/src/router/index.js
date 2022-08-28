import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from '../views/Main.vue';
import Profile from '../views/profile/Profile.vue';
import MakeClass from '../views/class/MakeClass.vue';
import Intro from '../views/Intro.vue';
import SignUp from '../views/SignUp.vue';
import ReviewWrite from '../views/my_gathering/ReviewWrite.vue';
import GatheringInformation from '../views/GatheringInformation.vue';
import InterestPick from '../views/InterestPick.vue';
import Login from '../views/Login.vue';
import MyGathering from '../views/my_gathering/MyGathering.vue';
import Test from '../views/Test.vue';
import GatheringJoin from '../views/GatheringJoin.vue';
import FailJoin from '../views/FailJoin.vue';

Vue.use(VueRouter);

export default new VueRouter({
	mode:'history', //해쉬값 제거 방식
    routes: [{
        path: '/', 
        component: Intro
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
      path: '/reviewwrite',
      component: ReviewWrite
    },
    {
      path: '/gatheringinformation',
      component: GatheringInformation,
      name: 'GatheringInformation',
      props: true
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/mygathering',
      component: MyGathering
    },
    {
      path: '/test',
      component: Test
    },
    {
      path: '/gatheringjoin',
      component: GatheringJoin,
      name: 'GatheringJoin',
      props: true
    },
    {
      path: '/failjoin',
      component: FailJoin
    },
  ]
});