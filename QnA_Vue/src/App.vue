<!--
아래 화면단을 출력하는 일 외에는 딱히 하는일이 없다.
해당하는 라우터에 맞는 컴포넌트를 찾아서 실행시킴
-->
<template>
<div id="app">
<div class='headtitle'><h2>BOARD LIST</h2></div>
<div class='search_box'>
 <nav>
    <!--  1. 라우터 속성 to에 지정된 경로를 찾음
          2. 사용자가 화면에서 라우터 링크에 대응하는 html링크를 클릭하면
            2-1. router.js로 이동해서 라우터들을 검색함(to="/url" --- path="/")
            2-2. 아래의 속성값에 매핑되는 라우터 경로를 찾아냄.
            path: "/",
            name: "customers",
            alias: "/customer",
            component: CustomersList
            2-3.연결된 컴포넌트를 router-view영역에 실행함.
    -->
        <router-link class="btn btn-primary" to="/boards">리스트 보기</router-link> | 
        <router-link class="btn btn-primary" to="/addboard">QnA 작성</router-link>
 </nav>
</div>
        <!-- <router-view/> -->
        <Frame />
</div>
</template>

<script>
import Frame from "./components/Frame.vue"
export default {
  name: "app",
  components: {
    Frame,
  }
};
</script>

<style>
</style>

