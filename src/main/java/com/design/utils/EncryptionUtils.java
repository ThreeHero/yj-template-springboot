package com.design.utils;

import cn.hutool.crypto.SecureUtil;

public class EncryptionUtils {
  /*
   md5加密
  */
  public static String md5(String s) {
    return SecureUtil.md5(s);
  }
}
