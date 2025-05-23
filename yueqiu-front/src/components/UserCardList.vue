<template>
  <van-card
      v-for="user in userList"
      :tag="user.gender"
      :desc="user.profile"
      :title="user.username"
      :thumb="user.avatarUrl"
  >
    <template #tags>
      <van-space :size="6.18">
        <van-tag plain type="primary" v-for="tag in user.tags" style="margin-top: 8px">
          {{tag}}
        </van-tag>
      </van-space>

    </template>
    <template #footer>
      <van-button  size="mini">联系我</van-button>
    </template>
  </van-card>
</template>

<script setup lang="ts">
  import {UserType} from "../models/user";

  interface UserCardListProps {
    userList: UserType[];
  }

  const props = withDefaults(defineProps<UserCardListProps>(), {
    // @ts-ignore
    userList: [] as UserType[],
  });
</script>elee

<style scoped>

</style>