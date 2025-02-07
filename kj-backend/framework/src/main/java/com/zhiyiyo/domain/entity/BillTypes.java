package com.zhiyiyo.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bill_type")
public class BillTypes implements Serializable {
    private static final long serialVersionUID = 737059071294711993L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String type;

    private String icon;

    private String text;
}
