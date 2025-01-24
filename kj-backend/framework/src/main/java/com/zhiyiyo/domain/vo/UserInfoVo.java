package com.zhiyiyo.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO（值对象）通常表示不可变的对象，它的值一旦创建就不会改变。VO 类用于在不同的系统层级中传递值。VO 类通常不包含行为，只包含一些数据字段，通常是由多个属性组合而成。

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVo {
    private Long id;

    private String userName;

    private String nickName;

    private String signature;

    private String avatar;

    private String sex;

    private Boolean isAdmin;

    private String email;

    private String wechatAccount;

    private String phonenumber;
}
