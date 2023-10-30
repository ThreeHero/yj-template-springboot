package com.design.common;

import lombok.Data;

/**
 * 统一返回结果
 * @param <T>
 */
@Data
public class Result<T> {
  private Integer code;
  private String message;
  private T data;
  
  public static <T> Result<T> result(Integer code, String message, T data) {
    Result<T> res = new Result<T>();
    res.setCode(code);
    res.setMessage(message);
    res.setData(data);
    return res;
  }
  
  /*
      成功
      修改删除等成功等 不需要返回数据 只需要成功结果和描述
      即 只有message
   */
  public static <T> Result<T> success(String message) {
    return Result.result(StatusCode.SUCCESS.getCode(), message, null);
  }
  
  /*
     成功
     当data为String时
  */
  public static <T> Result<T> success(String message, T data) {
    return Result.result(StatusCode.SUCCESS.getCode(), message, data);
  }
  
  
  /*
      成功
      查询成功等 需要携带数据
      需要 返回消息和数据
   */
  public static <T> Result<T> success(T data) {
    return Result.result(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), data);
  }
  
  /*
      失败
      根据失败清空封装
      请求失败不会携带数据
   */
  public static <T> Result<T> fail(Integer code, String message) {
    return Result.result(code, message, null);
  }
}
