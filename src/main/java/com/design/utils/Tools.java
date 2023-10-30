package com.design.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.common.PageResult;

public class Tools {
  
  public static PageResult SetPageTemplate(PageResult res, Page page) {
    res.setPage(page.getCurrent());
    res.setPageSize(page.getSize());
    res.setTotal(page.getTotal());
    res.setList(page.getRecords());
    
    return res;
  }
}
