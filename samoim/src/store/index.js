import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    signupPage: 1,
    loginUser: null,
    userList: ["FromUserTM001", "ToUserTM001", "DelUserTM001"],
    pointList: ["refundable-point-tm", "non-refundable-point-tm"],
    nftAlias: "deploy-test-nft-tm",
  },
  getters: {
    getUser: function(state) {
      return state.loginUser
    },
    getSignUpPage: (state) => {
      return state.signupPage
    }
  },
  mutations: {
    changePage: (state) => {
      state.signupPage = state.signupPage + 1
    },
    changeUser: function(state, user) {
      state.loginUser = user
    }
  },
  actions: {},
  modules: {}
});
