package com.lowcode.lowcodeboot.bean.req.User;
import lombok.Data;
import javax.validation.constraints.NotBlank;
//规定登录请求参数
@Data
public class LoginReq {
    @NotBlank
    private  String userName;
    @NotBlank
    private  String userPassword;
}
