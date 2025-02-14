package com.zhiyiyo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

// DTO 是数据传输对象，主要用于在不同系统、不同层之间传递数据。DTO 通常是一个扁平的对象，包含了简单的数据结构。它是为了减少网络请求的次数，将多个数据字段集中到一个对象中，从而进行高效的传输。
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    /**
     * 个性签名
     */
    @Length(max = 64, message = "个性签名的长度不能超过 64 个字符")
    private String signature;

    /**
     * 用户类型：0代表普通用户，1代表管理员
     */
    private String type;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    //@Email(message = "邮箱格式错误")
    private String email;

    /**
     * 微信賬號
     */
    private String wechatAccount;

    /**
     * 手机号
     */
    private String phonenumber;

    /**
     * 用户性别（0男，1女，2未知）
     */
    private String sex;

    /**
     * 头像
     */
    private String avatar;
}
