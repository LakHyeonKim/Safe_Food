<template>
  <transition-group name="list" tag="p">
    <div v-for="(item,index) in tableData" :key="index">
      <v-card class="mx-auto my-10" max-width="400">
        <v-img class="white--text align-end" height="200px" :src="item.img"></v-img>
        <v-card-title>{{item.name}}</v-card-title>
        <v-divider class="mx-4 my-1"></v-divider>
        <v-card-text class="pb-2">* 재료</v-card-text>

        <v-card-text class="text--primary">
          <div>
            <p>{{item.foodMaterial}}</p>
          </div>
        </v-card-text>
        <v-divider class="mx-4 my-1"></v-divider>
        <v-card-text class="pb-6">* 만드는 법</v-card-text>
        <div>
          <v-simple-table>
            <template v-slot:default>
              <tr>
              </tr>
              <tbody>
                <tr v-for="(item,index) in item.recipe" :key="index">
                  <td class="pb-2">{{ item }}</td>
                </tr>
              </tbody>
            </template>
          </v-simple-table>
        </div>
      </v-card>
    </div>
  </transition-group>
</template>

<script>
export default {
  name: "recipe",
  props: ["text"],

  data() {
    return {
      tableData: []
    };
  },
  mounted() {
    window.console.log(this.text);
    for (let i in this.text) {
      let ob = new Object();

      ob.foodMaterial = this.text[i].foodMaterial;
      ob.img = this.text[i].img;
      ob.name = this.text[i].name;
      ob.no = this.text[i].no;
      ob.recipe = new Array();
      let recipeLong = this.text[i].recipe;
      let splited = recipeLong.split("Z");
      for (let i in splited) {
        if (splited[i] == "") break;
        ob.recipe.push(splited[i]);
      }
      this.tableData.push(ob);
    }
    window.console.log(this.tableData);
  }
};
</script>

<style>
</style>