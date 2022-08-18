package com.lowcode.lowcodeboot.bean.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class ComponentsVO {
    private Long projectId;
    private Long componentId;
    private Long pageId;
    private String label;
    private String propValue;
    private String component;
    private String icon;
    private List<?> animations;
    private Object events;
    private Object style;
}
