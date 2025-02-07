package com.zhiyiyo.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bill_detail_list")
public class BillDetailList implements Serializable {
    private static final long serialVersionUID = 737059071294711994L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String billTime;

    private String location;

    private BigDecimal amount;

    private String type;

    private String typeIcon;

    private String typeName;

    private String remark;

    private String carId;
}
