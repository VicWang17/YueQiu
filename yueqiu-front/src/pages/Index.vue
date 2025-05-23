<template>
  <van-search
      placeholder="请输入要搜索的标签"
      @click-input="onClick"
  />
  <van-cell is-link to="/user/login" />

</template>

<script setup>

import {useRouter} from "vue-router";

const router = useRouter();
const onClick = () => {
  router.push('/search');
}

</script>

<style scoped>

</style>