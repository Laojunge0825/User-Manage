import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElemenUI  from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'  // 导入样式


Vue.use(ElemenUI)



import  axios  from 'axios'   // 引入axios
Vue.prototype.axios = axios    //  挂载到原型  全局引用

// import request  from '@/utils/request'
// Vue.prototype.request = request


Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
