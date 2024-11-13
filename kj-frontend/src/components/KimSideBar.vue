<template>
    <!-- 侧边栏 -->
    <div id="side-bar">
        <slot>
            <kim-admin-card />
            <kim-hot-article-card />
            <kim-category-card />
            <kim-tag-card />
            <kim-archive-card />
        </slot>
    </div>
</template>

<script>
export default {
    name: "KimSideBar"
}
</script>

<style lang="less" scoped>
#side-bar {
    width: 26%;
    margin-right: 20px;
}

@media screen and (max-width: 900px) {
    #side-bar {
        display: none;
    }
}
</style>