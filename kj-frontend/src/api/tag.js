import request from "../utils/request"

/**
 * 获取所有标签的文章数量
 * @returns promise
 */
function getTagCountList() {
    return request.get("/tag/tagCountList")
}
function addTag(tag) {
    return request({
        url: "/tag",
        method: "post",
        data: tag,
        needAuthentication: true
    })
}
function deleteTag(tag) {
    return request({
        url: `/tag/${tag.id}`,
        method: "delete",
        needAuthentication: true
    })
}
export { getTagCountList, addTag, deleteTag }