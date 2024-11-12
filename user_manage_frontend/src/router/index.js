import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '../components/HelloWorld';


Vue.use(Router)


export default new Router({
    routes : [
        {
            path:'/',
            component:()=> import('@/components/HelloWorld')  //路由懒加载
        },

    ],
    mode:'history'   //在未设置mode:“history”,vue的路由默认是hash模式，地址栏中显示为  Localhost:8090/#/
})