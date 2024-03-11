package com.design.common;

import lombok.Data;


@Data
public class PageResult {
  private Object list;
  private Long total;
  private Long page;
  private Long pageSize;

  public static <T> PageResult<T> of(List<T> list, Long total){
    PageResult<T> pageResult = new PageResult<>();
    pageResult.setList(list);
    pageResult.setTotal(total);
    return pageResult;
  }

  public static <T> PageResult<T> of(List<T> list, Long total, Long pageNum, Long pageSize){
    PageResult<T> pageResult = new PageResult<>();
    pageResult.setList(list);
    pageResult.setTotal(total);
    pageResult.setPage(pageNum);
    pageResult.setPageSize(pageSize);
    return pageResult;
  }
}
