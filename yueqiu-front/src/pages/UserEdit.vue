<template>
  <van-nav-bar
      title="资料编辑"
      left-arrow
      @click-left="onClickLeft"
  >
  </van-nav-bar>
  <van-form @submit="onSubmit">
      <van-field
          v-model="editUser.currentValue"
          :name="editUser.editKey"
          :label="editUser.editName"
          :placeholder="`请输入${editUser.editName}`"
          :rules="[{ required: true, message: `请填写${editUser.editName}!` }]"
      />
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>

</template>

<script setup lang="ts">
import {useRouter,useRoute} from "vue-router";
import {ref} from 'vue';
import myAxios from "../plugins/myAxios";
import {showFailToast, showSuccessToast, showToast} from "vant";
import {getCurrentUser} from "../services/user";

/**
 *
 * 导航栏基础功能
 */
const router = useRouter();
const onClickLeft = () => {
  router.back()
}

/**
 *
 * 读取参数
 */
const route =useRoute()
const editUser = ref({
  editKey:route.query.editKey,
  currentValue: route.query.currentValue,
  editName: route.query.editName,
})


const onSubmit = async () => {
  const currentUser = await getCurrentUser();

  if (!currentUser) {
    Toast.fail('用户未登录');
    return;
  }

  console.log(editUser.value.editKey, '当前用户');

  const res = await myAxios.post('/user/update', {
    'id': currentUser.id,
    [editUser.value.editKey as string]: editUser.value.currentValue,
})

  console.log(res, '更新请求');
  if (res.code === 0 && res.data > 0) {
    showSuccessToast('修改成功')
    router.back();
  } else {
    showFailToast('修改失败')
  }
};

</script>

<style scoped>

</style>