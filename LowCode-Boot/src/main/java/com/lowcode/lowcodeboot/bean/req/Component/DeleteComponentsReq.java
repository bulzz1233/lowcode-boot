package com.lowcode.lowcodeboot.bean.req.Component;

import lombok.Data;

@Data
public class DeleteComponentsReq {
    private Long projectId;
    private Long componentId;
}
