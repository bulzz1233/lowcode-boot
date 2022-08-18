package com.lowcode.lowcodeboot.handler;

import com.lowcode.lowcodeboot.bean.req.Page.AddPageReq;
import com.lowcode.lowcodeboot.bean.req.Page.AllPageReq;
import com.lowcode.lowcodeboot.bean.req.Page.DeletePageReq;
import com.lowcode.lowcodeboot.bean.req.Page.UpdatePageReq;
import com.lowcode.lowcodeboot.bean.req.User.UserAddReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.PageVO;
import com.lowcode.lowcodeboot.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/page")
public class PageHandler {
    @Resource
    private PageService pageService;
    @PostMapping("allPage")
    public Result<List<PageVO>> allPage(@RequestBody AllPageReq allPageReq) {
        return pageService.allPage(allPageReq);
    }

    @PostMapping("/updatePage")
    public Result<String> updatePage(@RequestBody UpdatePageReq updatePageReq) {
        if (updatePageReq == null) {
            return Result.buildFailure("id不存在，修改失败");
        }
        pageService.updatePage(updatePageReq);
        return Result.buildSuccess("修改成功");
    }
    @PostMapping("/deletePage")
    public Result<String> deletePage(@RequestBody DeletePageReq deletePageReq) {
        if (deletePageReq == null) {
            return Result.buildFailure("id不存在，删除失败");
        }
        pageService.deletePage(deletePageReq);
        return Result.buildSuccess("删除成功");
    }
    @PostMapping("/addPage")
    public Result<String> addPage(@RequestBody @Validated AddPageReq addPageReq){
        log.info("login params:{}", addPageReq);
        pageService.addPage(addPageReq);
        return Result.buildSuccess("添加成功");
    }
}
