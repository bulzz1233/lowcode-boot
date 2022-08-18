package com.lowcode.lowcodeboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lowcode.lowcodeboot.bean.entity.ProjectDO;
import com.lowcode.lowcodeboot.bean.req.Project.AllProjectReq;
import com.lowcode.lowcodeboot.bean.req.Project.DeleteProjectReq;
import com.lowcode.lowcodeboot.bean.req.Project.UpdateProjectReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.ProjectVO;
import com.lowcode.lowcodeboot.ex.BizEx;
import com.lowcode.lowcodeboot.mapper.ProjectMapper;
import com.lowcode.lowcodeboot.service.ProjectService;
import com.lowcode.lowcodeboot.util.PagerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j

public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;
    @Override
    public Result<List<ProjectVO>> allProject(AllProjectReq allProjectReq) {
        PagerUtil.startPage(1,300);
        List<ProjectVO> list = projectMapper.all(allProjectReq);
        System.out.println(list);
        return PagerUtil.wrapPageData(list);
    }

    @Override
    public void addProject(ProjectDO projectDO) {
        LambdaQueryWrapper<ProjectDO> qw = new LambdaQueryWrapper<>();
        qw.eq(ProjectDO::getTitle,projectDO.getTitle())
                .eq(ProjectDO::getUid,projectDO.getUid());
        Long count=projectMapper.selectCount(qw);
        if(count>1){
            throw new BizEx("该项目已添加");
        }
        projectMapper.insert(projectDO);
    }

    @Override
    public void delProject(DeleteProjectReq deleteProjectReq) {
        projectMapper.delProject(deleteProjectReq);

    }

    @Override
    public void updateProject(UpdateProjectReq updateProjectReq) {
        projectMapper.updateProject(updateProjectReq);

    }
}
