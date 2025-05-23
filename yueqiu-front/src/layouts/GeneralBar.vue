<template>
  <van-nav-bar
      title="个人信息"
      left-arrow

      @click-left="onClickLeft"
      @click-right="onClickRight"
  >
    <template #right>
      <van-icon name="search" size="18" />
    </template>

  </van-nav-bar>
</template>

<script>
import {useRouter} from "vue-router";

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