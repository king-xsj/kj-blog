package com.zhiyiyo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiyiyo.domain.ResponseResult;
import com.zhiyiyo.domain.dto.TagDTO;
import com.zhiyiyo.domain.entity.Tag;
import com.zhiyiyo.domain.vo.TagVo;
import com.zhiyiyo.mapper.TagMapper;
import com.zhiyiyo.service.ArticleService;
import com.zhiyiyo.service.TagService;
import com.zhiyiyo.utils.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Autowired
    private ArticleService articleService;
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    @Override
    public ResponseResult addTag(TagDTO tag) {
        logger.info(String.valueOf(tag));
        Tag newTag = BeanCopyUtils.copyBean(tag, Tag.class);
        saveOrUpdate(newTag);
        return  ResponseResult.okResult(newTag.getId());
    }

    @Override
    public ResponseResult deleteTag(Long id) {
        logger.info(String.valueOf(id));
        removeById(id);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getTagCountList() {
        // 查询出所有非草稿文章携带的标签 id
        //List<Article> articles = articleService.listNormalArticle();
        //List<Long> articleIds = articles.stream().map(Article::getId).collect(Collectors.toList());
        //QueryWrapper<ArticleTag> articleTagWrapper = new QueryWrapper<>();
        //articleTagWrapper.in("article_id", articleIds);
        //articleTagWrapper.select("tag_id", "count(*) as count").groupBy("tag_id");
        //List<ArticleTag> articleTags = articleTagMapper.selectList(articleTagWrapper);
        //
        //// 获取标签名和标签出现次数
        //Map<Long, Integer> tagCountMap = articleTags.stream()
        //        .collect(Collectors.toMap(ArticleTag::getTagId, ArticleTag::getCount));
        //LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
        //wrapper.in(Tag::getId, tagCountMap.keySet());
        //List<TagCountVo> tagVos = BeanCopyUtils.copyBeanList(list(wrapper), TagCountVo.class);
        //tagVos.forEach(tagVo -> tagVo.setCount(tagCountMap.get(tagVo.getId())));
        //
        //return ResponseResult.okResult(tagVos);
        // 创建查询条件，过滤掉已删除的标签
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Tag::getDelFlag, 0);  // 假设 isDeleted 为 false 表示未删除
        List<Tag> tags = list(queryWrapper);
        // 将标签实体转换为 VO 对象
        List<TagVo> tagVos = BeanCopyUtils.copyBeanList(tags, TagVo.class);
        return ResponseResult.okResult(tagVos);
    }

    @Override
    public Tag getOrAddTagByName(String name) {
        LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Tag::getName, name);
        Tag tag = getOne(wrapper);

        if (tag == null) {
            tag = new Tag();
            tag.setName(name);
            save(tag);
        }

        return tag;
    }
}
