package com.zhiyiyo.controller;

import com.zhiyiyo.domain.ResponseResult;
import com.zhiyiyo.domain.dto.BillDetailListDTO;
import com.zhiyiyo.domain.dto.BillDetailQueryDTO;
import com.zhiyiyo.service.BillDetailService;
import com.zhiyiyo.service.BillService;
import com.zhiyiyo.service.impl.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/bill")
public class BillController {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    @Autowired
    private BillService billService;

    @Autowired
    private BillDetailService billDetailService;
    @GetMapping("/types")
    public ResponseResult getBillTypesList(){
        return billService.getBillTypesList();
    }

    @PostMapping("/detailList")
    public ResponseResult addBillDetailList(@Valid @RequestBody Map<String, Object> requestData){
        logger.info("=====>:" + requestData);
        BillDetailListDTO billDetail = new BillDetailListDTO();
        billDetail.setId((Long) requestData.get("id"));
        billDetail.setBillTime((String) requestData.get("billTime"));
        billDetail.setTypeIcon((String) requestData.get("typeIcon"));
        billDetail.setTypeName((String) requestData.get("typeName"));
        billDetail.setLocation((String) requestData.get("location"));
        billDetail.setRemark((String) requestData.get("remark"));
        billDetail.setType((String) requestData.get("type"));
        billDetail.setCarId((String) requestData.get("carId"));
        billDetail.setAmount((BigDecimal) requestData.get("amount"));
        return billDetailService.addBillDetailList(billDetail);
    }

    @GetMapping("detailList")
    public ResponseResult getBillDetailList(@Valid BillDetailQueryDTO billDetailQueryDTO) {
        logger.info("=====>:" + billDetailQueryDTO);
        return billDetailService.getBillDetailList(billDetailQueryDTO);
    }
}
