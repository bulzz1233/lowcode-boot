package com.lowcode.lowcodeboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lowcode.lowcodeboot.bean.dto.UserDTO;
import com.lowcode.lowcodeboot.bean.entity.UserDO;
import com.lowcode.lowcodeboot.bean.req.User.LoginReq;
import com.lowcode.lowcodeboot.bean.req.User.UserAddReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.UserVO;
import com.lowcode.lowcodeboot.ex.BizEx;
import com.lowcode.lowcodeboot.mapper.UserMapper;
import com.lowcode.lowcodeboot.service.UserService;
import com.lowcode.lowcodeboot.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j

public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Result<UserVO> login(LoginReq loginReq) {
        //        构造查询,查询用户是否存在
        LambdaQueryWrapper<UserDO> qw = new LambdaQueryWrapper<>();
        qw.eq(UserDO::getUserName, loginReq.getUserName())
                .eq(UserDO::getUserPassword, loginReq.getUserPassword());
        UserDO userDO = userMapper.selectOne(qw);
        log.info("result:{}", JSON.toJSONString(userDO));
        if (userDO == null) {
            return Result.buildFailure("用户名或密码不正确");
        }
//        生成token
        UserVO vo = generateToken(userDO);

        return Result.buildSuccess(vo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(UserAddReq userAddReq) {
        LambdaQueryWrapper<UserDO> qw = new LambdaQueryWrapper<>();
        qw.eq(UserDO::getUserName,userAddReq.getUserName());
        Long count=userMapper.selectCount(qw);
        if(count>0){
            throw new BizEx("该用户名已被使用");

        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userAddReq,userDO);
        userMapper.insert(userDO);
    }


    //封装生成token函数
    private UserVO generateToken(UserDO userDO) {
        System.out.println('2');
        System.out.println(userDO);
        UserDTO userDTO = new UserDTO();
//        将userDO实例对象的值复制到DTO里面
        BeanUtils.copyProperties(userDO, userDTO);
        System.out.println('1');
        System.out.println(userDTO);
        String token = JwtUtil.getToken(userDTO);
        //给前端返回token+用户信息
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(userDTO,vo);
        vo.setToken(token);
        return vo;
    }
}
