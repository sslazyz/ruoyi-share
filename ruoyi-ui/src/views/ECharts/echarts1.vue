<template>
  <div style="width: auto;height: 470px" id="echarts1">
  </div>
</template>

<script>
import echarts from 'echarts'
const colors = ['#5470C6', '#EE6666']
export default {
  name: 'echarts1',
  data () {
    return {
      // option配置
      option: {
        color: colors,
        tooltip: {
          trigger: 'none',
          axisPointer: {
            type: 'cross'
          }
        },
        legend: {},
        grid: {
          top: 70,
          bottom: 50
        },
        xAxis: {
    type: 'category',
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [120, 200, 150, 80, 70, 110, 130],
      type: 'bar',
      showBackground: true,
      backgroundStyle: {
        color: 'rgba(180, 180, 180, 0.2)'
      }
    }
  ]
      }
    }
  },
  mounted () {
    this.echartsInit()
  },
  methods: {
    echartsInit () {
      // 在生命周期中挂载
      echarts.init(document.getElementById('echarts1')).setOption(this.option)
    }
  }
}
</script>

<style scoped>

</style>
