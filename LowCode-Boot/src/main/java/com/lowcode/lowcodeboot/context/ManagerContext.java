package com.lowcode.lowcodeboot.context;


import com.lowcode.lowcodeboot.bean.dto.UserDTO;

public class ManagerContext {
    private static ThreadLocal<UserDTO> threadLocal = new ThreadLocal<>();
    public static  void set(UserDTO dto){
        threadLocal.set(dto);
    }
    public static UserDTO get(){
        return threadLocal.get();
    }
    public static void remove(){
        threadLocal.remove();
    }
}
