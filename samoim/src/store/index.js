import Vue from "vue";
import Vuex from "vuex";
// import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    loginUser: null,
  },
  getters: {
    getUser: function(state) {
      return state.loginUser
    },
  },
  mutations: {
    changeUser: function(state, user) {
      state.loginUser = user
    }
  },
  actions: {},
  modules: {},

  // plugins: [createPersistedState({})],
});
