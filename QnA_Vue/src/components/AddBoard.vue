<template>
  <div>
    <form action method="POST" name="frmForm" id="_frmForm" @submit.prevent="addBoard">
      <table class="content_table">
        <colgroup>
          <col style="width:15%" />
          <col style="width:85%" />
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="id" id="id" size="20" v-model="bid" />
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <input type="text" name="contents" id="contents" size="30" v-model="bcontents" />
          </td>
        </tr>
        <tr>
          <th>작성날짜</th>
          <td>
            <input type="date" name="date" id="date" size="30" v-model="bdate" />
          </td>
        </tr>
        <tr>
          <td colspan="2" style="height: 50px; text-align: center;">
            <button type="submit" name="button">글쓰기</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</template>

<script>
import http from "../http-common";
export default {
  name: "addboard",
  data() {
    return {
      info: [],
      bid: "",
      bcontents: "",
      bdate: "",
      loading: true,
      errored: false,
    };
  },
  methods: {
    addBoard() {
      if (this.bid == "") {
        alert("아이디를 입력하세요");
        return;
      }
      if (this.bcontents == "") {
        alert("내용을 입력하세요");
        return;
      }
      if (this.bdate == "") {
        alert("작성일을 입력하세요");
        return;
      }
    
      http
        .post("/addBoard", {/////////////////////////////////
          id: this.bid,
          date: this.bdate,
          contents: this.bcontents
        })
        .then(function(response) {
          if (response.data == true) {
            alert("등록되었습니다");
            // location.href = "/boards";
            // window.location.reload();
            // this.$router.push("/boards");
            // this.retrieveBoards();
          } else {
            alert("등록에 실패하였습니다.");
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