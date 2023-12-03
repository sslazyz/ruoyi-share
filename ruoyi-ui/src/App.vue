<template>
  <div id="app">
    <router-view />
    <theme-picker />
  </div>
</template>

<script>
import ThemePicker from "@/components/ThemePicker";
import watermark from "watermark-dom"

export default {
  name: "App",
  mounted(){
    //加载水印
    const username = this.$store.state.user.name;
    // watermark.load({ watermark_txt: username + "知识分享管理系统" });

    watermark.load({ watermark_txt:   "知识分享管理系统" });
  },
  components: { ThemePicker },
    metaInfo() {
        return {
            title: this.$store.state.settings.dynamicTitle && this.$store.state.settings.title,
            titleTemplate: title => {
                return title ? `${title} - ${process.env.VUE_APP_TITLE}` : process.env.VUE_APP_TITLE
            }
        }
    }
};
</script>
<style scoped>
#app .theme-picker {
  display: none;
}
</style>
