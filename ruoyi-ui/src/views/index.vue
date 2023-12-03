<template>
  <div>
    <!--块类统计-->
    <el-row :gutter="20">
      <el-col :span="6">
        <el-card class="box-card">
          <h3>知识分享文章数</h3>
          <div>
            <i class="el-icon-s-shop" style="color: rgb(0, 128, 62)"></i>
            <span>27</span>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="box-card">
          <h3>累计用户数</h3>
          <div>
            <i class="el-icon-user-solid" style="color: rgb(128, 126, 0)"></i>
            <span>6</span>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="box-card">
          <h3>兑换次数</h3>
          <div>
            <i class="el-icon-s-flag" style="color: rgb(0, 64, 255)"></i>
            <span>11</span>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="box-card">
          <h3>入驻作者数</h3>
          <div>
            <i class="el-icon-star-on" style="color: rgb(255, 0, 247)"></i>
            <span>7</span>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <!--acharts统计图-->
    <el-row :gutter="20">
      <el-col :span="16">
        <el-card class="box-card">
          <echarts1 />

        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card class="box-card">
          <echarts2 />

        </el-card>
        <el-card class="box-card">
          <echarts3 />

        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import echarts1 from './ECharts/echarts1'
import echarts2 from './ECharts/echarts2'
import echarts3 from './ECharts/echarts3'

export default {
  name: 'home',
  components: {
    echarts1,
    echarts2,
    echarts3
  }
}
</script>

<style scoped>
.el-card{
  margin-bottom: 20px;
  text-align: center;
}

</style>
