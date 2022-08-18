package com.lowcode.lowcodeboot.service.impl;

import com.lowcode.lowcodeboot.bean.req.Page.AllPageReq;
import com.lowcode.lowcodeboot.bean.req.Page.DeletePageReq;
import com.lowcode.lowcodeboot.bean.req.Page.UpdatePageReq;
import com.lowcode.lowcodeboot.bean.res.Result;
import com.lowcode.lowcodeboot.bean.vo.PageVO;
import com.lowcode.lowcodeboot.mapper.PageMapper;
import com.lowcode.lowcodeboot.service.PageService;
import com.lowcode.lowcodeboot.util.PagerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PageServiceImpl implements PageService {
    @Resource
    private PageMapper pageMapper;
    @Override
    public Result<List<PageVO>> allPage(AllPageReq allPageReq) {
        PagerUtil.startPage(1,300);
        List<PageVO> list = pageMapper.allPage(allPageReq);
        return PagerUtil.wrapPageData(list);
    }

    @Override
    public void updatePage(UpdatePageReq updatePageReq) {
        pageMapper.updatePage(updatePageReq);
    }

    @Override
    public void deletePage(DeletePageReq deletePageReq) {
        pageMapper.deletePage(deletePageReq);

    }
}
