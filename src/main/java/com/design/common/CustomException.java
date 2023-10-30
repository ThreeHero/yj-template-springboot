package com.design.common;

import lombok.Data;

/**
 * 自定义异常类
 */
@Data
public class CustomException extends RuntimeException {
  // 异常对应的状态码
  private Integer exceptionCode;
  // 异常对应的描述
  private String exceptionMessage;
  
  public CustomException() {
    super();
  }
}
