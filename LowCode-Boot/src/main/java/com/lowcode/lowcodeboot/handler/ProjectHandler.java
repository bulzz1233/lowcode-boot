package com.lowcode.lowcodeboot.handler;

import com.lowcode.lowcodeboot.bean.req.Project.AllProjectReq;
import com.lowcode.lowcodeboot.bean.req.Project.AddProjectReq;
import com.lowcode.lowcodeboot.bean.req.Project.DeleteProjectReq;
import com.lowcode.lowcodeboot.bean.req.Project.UpdateProjectReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.ProjectVO;
import com.lowcode.lowcodeboot.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//首页项目信息接口
@RestController
@Slf4j
@RequestMapping("/project")
public class ProjectHandler {
    @Resource
    private ProjectService projectService;

    @PostMapping("all")
    public Result<List<ProjectVO>> allProject(@RequestBody AllProjectReq allProjectReq) {
        return projectService.allProject(allProjectReq);
    }

    @PostMapping("addProject")
    public Result<String> addProject(@RequestBody @Validated AddProjectReq addProjectReq) {
        for (int i = 0; i < addProjectReq.getList().size(); i++) {
            System.out.println(addProjectReq.getList().get(i));
            projectService.addProject(addProjectReq.getList().get(i));
        }
        return Result.buildSuccess("添加成功");
    }
    @PostMapping("deleteProject")
    public Result<String> delProject(@RequestBody DeleteProjectReq deleteProjectReq) {
        if (deleteProjectReq == null) {
            return Result.buildFailure("id不存在，删除失败");
        }
        projectService.delProject(deleteProjectReq);
        return Result.buildSuccess("删除成功");
    }
    @PostMapping("/updateProject")
    public Result<String> updateProject(@RequestBody UpdateProjectReq updateProjectReq) {
        if (updateProjectReq == null) {
            return Result.buildFailure("id不存在，修改失败");
        }
        projectService.updateProject(updateProjectReq);
        return Result.buildSuccess("修改成功");
    }
}
