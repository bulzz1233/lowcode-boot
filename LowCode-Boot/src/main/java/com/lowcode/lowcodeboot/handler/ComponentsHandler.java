package com.lowcode.lowcodeboot.handler;

import com.lowcode.lowcodeboot.bean.req.Component.AddComponentsReq;
import com.lowcode.lowcodeboot.bean.req.Component.AllComponentsReq;
import com.lowcode.lowcodeboot.bean.req.Component.DeleteComponentsReq;
import com.lowcode.lowcodeboot.bean.req.Component.UpdateComponentsReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.ComponentsVO;
import com.lowcode.lowcodeboot.service.ComponentService;
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
@RequestMapping("/component")
public class ComponentsHandler {
    @Resource
    private ComponentService componentService;
    @PostMapping("/addComponent")
    public Result<String> addComponent(@RequestBody @Validated AddComponentsReq addComponentsReq) {
        for (int i = 0; i < addComponentsReq.getComponentsList().size(); i++) {
            System.out.println(addComponentsReq.getComponentsList().get(i));
            componentService.addComponent(addComponentsReq.getComponentsList().get(i));
        }
        return Result.buildSuccess("添加成功");
    }
    @PostMapping("/allComponent")
    public Result<List<ComponentsVO>> allComponent(@RequestBody AllComponentsReq allComponentsReq) {

        return componentService.allComponent(allComponentsReq);
    }
    @PostMapping("/updateComponent")
    public Result<String> updateComponent(@RequestBody UpdateComponentsReq updateComponentsReq) {
        for (int i = 0; i < updateComponentsReq.getComponentsList().size(); i++) {
            System.out.println(updateComponentsReq.getComponentsList().get(i));
            componentService.updateComponent(updateComponentsReq.getComponentsList().get(i));
        }
        return Result.buildSuccess("修改成功");
    }
    @PostMapping("/delComponent")
    public Result<String> delComponent(@RequestBody DeleteComponentsReq deleteComponentsReq) {
        if (deleteComponentsReq.getComponentId() == null) {
            return Result.buildFailure("id不存在，删除失败");
        }
        componentService.delComponent(deleteComponentsReq);
        return Result.buildSuccess("删除成功");
    }
}
