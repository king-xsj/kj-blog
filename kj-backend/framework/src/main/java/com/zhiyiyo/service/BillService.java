package com.zhiyiyo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiyiyo.domain.ResponseResult;
import com.zhiyiyo.domain.entity.BillTypes;

public interface BillService extends IService<BillTypes> {
    ResponseResult getBillTypesList();
}
