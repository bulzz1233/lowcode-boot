package com.lowcode.lowcodeboot.bean.req.Page;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class AllPageReq {
    @NotBlank
    private Long  uid;
    @NotBlank
    private Long  projectId;

}
