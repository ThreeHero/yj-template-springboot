package com.design.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理函数
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  
  /*
    处理自定义异常
   */
  @ResponseBody
  @ExceptionHandler({CustomException.class})
  public Result<String> exceptionHandler(CustomException ex) {
    return Result.fail(StatusCode.FAILED.getCode(), StatusCode.FAILED.getMessage());
  }
}
