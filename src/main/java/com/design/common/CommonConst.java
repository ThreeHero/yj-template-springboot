package com.design.common;

import org.springframework.beans.factory.annotation.Value;

public class CommonConst {
  
  @Value("${spring.application}")
  private static String appName;
  /**
   * Token过期时间：10天 864000
   */
  public static final long TOKEN_EXPIRE =  10 * 24 * 60 * 60;
  
  /**
   * 跨域时长配置
   */
  public static final long MAX_AGE = 24 * 60 * 60;
  
  
  /**
   * Token密钥
   */
  public static final String TOKEN_KEY = "yj";
  
}
