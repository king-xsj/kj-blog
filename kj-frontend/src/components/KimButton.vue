<template>
  <el-button color="#1890ff" style="color: white" class="kim-button">
    <slot>按钮</slot>
  </el-button>
</template>

<script>
export default {
  name: "KimButton",
};
</script>

<style scoped>
.kim-button {
  width: 100%;
  height: 40px;
}
</style>
