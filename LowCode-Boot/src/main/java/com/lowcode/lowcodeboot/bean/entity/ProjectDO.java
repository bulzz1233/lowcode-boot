package com.lowcode.lowcodeboot.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//表示识别后该实体和哪张数据库表对应
@TableName("project")
public class ProjectDO {
    @TableId(type = IdType.AUTO)
    private Long  projectId;
    private  Long uid;
    private  String title;
    private  String type;
    private  Boolean funcBoxIsShow;


}
