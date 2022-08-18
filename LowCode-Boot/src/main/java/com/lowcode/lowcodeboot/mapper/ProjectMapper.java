package com.lowcode.lowcodeboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lowcode.lowcodeboot.bean.entity.ProjectDO;
import com.lowcode.lowcodeboot.bean.req.Project.AllProjectReq;
import com.lowcode.lowcodeboot.bean.req.Project.DeleteProjectReq;
import com.lowcode.lowcodeboot.bean.req.Project.UpdateProjectReq;
import com.lowcode.lowcodeboot.bean.vo.ProjectVO;

import java.util.List;

public interface ProjectMapper extends BaseMapper<ProjectDO> {
    List<ProjectVO> all(AllProjectReq allProjectReq);

    void delProject(DeleteProjectReq deleteProjectReq);

    void updateProject(UpdateProjectReq updateProjectReq);
}
