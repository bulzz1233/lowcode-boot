package com.lowcode.lowcodeboot.bean.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PageVO {
    private Long  pageId;
    private Long projectId;
    private Long uid;
    private String pageName;
}
