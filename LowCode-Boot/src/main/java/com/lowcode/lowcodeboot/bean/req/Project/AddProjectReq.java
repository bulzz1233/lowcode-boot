package com.lowcode.lowcodeboot.bean.req.Project;

import com.lowcode.lowcodeboot.bean.entity.ProjectDO;
import lombok.Data;

import java.util.List;

@Data

public class AddProjectReq {
    private List<ProjectDO> list;

}
