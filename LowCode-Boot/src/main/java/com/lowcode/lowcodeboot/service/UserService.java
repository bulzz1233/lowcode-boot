package com.lowcode.lowcodeboot.service;

import com.lowcode.lowcodeboot.bean.req.User.LoginReq;
import com.lowcode.lowcodeboot.bean.req.User.UserAddReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.UserVO;

public interface UserService {
    Result<UserVO> login(LoginReq loginReq);

    void add(UserAddReq userAddReq);
}
