package com.lowcode.lowcodeboot.bean.req.Component;

import com.lowcode.lowcodeboot.bean.dto.ComponentsDTO;
import lombok.Data;

import java.util.List;
@Data
public class UpdateComponentsReq {
    private List<ComponentsDTO> componentsList;
}
