package com.design.interceptor;

import com.design.common.CommonConst;
import com.design.common.StatusCode;
import org.springframework.web.servlet.HandlerInterceptor;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    
    // 不需要验证
    // NO_AUTH: YES
    String noAuth = request.getHeader("No_auth");
    if (StrUtil.isNotBlank(noAuth) && noAuth.equals("YES")) {
      return true;
    }
    
    response.setHeader("Content-Type", "application/json;charset=utf-8");
    String token = request.getHeader("Authorization");
    
    if (StrUtil.isBlank(token) || !token.startsWith("Bearer ")) {
      // 返回状态码为401
      response.getWriter().write("{\"code\":" + StatusCode.UNAUTHORIZED.getCode() + ",\"message\":\"" + StatusCode.UNAUTHORIZED.getMessage() + "\"}");
      return false;
    }
    
    // 将token去掉前缀
    token = token.substring(7);
    
    boolean verify = JWTUtil.verify(token, CommonConst.TOKEN_KEY.getBytes());
    JWTPayload payload = JWTUtil.parseToken(token).getPayload();
    
    if (!verify) {
      response.getWriter().write("{\"code\":" + StatusCode.UNAUTHORIZED.getCode() + ",\"message\":\"" + StatusCode.UNAUTHORIZED.getMessage() + "\"}");
      return false;
    }
    return true;
  }
}
