<template>
  <div style="width: auto;height: 225px" id="echarts2">
  </div>
</template>

<script>
import echarts from 'echarts'
export default {
  name: 'echarts2',
  data () {
    return {
      // option配置
      option: {
        tooltip: {
    trigger: 'item'
  },
  legend: {
    top: '5%',
    left: 'center'
  },
  series: [
    {
      name: 'Access From',
      type: 'pie',
      radius: ['40%', '70%'],
      avoidLabelOverlap: false,
      itemStyle: {
        borderRadius: 10,
        borderColor: '#fff',
        borderWidth: 2

      },
      label: {
        show: false,
        position: 'center'
      },
      emphasis: {
        label: {
          show: true,
          fontSize: 40,
          fontWeight: 'bold'
        }
      },
      labelLine: {
        show: false
      },
      data: [
        { value: 1048, name: 'Search Engine' },
        { value: 735, name: 'Direct' },
        { value: 580, name: 'Email' },
        { value: 484, name: 'Union Ads' },
        { value: 300, name: 'Video Ads' }
      ]
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
      echarts.init(document.getElementById('echarts2')).setOption(this.option)
    }
  }
}
</script>

<style scoped>

</style>
