<template>
  <van-nav-bar
      title="个人信息"
      left-arrow
      @click-left="onClickLeft"
  >

  </van-nav-bar>
  <van-config-provider :theme="themeStatus">
    <template v-if="user">
      <van-cell title="用户名" is-link  :value="user.username" @click="toEdit('username','用户名',user.username)"/>
      <van-cell title="账号" is-link to="/user/edit" :value="user.userAccount "  @click="toEdit('userAccount','账号',user.userAccount)"/>
      <van-cell title="头像" is-link to="/user/edit" :value="user.id"  @click="toEdit('avatarUrl','头像',user.avatarUrl)">
        <img style="height: 48px" :src="user.avatarUrl"/>
      </van-cell>
      <van-cell title="性别" is-link to="/user/edit" :value="user.gender" @click="toEdit('gender','性别',user.gender)"/>
      <van-cell title="手机号" is-link to="/user/edit" :value="user.phone" @click="toEdit('phone','手机号',user.phone)"/>
      <van-cell title="邮箱" is-link to="/user/edit" :value="user.email" @click="toEdit('email','邮箱',user.email)"/>
      <van-cell title="注册时间"  :value="user.createTime" />
      <van-cell title="暗色模式">
        <template #right-icon>
          <van-switch v-model="checked" @change="switchChange()"/>
        </template>
      </van-cell>
    </template>

  </van-config-provider>
</template>

<script setup >
  import {onMounted,ref} from 'vue';
  import {useRouter} from "vue-router";
  import myAxios from "../plugins/myAxios";
  import qs from "qs";
  import {getCurrentUser} from "../services/user";
  const checked = ref(false);

  const user = ref();

  onMounted(async () => {
    user.value = await getCurrentUser();
  })


  /**
   *
   * 实现暗色模式
   */
  const themeStatus = ref('light');

  const switchChange = () => {
    if (themeStatus.value === 'dark'){
      themeStatus.value = 'light';
    }
    else{
      themeStatus.value = 'dark';
    }
  }

  /**
   *
   * 导航栏基础功能
   */
  const router = useRouter();
  const onClickLeft = () => {
    router.back()
  }


  const toEdit = (editKey, editName, currentValue) => {
    console.log(editKey);
    router.push({
          path: '/user/edit',
          query: {
            editKey,
            editName,
            currentValue,
          }
    }



    )

  }


</script>

<style scoped>

</style>