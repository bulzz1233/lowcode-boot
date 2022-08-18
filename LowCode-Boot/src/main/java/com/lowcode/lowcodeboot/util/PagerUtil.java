package com.lowcode.lowcodeboot.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lowcode.lowcodeboot.bean.res.Result;

import java.util.List;

//分页工具
public class PagerUtil {
    public static void startPage(Integer pageNow,Integer pageSize){
        PageHelper.startPage(pageNow,pageSize);

    }
    public static <T> Result<List<T>> wrapPageData(List<T> queryList){
        PageInfo<T> pageInfo = new PageInfo<>(queryList);
        return Result.buildSuccess(queryList,pageInfo.getTotal());
    }
}
