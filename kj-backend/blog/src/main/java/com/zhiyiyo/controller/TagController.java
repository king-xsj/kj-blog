package com.zhiyiyo.controller;

import com.zhiyiyo.domain.ResponseResult;
import com.zhiyiyo.domain.dto.TagDTO;
import com.zhiyiyo.service.TagService;
import com.zhiyiyo.service.impl.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    @GetMapping("/tagCountList")
    public ResponseResult getTagCountList(){
        return tagService.getTagCountList();
    }

    @PostMapping()
    public ResponseResult addTag(@Valid @RequestBody Map<String, Object> requestData) {
        TagDTO tag = new TagDTO();
        tag.setName((String) requestData.get("tagName"));
        logger.info(String.valueOf(tag));
        return tagService.addTag(tag);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteTag(@Valid @PathVariable Long id) {
        return tagService.deleteTag(id);
    }
}
