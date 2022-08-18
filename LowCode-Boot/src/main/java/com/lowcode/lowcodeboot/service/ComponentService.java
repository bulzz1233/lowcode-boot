package com.lowcode.lowcodeboot.service;

import com.lowcode.lowcodeboot.bean.dto.ComponentsDTO;
import com.lowcode.lowcodeboot.bean.entity.ComponentsDO;
import com.lowcode.lowcodeboot.bean.req.Component.AllComponentsReq;
import com.lowcode.lowcodeboot.bean.req.Component.DeleteComponentsReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.ComponentsVO;

import java.util.List;

public interface ComponentService {

    void addComponent(ComponentsDTO componentsDTO);

    Result<List<ComponentsVO>> allComponent(AllComponentsReq allComponentsReq);

    void delComponent(DeleteComponentsReq deleteComponentsReq);

    void updateComponent(ComponentsDTO componentsDTO);
}
