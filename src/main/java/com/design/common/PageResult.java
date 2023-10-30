package com.design.common;

import lombok.Data;


@Data
public class PageResult {
  private Object list;
  private Long total;
  private Long page;
  private Long pageSize;
}
