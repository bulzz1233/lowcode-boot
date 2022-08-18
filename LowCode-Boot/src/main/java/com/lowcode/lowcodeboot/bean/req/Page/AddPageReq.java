package com.lowcode.lowcodeboot.bean.req.Page;

import lombok.Data;

@Data
public class AddPageReq {
    private Long projectId;
    private Long uid;
    private String pageName;
}
