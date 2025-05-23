<template>
  <van-nav-bar
      title="个人信息"
      left-arrow
      @click-left="onClickLeft"
  >

  </van-nav-bar>
  <UserCardList :user-list="userList"></UserCardList>
  <van-empty v-if="!userList || userList.length < 1" description="竟然没有这样的用户！！" />


</template>

<script setup>

import {onMounted, ref} from "vue";
import {useRoute, useRouter} from "vue-router";
import qs from 'qs';
import {Toast} from "vant";
import myAxios from "../plugins/myAxios";
import UserCardList from "../components/UserCardList.vue";

const route = useRoute();

const {tags} = route.query;


const userList = ref([])
onMounted(async () => {
  const userListData = await myAxios.get('/user/search/tags', {
    params: {
      tagNameList: tags
    },
    paramsSerializer: params => {
      return qs.stringify(params, {indices: false})
    }
  })
      .then(function (response) {
        console.log('/user/search/tags succeed', response);
        return response?.data;
      })
      .catch(function (error) {
        console.error('/user/search/tags error', error);
        //Toast.fail('请求失败');
      })
  if (userListData) {
    userListData.forEach(user => {
      if (user.tags) {
        user.tags = JSON.parse(user.tags);
      }
    })
    userList.value = userListData;
  }
})

/**
 *
 * 导航栏基础功能
 */
const router = useRouter();
const onClickLeft = () => {
  router.back()
}



</script>

<style scoped>

</style>