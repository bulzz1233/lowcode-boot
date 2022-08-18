package com.lowcode.lowcodeboot.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("components")
public class ComponentsDO {
    @TableId(type = IdType.AUTO)
    private Long  componentId;
    private Long projectId;
    private Long pageId;
    private String component;

    private String label;
    private String propValue;
    private String icon;
    private String animations;
    private String events;
    private String style;
}
