package com.kgc.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kgc.demo.mapper")
public class MybatisConfig {
}
