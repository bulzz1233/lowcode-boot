package com.lowcode.lowcodeboot.bean.req.Page;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DeletePageReq {
    @NotBlank
    private Long pageId;
    @NotBlank
    private Long uid;
}
