package com.lowcode.lowcodeboot.bean.req.User;

import lombok.Data;

import javax.validation.constraints.NotBlank;
//规定注册请求参数
@Data
public class UserAddReq {
    private Long  uid;
    @NotBlank
    private  String userName;
    @NotBlank
    private  String userPassword;
}
