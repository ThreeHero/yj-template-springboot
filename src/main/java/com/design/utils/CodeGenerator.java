package com.design.utils;

import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 代码生成器
 */
public class CodeGenerator {
  
  public static void main(String[] args) {
    String dbName = "template"; // 数据库名称
    String url = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    String username = "root"; // 用户名
    String password = "admin123"; // 密码
    String author = "ThreeHero"; // 作者
    
    FastAutoGenerator.create(url, username, password)
        // 全局配置
        .globalConfig(config -> {
          config.author(author) // 设置作者
              .disableOpenDir()   // 禁止打开输出目录 默认值:true
              .commentDate("yyyy-MM-dd") // 注释日期
              .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期类型 DateType.ONLY_DATE 默认值: DateType.TIME_PACK
              .outputDir(System.getProperty("user.dir") + "/src/main/java")// 指定输出目录
          ;
        })
        // 包配置
        .packageConfig(config -> {
          config.parent("com.design") // 父包名
              .entity("entity")
              .service("service")
              .serviceImpl("service.impl")
              .mapper("mapper")
              .xml("mapper.xml")
              .controller("controller");
        })
        // 策略配置
        .strategyConfig(config -> {
          config.entityBuilder()
                  .enableLombok() // 启用lombok
                  .enableTableFieldAnnotation()
                  .logicDeleteColumnName("is_deleted") // 逻辑删除数据库字段
                  .idType(IdType.AUTO); // 主键策略
          config.mapperBuilder()
              .superClass(BaseMapper.class) // mapper 继承类
              .enableMapperAnnotation() // 启用 @Mapper 注解
              .enableBaseResultMap()
              .enableBaseColumnList();
          config.controllerBuilder()
              .enableRestStyle(); // 开启 @RestController 注解
          config.serviceBuilder()
              .superServiceClass(IService.class)
              .superServiceImplClass(ServiceImpl.class);
        })
        .templateConfig(config -> {
          config.disable(TemplateType.ENTITY)
              .entity("/templates/entity.java")
              .service("/templates/service.java")
              .serviceImpl("/templates/serviceImpl.java")
              .mapper("/templates/mapper.java")
              .controller("/templates/controller.java");
        
        })
        .injectionConfig(config -> {
        
        })
        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        .execute();
    
  }
}
