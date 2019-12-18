<template>
  <div>
    <table class="list_table">
      <col width="5%" />
      <col width="10%" />
      <col width="75%" />
      <col width="10%" />
      <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>내용</th>
        <th>작성날짜</th>
      </tr>
      <tr class="nicecolor" :key="board.id">
        <td v-html="board.no"></td>
        <td v-html="board.id"></td>
        <td v-html="board.contents"></td>
        <td v-html="board.date"></td>
      </tr>
    </table>

    <div class="search_box">
      <h3>
        <span style="color:blue;" v-html="board.no"></span>번 글의 댓글 리스트
      </h3>
    </div>
    <hr />
    <div v-for="(comment, index) in comments" :key="index">
      <p>
        <b>{{index+1}} ::</b>
        {{comment.content}}
      </p>
      <hr />
    </div>
    <form action method="POST" name="frmForm" id="_frmForm" @submit.prevent="addComment">
      <input type="text" v-model="content" />
      <input type="submit" class="blue" value="댓글달기" />
    </form>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "detailcustomer",
  props: ["no"],
  data() {
    return {
      comments: [],
      loading: true,
      errored: false,
      cid: "",
      board: {},
      content: ""
    };
  },
  methods: {
    addComment() {
      http
        .post("/addComment", {
          no: "",
          content: this.content,
          boardNo: this.no
        })
        .then(response => {
          if (response.data == true) {
            // alert("등록되었습니다");
            http
              .get("/findByNo/" + this.no)
              .then(response => (this.comments = response.data))
              .catch(() => {
                this.errored = true;
              })
              .finally(() => (this.loading = false));
              this.content = ""
          } else {
            alert("등록에 실패하였습니다.");
            this.content = ""
          }
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    }
  },
  mounted() {
    http
      .get("/findBoardByNo/" + this.no)
      .then(response => (this.board = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
    http
      .get("/findByNo/" + this.no)
      .then(response => (this.comments = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  }
};
</script>

<style>
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>