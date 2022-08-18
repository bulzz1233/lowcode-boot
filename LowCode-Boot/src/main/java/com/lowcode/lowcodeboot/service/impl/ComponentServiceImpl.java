package com.lowcode.lowcodeboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.gson.Gson;
import com.lowcode.lowcodeboot.bean.dto.ComponentsDTO;
import com.lowcode.lowcodeboot.bean.entity.ComponentsDO;
import com.lowcode.lowcodeboot.bean.req.Component.AllComponentsReq;
import com.lowcode.lowcodeboot.bean.req.Component.DeleteComponentsReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.ComponentsVO;
import com.lowcode.lowcodeboot.ex.BizEx;
import com.lowcode.lowcodeboot.mapper.ComponentMapper;
import com.lowcode.lowcodeboot.service.ComponentService;
import com.lowcode.lowcodeboot.util.PagerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class ComponentServiceImpl implements ComponentService {
    @Resource
    private ComponentMapper componentMapper;


    @Override
    public void addComponent(ComponentsDTO componentsDTO) {
        ComponentsDO componentsDO = new ComponentsDO();
        Gson gson = new Gson();
        String str = "";
        if( componentsDTO.getAnimations().size()>0){
            for (int i = 0; i < componentsDTO.getAnimations().size(); i++) {
                //不断相加
                if (i != 0) {
                    str += ",";
                }
                str += componentsDTO.getAnimations().get(i);
            }
        }


        componentsDO.setAnimations(str);
        componentsDO.setProjectId(componentsDTO.getProjectId());
        componentsDO.setLabel(componentsDTO.getLabel());
        componentsDO.setIcon(componentsDTO.getIcon());
        componentsDO.setPageId(componentsDTO.getPageId());
        String event = gson.toJson(componentsDTO.getEvents());
        componentsDO.setEvents(event);
        String style = gson.toJson(componentsDTO.getStyle());

        componentsDO.setStyle(style);
        componentsDO.setComponent(componentsDTO.getComponent());
        componentsDO.setPropValue(componentsDTO.getPropValue());
        componentMapper.insert(componentsDO);
    }

    @Override
    public Result<List<ComponentsVO>> allComponent(AllComponentsReq allComponentsReq) {
        PagerUtil.startPage(1, 300);
        List<ComponentsDO> componentsDOList = componentMapper.allComponent(allComponentsReq);
        List<ComponentsVO> componentsVOList =new ArrayList<>();
        Gson gson = new Gson();

        //        ComponentsVO componentsVO =new ComponentsVO();
        for(int i = 0;i<componentsDOList.toArray().length;i++){
            ComponentsVO componentsVO = new ComponentsVO();
            System.out.println("----------------");
            String [] arry= componentsDOList.get(i).getAnimations().split(",");
            componentsVO.setAnimations(Arrays.asList(arry));
            componentsVO.setComponentId(componentsDOList.get(i).getComponentId());
            componentsVO.setEvents(gson.fromJson(componentsDOList.get(i).getEvents(),Object.class));
            componentsVO.setPageId(componentsDOList.get(i).getPageId());
            componentsVO.setProjectId(componentsDOList.get(i).getProjectId());
            componentsVO.setPropValue(componentsDOList.get(i).getPropValue());
            componentsVO.setLabel(componentsDOList.get(i).getLabel());
            componentsVO.setIcon(componentsDOList.get(i).getIcon());
            componentsVO.setComponent(componentsDOList.get(i).getComponent());
            componentsVO.setStyle(gson.fromJson(componentsDOList.get(i).getStyle(),Object.class));
            componentsVOList.add(componentsVO);
        }
//
        return PagerUtil.wrapPageData(componentsVOList);
    }

    @Override
    public void delComponent(DeleteComponentsReq deleteComponentsReq) {
        componentMapper.delComponent(deleteComponentsReq);

    }

    @Override
    public void updateComponent(ComponentsDTO componentsDTO) {
        ComponentsDO componentsDO = new ComponentsDO();
        Gson gson = new Gson();
        String str = "";
        if( componentsDTO.getAnimations().size()>0){
            for (int i = 0; i < componentsDTO.getAnimations().size(); i++) {
                //不断相加
                if (i != 0) {
                    str += ",";
                }
                str += componentsDTO.getAnimations().get(i);
            }
        }


        componentsDO.setAnimations(str);
        componentsDO.setComponentId(componentsDTO.getComponentId());
        componentsDO.setProjectId(componentsDTO.getProjectId());
        componentsDO.setLabel(componentsDTO.getLabel());
        componentsDO.setIcon(componentsDTO.getIcon());
        componentsDO.setPageId(componentsDTO.getPageId());
        String event = gson.toJson(componentsDTO.getEvents());
        componentsDO.setEvents(event);
        String style = gson.toJson(componentsDTO.getStyle());

        componentsDO.setStyle(style);
        componentsDO.setComponent(componentsDTO.getComponent());
        componentsDO.setPropValue(componentsDTO.getPropValue());
        componentMapper.updateComponent(componentsDO);
    }
}


