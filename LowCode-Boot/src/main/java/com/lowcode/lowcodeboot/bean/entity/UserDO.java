package com.lowcode.lowcodeboot.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//表示识别后该实体和哪张数据库表对应
@TableName("user")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long  uid;
    private  String userName;
    private  String userPassword;

}
