<template>
  <div>
    <form action method="POST" name="frmForm" id="_frmForm" @submit.prevent="updateBoard">
      <table class="content_table">
        <colgroup>
          <col style="width:15%" />
          <col style="width:85%" />
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="id" id="id" size="20" v-model="board.id" readonly="readonly"/>
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <input type="text" name="contents" id="contents" size="30" v-model="board.contents" />
          </td>
        </tr>
        <tr>
          <th>작성날짜</th>
          <td>
            <input type="date" name="date" id="date" size="30" v-model="board.date" readonly="readonly"/>
          </td>
        </tr>
        <tr>
          <td colspan="2" style="height: 50px; text-align: center;">
            <button type="submit" name="button">수정하기</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "updateboard",
  props: ["no"],
  data() {
    return {
      loading: true,
      errored: false,
      board: {},
    };
  },
  mounted() {
    http
        .get("/findBoardByNo/" + this.no)
        .then(response => (this.board = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    // alert(this.no);
  },
  methods: {
    retrieveBoards() {
      this.$router.push("/boards");
    },


    updateBoard() {
      http
        .put("/updateBoard", this.board)
        .then(function(response) {
          if (response.data == true) {
            alert("수정되었습니다");
            // location.href = "/boards";
            // window.location.reload();
            // this.$router.push("/boards");
            // this.retrieveBoards();
          } else {
            alert("수정에 실패하였습니다.");
            // location.href = "/boards";
            // window.location.reload();
            // this.$router.push("/boards");
          }
        });
    }
  }
};
</script>

<style lang="scss" scoped>
</style>