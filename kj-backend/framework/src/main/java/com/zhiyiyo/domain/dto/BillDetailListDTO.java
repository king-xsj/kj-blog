package com.zhiyiyo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDetailListDTO {

    private Long id;

    @NotBlank(message = "时间不能为空")
    @Pattern(regexp = "^((19)|(2\\d))\\d{2}/((0?[1-9])|1[012])$", message = "日期格式错误")
    private String billTime;

    private String location;

    @NotBlank(message = "金额不能为空")
    private BigDecimal amount;

    @NotBlank(message = "类型不能为空")
    private String type;

    private String typeIcon;

    private String typeName;

    private String remark;

    private String carId;
}
