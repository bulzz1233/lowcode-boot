package com.lowcode.lowcodeboot.interceptor;

import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.enums.CodeEnum;
import com.lowcode.lowcodeboot.ex.BizEx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//统一异常返回结果
@RestController
@Slf4j
public class ExAdvice {
//    只处理MethodArgumentNotValidException类型的异常
//    出现时机：Content-Type:application/json +后台使用@ResquestBody

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleEx(MethodArgumentNotValidException e) {
        log.error("入参校验失败", e);
        BindingResult bindingResult = e.getBindingResult();
//        获得到没用过校验的字段的详情
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        return Result.buildFailure(spliceErrMsg(fieldErrors));
    }


    //处理BindException类型错误
    //出现时机；Content-Type：application/x-www-form-urlencoded
    @ExceptionHandler(BindException.class)
    public Result<String> handleEx(BindException e) {
        log.error("参数绑定异常", e);
        List<FieldError> fieldErrors = e.getFieldErrors();
        return Result.buildFailure(spliceErrMsg(fieldErrors));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<String> handleEx(IllegalArgumentException e) {
        log.error("参数非法", e);
        return Result.buildFailure(CodeEnum.PARAM_ERR);
    }
    @ExceptionHandler(BadSqlGrammarException.class)
    public Result<String> handleEx(BadSqlGrammarException e) {
        log.error("数据库异常", e);
        return Result.buildFailure(CodeEnum.DB_ERR);
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public Result<String> handleEx(DuplicateKeyException e) {
        log.error("唯一性约束校验失败", e);
        return Result.buildFailure(CodeEnum.DB_ERR);
    }
    @ExceptionHandler(BizEx.class)
    public Result<String> handleEx(BizEx e) {
        log.error("业务异常", e);
        return Result.buildFailure(e.getCode(),e.getMessage());
    }
    //处理为精准匹配的异常
    @ExceptionHandler(Exception.class)
    public Result<String> handleEx(Exception e) {
        log.error("处理未精准匹配的异常", e);
        return Result.buildFailure(CodeEnum.SYS_ERR);
    }

    private String spliceErrMsg(List<FieldError> fieldErrors) {
        return fieldErrors.stream().map(fieldError -> {
            StringBuilder sb = new StringBuilder();
            sb.append("属性：").append(fieldError.getField())
                    .append(",传来的值是：").append(fieldError.getRejectedValue())
                    .append(",校验不通过，原因：").append(fieldError.getDefaultMessage());
            return sb.toString();

        }).collect(Collectors.joining(","));
    }
}
