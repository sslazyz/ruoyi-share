<template>
  <div style="width: auto;height: 185px" id="echarts3">
  </div>
</template>

<script>
import echarts from 'echarts'
export default {
  name: 'echarts3',
  data () {
    return {
      // option配置
      option: {
        xAxis: {
    type: 'category',
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']

  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [820, 932, 901, 934, 1290, 1330, 1320],
      type: 'line',
      smooth: true

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
      echarts.init(document.getElementById('echarts3')).setOption(this.option)
    }
  }
}
</script>

<style scoped>

</style>
