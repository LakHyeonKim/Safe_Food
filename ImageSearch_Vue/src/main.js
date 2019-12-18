import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import '@mdi/font/css/materialdesignicons.css'
import VModal from 'vue-js-modal'

Vue.config.productionTip = false
Vue.use(VModal, { dynamic: true })

new Vue({
  vuetify,
  icons: {
    iconfont: 'mdi' || 'mdiSvg' || 'md' || 'fa' || 'fa4'
  },
  render: h => h(App)
}).$mount('#app')
