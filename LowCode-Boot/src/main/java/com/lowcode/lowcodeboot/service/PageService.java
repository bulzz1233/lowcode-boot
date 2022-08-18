package com.lowcode.lowcodeboot.service;

import com.lowcode.lowcodeboot.bean.req.Page.AllPageReq;
import com.lowcode.lowcodeboot.bean.req.Page.DeletePageReq;
import com.lowcode.lowcodeboot.bean.req.Page.UpdatePageReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.PageVO;

import java.util.List;

public interface PageService {
    Result<List<PageVO>> allPage(AllPageReq allPageReq);

    void updatePage(UpdatePageReq updatePageReq);

    void deletePage(DeletePageReq deletePageReq);
}
