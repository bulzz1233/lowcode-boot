package com.lowcode.lowcodeboot.service;

import com.lowcode.lowcodeboot.bean.entity.ProjectDO;
import com.lowcode.lowcodeboot.bean.req.Project.AllProjectReq;
import com.lowcode.lowcodeboot.bean.req.Project.DeleteProjectReq;
import com.lowcode.lowcodeboot.bean.req.Project.UpdateProjectReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.ProjectVO;

import java.util.List;

public interface ProjectService {
    Result<List<ProjectVO>> allProject(AllProjectReq allProjectReq);

    void addProject(ProjectDO projectDO);

    void delProject(DeleteProjectReq deleteProjectReq);

    void updateProject(UpdateProjectReq updateProjectReq);
}
