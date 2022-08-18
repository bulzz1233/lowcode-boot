package com.lowcode.lowcodeboot.bean.dto;

import lombok.Data;

//定义了返回给前端的由哪些信息生成的
@Data
public class UserDTO {
    private Long uid;
    private String userName;

}
