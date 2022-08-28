import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from './router/index.js'
import axios from 'axios';
import store from './store'
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

Vue.config.productionTip = false;
Vue.prototype.$axios = axios;

new Vue({
  vuetify,
  router,
  store,
  render: h => h(App)
}).$mount('#app')
