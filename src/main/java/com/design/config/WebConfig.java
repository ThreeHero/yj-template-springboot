package com.design.config;

import com.design.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Bean
  public TokenInterceptor TokenInterceptor() {
    return new TokenInterceptor();
  }
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(TokenInterceptor())
        .addPathPatterns("/**") // 拦截所有路径
        // 排除普通用户登录注册 管理员登录 网站配置 上传文件 和静态资源
        .excludePathPatterns("/admin/login", "/user/login", "/user/reg", "/upload/**");
  }
  
  /**
   * 静态资源映射
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
  }
}
