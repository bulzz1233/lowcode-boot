package com.lowcode.lowcodeboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lowcode.lowcodeboot.bean.req.Page.AllPageReq;
import com.lowcode.lowcodeboot.bean.req.Page.DeletePageReq;
import com.lowcode.lowcodeboot.bean.req.Page.UpdatePageReq;
import com.lowcode.lowcodeboot.bean.vo.PageVO;

import java.util.List;

public interface PageMapper extends BaseMapper<PageVO> {
     List<PageVO> allPage(AllPageReq allPageReq);

    void updatePage(UpdatePageReq updatePageReq);

    void deletePage(DeletePageReq deletePageReq);
}
