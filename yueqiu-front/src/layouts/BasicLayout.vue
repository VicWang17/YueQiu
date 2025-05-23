<script setup>

import {useRouter} from "vue-router";
import {ref} from 'vue';

let theme = ref('light')


const router = useRouter();
const onClickLeft = () => {
  router.back()
}
const onClickRight = () => {
   router.push('/search')
}
const onChange = (index) => showToast(`标签 ${index}`);
</script>

<template>

  <van-config-provider :theme="theme">

    <div id="content">
        <router-view />
    </div>
    <van-tabbar route @change="onChange">
      <van-tabbar-item icon="home-o" name="index" to="/">主页</van-tabbar-item>
      <van-tabbar-item icon="friends-o" name="team" to="/team">队伍</van-tabbar-item>
      <van-tabbar-item icon="contact-o" name="user" to="/user">我</van-tabbar-item>

    </van-tabbar>
  </van-config-provider>



</template>

<style>
  .van-theme-dark body {
    color: #f5f5f5;
    background-color: black;
  }

  #content {
    padding-bottom: 50px;
  }

</style>
