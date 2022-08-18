package com.lowcode.lowcodeboot.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("page")
public class PageDO {
    @TableId(type = IdType.AUTO)
    private Long  pageId;
    private Long projectId;
    private Long uid;
    private String pageName;
}
