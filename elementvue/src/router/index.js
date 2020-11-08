import Vue from 'vue'
import Router from 'vue-router'
import UserList from "../components/user/UserList";
import App from "../App";
import HomePage from "../components/HomePage";

Vue.use(Router)

export default new Router({
  routes: [
    {path:'/',redirect:'/index'},
    {path:'/index',component:HomePage},
    {path:'/user',component:UserList}
  ]

})
