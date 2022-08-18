package com.lowcode.lowcodeboot.bean.vo;

import com.lowcode.lowcodeboot.bean.dto.UserDTO;
import lombok.Data;
import lombok.ToString;

@Data

@ToString(callSuper = true)
public class UserVO extends UserDTO {
    private String token;

}
