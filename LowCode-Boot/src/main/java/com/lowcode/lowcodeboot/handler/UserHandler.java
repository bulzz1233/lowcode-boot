package com.lowcode.lowcodeboot.handler;

import com.lowcode.lowcodeboot.bean.req.User.LoginReq;
import com.lowcode.lowcodeboot.bean.req.User.UserAddReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.UserVO;
import com.lowcode.lowcodeboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//用户接口
@RestController
@Slf4j
@RequestMapping("/user")
public class UserHandler {
    @Resource
    private UserService userService;

    //用户登录 {"userName":" ","passWord":" "}
    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody @Validated LoginReq loginReq) {
        log.info("login params:{}", loginReq);

        return userService.login(loginReq);
    }

    //用户注册 {"userName":" ","passWord":" "}
    @PostMapping("/register")
    public Result<String> add(@RequestBody @Validated UserAddReq userAddReq) {
        log.info("login params:{}", userAddReq);
        userService.add(userAddReq);
        return Result.buildSuccess("添加成功");
    }
}
