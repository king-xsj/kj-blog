package com.zhiyiyo.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDetailListVo {
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
