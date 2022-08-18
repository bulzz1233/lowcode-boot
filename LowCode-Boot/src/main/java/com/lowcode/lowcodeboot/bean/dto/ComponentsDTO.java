package com.lowcode.lowcodeboot.bean.dto;

import lombok.Data;

import java.util.List;

@Data
public class ComponentsDTO {
    private Long projectId;
    private Long pageId;
    private Long componentId;
    private String label;
    private String propValue;
    private String component;
    private String icon;
    private List<?> animations;
    private Object events;
    private Object style;
}
