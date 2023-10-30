package com.design.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import com.design.common.CommonConst;

import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtils {
  /*
     生成token方法
    */
  public static String createToken(String username) {
    
    // 计算token过期时间
    // 当前时间
    Date date = DateUtil.date();
    // 将当前时间 + 过期时间
    Date expiresAt = DateUtil.offsetSecond(date, (int) CommonConst.TOKEN_EXPIRE);
    
    return JWT.create()
        .setPayload("username", username)
        .setExpiresAt(expiresAt)
        .setKey(CommonConst.TOKEN_KEY.getBytes())
        .sign();
  }
}
