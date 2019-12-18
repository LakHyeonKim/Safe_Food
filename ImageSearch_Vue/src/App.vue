<template>
  <v-app>
    <v-card flat>
      <v-card-text>
        <v-container fluid class="pa-0">
          <v-row justify="center">
            <v-col cols="12" sm="1">
              <v-hover>
                <v-card
                  :elevation="this.degree1"
                  id="drop-zone"
                  width="150%"
                  height="100%"
                  @mouseover="changeDegreeIn1()"
                  @mouseout="changeDegreeOut1()"
                >
                  <v-btn
                    width="150%"
                    height="100%"
                    text
                    icon
                    large
                    color="green"
                    v-on:click="reset();"
                  >
                    <v-icon large>mdi-cached</v-icon>
                  </v-btn>
                </v-card>
              </v-hover>
            </v-col>
            <v-col cols="12" sm="11">
              <v-card
                :elevation="this.degree2"
                id="drop-zone"
                v-bind:class="[isDragging?'drag-over':'']"
                v-on:dragover="isDragging=true"
                v-on:dragenter="isDragging=true"
                v-on:dragleave="isDragging=false"
                @mouseover="changeDegreeIn2()"
                @mouseout="changeDegreeOut2()"
              >
                <div class="text-wrap">
                  <div v-if="this.imageList.length == 0">
                    <div>
                      <img id="icons" src="./assets/file-image-outline.png" />
                    </div>
                  </div>
                  <div v-if="this.imageList.length > 0">
                    <v-progress-circular :width="4" indeterminate color="green" v-if="this.loading"></v-progress-circular>
                    <div v-else>
                      <img id="icons" src="./assets/check-all.png" />
                    </div>
                  </div>
                </div>
                <input id="uploadInput" name="uploadInput" type="file" @change="onChange" multiple />
              </v-card>
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>
      <v-content v-if="this.foodInfo">
        <FoodInfomatin :foodInfo="this.foodInfo" />
      </v-content>
    </v-card>
  </v-app>
</template>

<script>
import FoodInfomatin from "./components/FoodInfomatin";
import axios from "axios";

export default {
  name: "App",
  components: {
    FoodInfomatin
  },
  data: function() {
    return {
      num: -1,
      degree1: 4,
      degree2: 4,
      imageList: [],
      isDragging: false,
      error: false,
      loading: false,
      foodInfo: null
    };
  },
  methods: {
    upload: function(name, files) {
      const formData = new FormData();
      formData.append(name, files[0], files[0].name);
      window.console.log(name);
      window.console.log(files[0]);
      window.console.log(files[0].name);
      const url = "http://localhost:8888/externalApi/upload";
      axios
        .post(url, formData)
        .then(response => {
          this.foodInfo = response.data;
        })
        .catch(() => (this.error = true))
        .finally(() => (this.loading = false));
    },
    onChange: function(e) {
      this.isDragging = false;
      var files = e.target.files || e.dataTransfer.files;

      if (files.length == 0) {
        return;
      }
      this.loading = true;
      this.upload("image", e.target.files);
      this.addImages(files);
      e.target.value = "";
    },
    addImages: function(files) {
      var self = this;
      for (var i = 0; i < files.length; i++) {
        var file = files[i];
        var reader = new FileReader();
        if (file.type.match(/image.*/)) {
          reader.onload = function(e) {
            self.imageList.push(e.target.result);
          };
          reader.readAsDataURL(file);
        }
      }
    },
    changeDegreeIn1: function() {
      this.degree1 = 15;
    },
    changeDegreeOut1: function() {
      this.degree1 = 4;
    },
    changeDegreeIn2: function() {
      this.degree2 = 15;
    },
    changeDegreeOut2: function() {
      this.degree2 = 4;
    },
    reset: function() {
      location.reload();
    }
  }
};
</script>

<style>
.drag-over {
  background-color: #2881dd !important;
  border: 2px dashed #2881dd !important;
  color: white;
}

#drop-zone {
  width: 100%;
  height: 100px;
  background-color: white;
  border-radius: 10px;
  position: relative;
}

#icons {
  width: 100%;
  height: 100%;
}

.text-wrap {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
}

#drop-zone input {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100%;
  height: 100%;
  opacity: 0;
}

img {
  height: 100px;
}

button {
  width: 300px;
  height: 30px;
}

</style>
