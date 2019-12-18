import Vue from "vue";//<script src="Vue.js">뷰라이브러리 임포트
import App from "./App.vue";
import router from './router'//<script src="router.js">라우터라이브러리 임포트

Vue.config.productionTip = false;

/*
시작파일이다.
1. Vue객체 생성
2. render에서 h함수로 App.vue를 지정한다.(호출한다.)
3. index.html 에서 app영역을 찾아서 그 부분에 vue템플릿을 마운트한다.
*/
new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
