package com.design.common;

import lombok.Getter;

@Getter
public enum StatusCode {
  SUCCESS(200, "请求成功"),
  FAILED(500, "系统内部异常"),
  UNAUTHORIZED(401, "token不正确或已过期"),
  FORBIDDEN(403, "权限不足"),
  PARAMETER_ERROR(404, "传递参数错误");
  
  private final Integer code;
  private final String message;
  
  StatusCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
