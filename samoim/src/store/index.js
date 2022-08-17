import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    signupPage: 1,
    loginUser: null,
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
  modules: {},

  plugins: [createPersistedState({})],
});
