<template>
  <v-container>
    <div id="list-demo">
      <transition-group name="list" tag="p">
        <span v-for="(item,index) in this.foodInfo" v-bind:key="index" class="list-item">
          <v-card :loading="loading" class="mx-5 my-20" max-width="380" :elevation="6">
            <v-img height="250" :src="item.img"></v-img>

            <v-card-title>
              <v-row justify="center">
                <v-col cols="12" sm="4">
                  <div class="ml-1">
                    <b>{{item.cookedFood.name}}</b>
                  </div>
                </v-col>
                <v-col cols="12" sm="6">
                  <div class="ml-1">
                    <b>{{item.cookedFood.calory}} (Kcal)</b>
                  </div>
                </v-col>
              </v-row>
              <v-btn icon @click.native="doc_popup_modal(item.crawlingFoodMaterial)">
                <v-icon>{{ 'mdi-gesture-double-tap' }}</v-icon>
              </v-btn>
            </v-card-title>
            <v-slide-y-transition>
              <!-- <v-card-text v-show="show"></v-card-text> -->
            </v-slide-y-transition>
            <v-divider class="mx-4 my-1"></v-divider>
            <v-card-title class="mx-3">알레르기</v-card-title>
            <v-card-text>
              <v-chip-group
                v-model="selection"
                active-class="deep-purple accent-4 white--text"
                column
              >
                <v-chip>두유</v-chip>
                <v-chip>새우</v-chip>
                <v-chip>견과류</v-chip>
                <v-chip>미역</v-chip>
              </v-chip-group>
            </v-card-text>
            <v-divider class="mx-4 my-1"></v-divider>
            <v-card-text>
              <v-row align="center" class="mx-0">
                <v-col cols="12" sm="4">
                  <div class="grey--text ml-1">Similarity</div>
                </v-col>
                <v-col cols="12" sm="4">
                  <v-rating
                    :value="item.rating"
                    color="amber"
                    dense
                    half-increments
                    readonly
                    size="16"
                  ></v-rating>
                </v-col>
                <v-col cols="12" sm="4">
                  <div class="grey--text ml-4">{{item.rating}} (*1~5)</div>
                </v-col>
              </v-row>
              <v-row align="center" class="mx-0">
                <v-col cols="12" sm="8">
                  <span>Nutrient - Information</span>
                </v-col>
                <v-col cols="12" sm="4">
                  <v-btn icon @click.native="show = !show">
                    <v-icon>{{ show ? 'mdi-arrow-up-bold' : 'mdi-arrow-down-bold' }}</v-icon>
                  </v-btn>
                </v-col>
              </v-row>
              <div class="my-4 subtitle-1 black--text">
                <v-card v-show="show">
                  <v-card-title>
                    <v-chip color="green" text-color="white">{{item.cookedFood.name}}</v-chip>
                    <b class="mx-2">단어가 들어간 영양성분</b>
                  </v-card-title>
                  <v-divider class="mx-4 my-1"></v-divider>
                  <v-list dense>
                    <v-list-item>
                      <v-list-item-content>Supportpareat:</v-list-item-content>
                      <v-list-item-content
                        class="align-end ml-10"
                      >{{ item.cookedFood.supportpareat }} (g)</v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>Carbo:</v-list-item-content>
                      <v-list-item-content class="align-end ml-10">{{ item.cookedFood.carbo }} (g)</v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>Chole:</v-list-item-content>
                      <v-list-item-content class="align-end ml-10">{{ item.cookedFood.chole }} (g)</v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>Fat:</v-list-item-content>
                      <v-list-item-content class="align-end ml-10">{{ item.cookedFood.fat }} (g)</v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>Fattyacid:</v-list-item-content>
                      <v-list-item-content
                        class="align-end ml-10"
                      >{{ item.cookedFood.fattyacid }} (g)</v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>Natrium:</v-list-item-content>
                      <v-list-item-content class="align-end ml-10">{{ item.cookedFood.natrium }} (g)</v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>Protein:</v-list-item-content>
                      <v-list-item-content class="align-end ml-10">{{ item.cookedFood.protein }} (g)</v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>Sugar:</v-list-item-content>
                      <v-list-item-content class="align-end ml-10">{{ item.cookedFood.sugar }} (g)</v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                      <v-list-item-content>Transfat:</v-list-item-content>
                      <v-list-item-content
                        class="align-end ml-10"
                      >{{ item.cookedFood.transfat }} (g)</v-list-item-content>
                    </v-list-item>
                  </v-list>
                  <v-divider class="mx-4"></v-divider>
                </v-card>
                <v-card>
                  <line-chart :foodNutrient="item"></line-chart>
                </v-card>
              </div>
            </v-card-text>
          </v-card>
          <br />
        </span>
      </transition-group>
    </div>
    <div class="row">
      <modals-container />
    </div>
  </v-container>
</template>
<script>
import LineChart from "@/components/LineChart";
import RecipeModal from "./RecipeModal.vue";
export default {
  name: "FoodInfomation",
  props: ["foodInfo"],
  components: {
    LineChart
  },
  data() {
    return {
      loading: false,
      selection: 1,
      show: false
    };
  },
  mounted() {
    window.console.log(this.foodInfo);
  },
  methods: {
    randomIndex: function() {
      return Math.floor(Math.random() * this.items.length);
    },
    reserve() {
      this.loading = true;
      setTimeout(() => (this.loading = false), 2000);
    },
    doc_popup_modal(table) {
      window.console.log(table);
      this.$modal.show(
        RecipeModal,
        {
          text: table,
          modal: this.$modal
        },
        {
          name: "dynamic-modal",
          width: "500px",
          height: "auto",
          draggable: false,
          scrollable: true
        }
      );
    }
  }
};
</script>
  
<style scoped>
.list-item {
  display: inline-block;
  margin-right: 10px;
}
.list-enter-active,
.list-leave-active {
  transition: all 1s;
}
.list-enter, .list-leave-to /* .list-leave-active below version 2.1.8 */ {
  opacity: 0;
  transform: translateY(30px);
}
ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
