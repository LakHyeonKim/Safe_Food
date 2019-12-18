<script>
//Importing Line class from the vue-chartjs wrapper
import { Line } from "vue-chartjs";
//Exporting this so it can be used in other components
export default {
  extends: Line,
  props: ["foodNutrient"],
  data() {
    return {
      datacollection: {
        //Data to be represented on x-axis
        labels: [
          "carbo",
          "chole",
          "fat",
          "fattyacid",
          "natrium",
          "protein",
          "sugar",
          "transfat"
        ],
        datasets: [
          {
            label: "Nutrient Data Graph -  Line Chart",
            backgroundColor: "#249EBF",
            pointBackgroundColor: "white",
            borderWidth: 1,
            pointBorderColor: "#f87979",
            //Data to be represented on y-axis
            data: [
              Number(this.foodNutrient.cookedFood.carbo),
              Number(this.foodNutrient.cookedFood.chole),
              Number(this.foodNutrient.cookedFood.fat),
              Number(this.foodNutrient.cookedFood.fattyacid),
              Number(this.foodNutrient.cookedFood.natrium),
              Number(this.foodNutrient.cookedFood.protein),
              Number(this.foodNutrient.cookedFood.sugar),
              Number(this.foodNutrient.cookedFood.transfat)
            ]
          }
        ]
      },
      //Chart.js options that controls the appearance of the chart
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true
              },
              gridLines: {
                display: true
              }
            }
          ],
          xAxes: [
            {
              gridLines: {
                display: true
              }
            }
          ]
        },
        legend: {
          display: true
        },
        responsive: true,
        maintainAspectRatio: false
      }
    };
  },
  mounted() {
    //renderChart function renders the chart with the datacollection and options object.
    this.renderChart(this.datacollection, this.options);
  }
};
</script>