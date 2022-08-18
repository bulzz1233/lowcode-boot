package com.lowcode.lowcodeboot.bean.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ProjectVO {
    private Long  projectId;
    private  Long uid;
    private  String title;
    private  String type;
    private  Boolean funcBoxIsShow;
}
