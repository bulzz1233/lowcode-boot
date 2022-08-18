package com.lowcode.lowcodeboot.enums;
//响应码枚举类
public enum CodeEnum {
    SUCCESS(200,"成功"),

    PARAM_ERR(10000,"参数不正确"),

    DB_ERR(20000,"数据库错误"),
    DUPLICATE_KEY_ERR(20001,"唯一性约束校验失败"),
    BIZ_ERR(30000,"业务异常"),
    AUTH_ERR(40000,"权限不足"),
    SYS_ERR(50000,"系统异常")

    ;
     CodeEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
