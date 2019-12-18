import Vue from "vue";
import Router from "vue-router";
import BoardsList from "./components/BoardsList.vue";
import DetailBoard from "./components/DetailBoard.vue";
import AddBoard from "./components/AddBoard.vue";
import UpdateBoard from "./components/UpdateBoard.vue";
Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/boards",
      name: "boards",
      alias: "/boards",
      component: BoardsList
    },
    {
      path: "/detailboard/:no",
      name: "detailboard",
      component: DetailBoard,
      props:true//중요함
    },
    {
      path: "/addboard",
      name: "addboard",
      component: AddBoard
    },
    {
      path: "/updateboard/:no",
      name: "updateboard",
      component: UpdateBoard,
      props:true
    }
  ]
});