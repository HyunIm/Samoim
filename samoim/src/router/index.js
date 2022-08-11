import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from '../views/Main.vue';
import Profile from '../views/profile/Profile.vue';
import MakeClass from '../views/class/MakeClass.vue';
import Intro from '../views/Intro.vue';
import CompleteGathering from '../views/my_gathering/CompleteGathering.vue';
import ProgressGathering from '../views/my_gathering/ProgressGathering.vue';
import WishGathering from '../views/my_gathering/WishGathering.vue';
import ReviewWrite from '../views/my_gathering/ReviewWrite.vue';
import TermsAccept from '../views/TermsAccept.vue';
import Payment from '../views/Payment.vue';
import ApplyComplete from '../views/ApplyComplete.vue';

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
  ]
});