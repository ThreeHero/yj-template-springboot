package com.design.config;

import java.util.ArrayList;
import java.util.List;

import com.design.common.CommonConst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 */
@Configuration
public class CorsConfig {
  
  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    
    // 是否允许请求带有验证信息
    config.setAllowCredentials(true);
    List<String> allowedOriginPatterns = new ArrayList<>();
    allowedOriginPatterns.add("*");
    config.setAllowedOriginPatterns(allowedOriginPatterns);
    
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    
    config.setMaxAge(CommonConst.MAX_AGE);
    
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
