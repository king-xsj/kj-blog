package com.zhiyiyo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiyiyo.domain.ResponseResult;
import com.zhiyiyo.domain.dto.BillDetailListDTO;
import com.zhiyiyo.domain.dto.BillDetailQueryDTO;
import com.zhiyiyo.domain.entity.BillDetailList;

public interface BillDetailService extends IService<BillDetailList> {
    ResponseResult addBillDetailList(BillDetailListDTO requestData);
    ResponseResult getBillDetailList(BillDetailQueryDTO billDetailQueryDTO);
}
