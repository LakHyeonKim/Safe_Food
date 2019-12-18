<template>
  <div>
    <div>
      <table class="list_table">
        <col width="5%" />
        <col width="10%" />
        <col width="60%" />
        <col width="10%" />
        <col width="5%" />
        <col width="5%" />
        <col width="5%" />
        <tr>
          <th>번호</th>
          <th>작성자</th>
          <th>내용</th>
          <th>작성날짜</th>
          <th>수정</th>
          <th>삭제</th>
          <th>댓글보기</th>
        </tr>
        <tr v-for="board in info" class="nicecolor" :key="board.id">
          
          <td v-html="board.no"></td>
          <td v-html="board.id"></td>
          <td v-html="board.contents" ></td>
          <td v-html="board.date"></td>
          <td class="button" @click="update_board(board.no)">
            <input type="button" class="blue" value="수정" />
          </td>
          <td class="button" @click="delete_board(board.no)">
            <input type="button" class="blue" value="삭제" />
          </td>
          <td class="button" @click="show_detail(board.no)">
            <input type="button" class="blue" value="댓글보기" />
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import http from "../http-common";
export default {
  name: "customers-list",
  data() {
    return {
      info: [],
      loading: true,
      errored: false
    };
  },
  methods: {
    retrieveBoards() {
      http
        .get("/findAllBoard")//////////////////
        .then(response => (this.info = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    refreshList() {
      this.retrieveBoards();
    },
    show_detail: function(boardno) {
      this.$router.push("/detailboard/" + boardno);
    },
    delete_board(boardno) {
      alert(boardno + "번 게시글이 삭제 됩니다.");
      http
        .delete("/deleteBoard/" + boardno)///////////////////////////
        .then(response => {
          if (response.data == true) {
            alert("삭제 하였습니다.");
            this.retrieveBoards();
          } else {
            alert("삭제 하지 못했습니다.");
          }
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    update_board: function(boardno) {
      alert(boardno + "번 게시글을 수정합니다.");
      this.$router.push("/updateboard/" + boardno);//////////////////////////////////////
    }
  },
  mounted() {
    this.retrieveBoards();
  }
};
</script>

<style>
td {
  text-align: center;
}
</style>
