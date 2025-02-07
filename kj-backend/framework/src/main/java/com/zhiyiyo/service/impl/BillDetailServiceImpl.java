package com.zhiyiyo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiyiyo.domain.ResponseResult;
import com.zhiyiyo.domain.dto.BillDetailListDTO;
import com.zhiyiyo.domain.dto.BillDetailQueryDTO;
import com.zhiyiyo.domain.entity.BillDetailList;
import com.zhiyiyo.domain.vo.BillDetailListVo;
import com.zhiyiyo.domain.vo.PageVo;
import com.zhiyiyo.mapper.BillDetailListMapper;
import com.zhiyiyo.service.BillDetailService;
import com.zhiyiyo.utils.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class BillDetailServiceImpl extends ServiceImpl<BillDetailListMapper, BillDetailList> implements BillDetailService {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    @Override
    public ResponseResult addBillDetailList(BillDetailListDTO requestData) {
        BillDetailList newTag = BeanCopyUtils.copyBean(requestData, BillDetailList.class);
        saveOrUpdate(newTag);
        BillDetailListDTO bill = new BillDetailListDTO();
        bill.setId(newTag.getId());
        return ResponseResult.okResult(bill);
    }

    @Override
    public ResponseResult getBillDetailList(BillDetailQueryDTO billDetailQueryDTO) {

        logger.info("=====>d:" + billDetailQueryDTO.getDate());
        String date = billDetailQueryDTO.getDate();
        LocalDate firstDay = LocalDate.parse(date + "-01");  // 解析为 LocalDate
        LocalDate lastDay = firstDay.with(TemporalAdjusters.lastDayOfMonth()); // 获取该月最后一天
        // 转换为 Date 格式
        Timestamp startDate = Timestamp.valueOf(firstDay.atStartOfDay());
        Timestamp endDate = Timestamp.valueOf(lastDay.atTime(23, 59, 59));
        logger.info("=====>startDate:" + startDate);
        logger.info("=====>endDate:" + endDate);
        LambdaQueryWrapper<BillDetailList> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.between(BillDetailList::getBillTime, startDate, endDate);
        queryWrapper.orderByDesc(BillDetailList::getBillTime);

        // 分页查询
        // 从数据库中分页查询
        Page<BillDetailList> page = new Page<>(billDetailQueryDTO.getPageNum(), billDetailQueryDTO.getPageSize());
        this.page(page, queryWrapper);
        List<BillDetailList> billDetailLists = page.getRecords();
        List<BillDetailListVo> billDetailListVos = BeanCopyUtils.copyBeanList(billDetailLists, BillDetailListVo.class);
        return ResponseResult.okResult(new PageVo<>(page.getCurrent(), page.getTotal(), billDetailListVos));
    }
}
