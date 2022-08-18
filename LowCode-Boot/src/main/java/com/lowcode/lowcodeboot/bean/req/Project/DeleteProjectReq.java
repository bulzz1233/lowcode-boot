package com.lowcode.lowcodeboot.bean.req.Project;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DeleteProjectReq {
    @NotBlank
    private Long  uid;
    @NotBlank
    private Long  projectId;
}
