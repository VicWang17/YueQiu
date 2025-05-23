<template>
  <form action="/">
    <van-search
        v-model="searchText"
        placeholder="请输入要搜索的标签"
        show-action
        @search="onSearch"
        @cancel="onCancel"
        autofocus
    />
  </form>
  <van-divider content-position="left">已选标签</van-divider>

  <div v-if="activeIds.length === 0">
    请选择标签
  </div>
  <van-space wrap style="padding: 16px">
    <van-tag v-for="tag in activeIds"  closeable size="medium" type="primary" @close="doClose(tag)">
      {{ tag }}
    </van-tag>
  </van-space>

  <van-divider content-position="left">选择标签</van-divider>
  <van-tree-select
      v-model:active-id="activeIds"
      v-model:main-active-index="activeIndex"
      :items="tagList"
  />

  <div style="padding: 12px">
    <van-button block type="primary" @click="doSearchResult">搜索</van-button>
  </div>




</template>

<script setup>
import { ref } from 'vue';
import {useRouter} from "vue-router";
const router = useRouter();
const searchText = ref('');
const originTagList = [{
  text: '性别',
  children: [
    {text: '男', id: '男'},
    {text: '女', id: '女'},
  ],
},
  {
    text: '运动',
    children: [
      {text: '足球', id: '足球'},
      {text: '篮球', id: '篮球'},
      {text: '羽毛球', id: '羽毛球'},
    ],
  },
]


let tagList = ref(originTagList);



const onSearch = (val) => {
  tagList.value = originTagList.map(parentTag => {
    const tempChildren = [...parentTag.children];
    const tempParentTag = {...parentTag};
    tempParentTag.children = tempChildren.filter(item => item.text.includes(searchText.value));
    return tempParentTag;
  });

}

const onCancel = () => {
  // searchText.value = '';
  // tagList.value = originTagList;
  // 原功能是清除搜索内容，看了各大app后感觉就是一个返回键
  router.back();
}

const activeIds = ref([]);
const activeIndex = ref(0);


//移除标签
const doClose = (tag) => {
  activeIds.value = activeIds.value.filter(item => {
    return item !== tag;
  })
}

/**
 * 执行搜索
 */
const doSearchResult = () => {
  router.push({
    path: '/user/list',
    query: {
      tags: activeIds.value
    }
  })
}


</script>

<style scoped>

</style>