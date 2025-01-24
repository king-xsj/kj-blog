<template>
  <div class="cloud-card">
    <div class="clouds">
      <router-link
        class="cloud-item"
        v-for="cloud in clouds"
        :key="cloud.id"
        :to="`${baseUrl}/${cloud.id}`"
        :style="cloud.style"
        >
        {{ cloud.name }}
        <el-icon v-if="baseUrl ==='/tag'" class="close-btn" @click.prevent="handleDelete(cloud.id)"><CircleClose /></el-icon>
      </router-link>
      
    </div>
    <div class="add-btn" v-if="baseUrl ==='/tag'">
      <el-button type="primary" circle @click="dialogVisible = true">
        <template #icon>
          <Plus />
        </template>
      </el-button>
    </div>
  </div>
  <el-dialog v-model="dialogVisible" title="新增标签" :width="500" draggable>
    <el-input v-model="tagName" style="width: 100%" placeholder="请输入标签" />
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="handleSubmit()"> Confirm </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script>
import { computed, ref } from "vue";
import { randomColorWordCloud } from "../utils/word-cloud";
import { addTag, deleteTag } from "../api/tag";
import { Plus, CircleClose } from "@element-plus/icons-vue";
import store from "../store";
export default {
  name: "KimWordCloudCard",
  emits: ["wordClicked"],
  components: {
    Plus,
    CircleClose
  },
  props: {
    words: {
      type: Array,
      require: true,
    },
    baseUrl: {
      type: String,
      require: true,
    },
  },
  setup(props) {
    const dialogVisible = ref(false);
    const tagName = ref("");
    const handleSubmit = () => {
      addTag({ tagName: tagName.value }).then((res) => {
        dialogVisible.value = false;
        store.dispatch("tagAbout/getTagCounts");
        ElMessage.success("新增成功");
      });
    };
    const handleDelete = (id) => {
        deleteTag({id: id}).then(res => {
            store.dispatch("tagAbout/getTagCounts");
            ElMessage.success("操作成功");
        })
    }
    let clouds = computed(() => randomColorWordCloud(props.words));
    return { clouds, dialogVisible, tagName, handleSubmit, handleDelete };
  },
};
</script>

<style lang="less" scoped>
.cloud-card {
  background: white;
  border-radius: 8px;
  box-shadow: var(--card-box-shadow);
  padding: 20px 24px;
  width: 100%;
  height: 100%;
  box-sizing: border-box;
}

.clouds {
  font-size: 14px;
  box-sizing: border-box;
}

.cloud-item {
  text-decoration: none;
  display: inline-block;
  transition: all 0.4s;
  padding: 0 8px;
  overflow-wrap: break-word;
  line-height: 2;
  .close-btn {
    display: none;
  }
  &:hover {
    color: var(--theme-color) !important;
    transform: scale(1.1);
    .close-btn {
        display: inline-block;
    }
  }
}
</style>
