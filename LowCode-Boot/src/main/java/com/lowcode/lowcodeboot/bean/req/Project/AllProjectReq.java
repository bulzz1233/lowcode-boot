package com.lowcode.lowcodeboot.bean.req.Project;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
//查询所有项目所需的参数
public class AllProjectReq {
    @NotBlank
    private Long  uid;
}
