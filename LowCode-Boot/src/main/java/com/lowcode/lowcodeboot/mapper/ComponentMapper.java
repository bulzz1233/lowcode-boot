package com.lowcode.lowcodeboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lowcode.lowcodeboot.bean.dto.ComponentsDTO;
import com.lowcode.lowcodeboot.bean.entity.ComponentsDO;
import com.lowcode.lowcodeboot.bean.req.Component.AllComponentsReq;
import com.lowcode.lowcodeboot.bean.req.Component.DeleteComponentsReq;
import com.lowcode.lowcodeboot.bean.vo.ComponentsVO;

import java.util.List;

public interface ComponentMapper extends BaseMapper<ComponentsDO> {

    List<ComponentsDO> allComponent(AllComponentsReq allComponentsReq);

    void delComponent(DeleteComponentsReq deleteComponentsReq);

    void updateComponent(ComponentsDO componentsDO);
}
