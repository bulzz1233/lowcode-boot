package com.lowcode.lowcodeboot.bean.req.Project;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateProjectReq {
    @NotBlank
    private Long  uid;
    @NotBlank
    private Long  projectId;
    private  String title;
    private  String type;
    private  Boolean funcBoxIsShow;
}
