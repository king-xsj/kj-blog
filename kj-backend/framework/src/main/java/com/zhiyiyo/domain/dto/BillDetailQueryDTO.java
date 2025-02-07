package com.zhiyiyo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDetailQueryDTO {
    private Integer pageNum = 1;

    @Range(min = 1, max = 100, message = "每页条目数只能在 1-100 之间")
    private Integer pageSize = 10;

    private String date;
}
