package com.zhiyiyo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiyiyo.domain.ResponseResult;
import com.zhiyiyo.domain.entity.BillTypes;
import com.zhiyiyo.mapper.BIllTypeMappper;
import com.zhiyiyo.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BIllTypeServiceImpl extends ServiceImpl<BIllTypeMappper, BillTypes> implements BillService {
    //@Autowired
    //private BillService billService;
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    @Override
    public ResponseResult getBillTypesList() {
        LambdaQueryWrapper<BillTypes> queryWrapper = new LambdaQueryWrapper<>();
        List<BillTypes> billTypesList = list(queryWrapper);
        return ResponseResult.okResult(billTypesList);
    }

}
