import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from '../views/Main.vue';
import Profile from '../views/profile/Profile.vue';
import MakeClass from '../views/class/MakeClass.vue';
import Intro from '../views/Intro.vue';
import SignUp from '../views/SignUp.vue';
import ReviewWrite from '../views/my_gathering/ReviewWrite.vue';
import TermsAccept from '../views/TermsAccept.vue';
import Payment from '../views/Payment.vue';
import ApplyComplete from '../views/ApplyComplete.vue';
import GatheringInformation from '../views/GatheringInformation.vue';
import InterestPick from '../views/InterestPick.vue';
import Login from '../views/Login.vue';
import MyGathering from '../views/my_gathering/MyGathering.vue';

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
      path: '/termsaccept',
      component: TermsAccept
    },
    {
      path: '/payment',
      component: Payment
    },
    {
      path: '/applycomplete',
      component: ApplyComplete
    },
    {
      path: '/gatheringinformation',
      component: GatheringInformation
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/mygathering',
      component: MyGathering
    },
  ]
});