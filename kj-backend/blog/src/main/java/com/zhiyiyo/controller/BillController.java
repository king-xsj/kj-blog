package com.zhiyiyo.controller;

import com.zhiyiyo.domain.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
    @GetMapping("/types")
    public ResponseResult getBillTypesList(){
        return ResponseResult.okResult();
    }
}
