package com.csci927.pandemicamentalhealth;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@MapperScan(basePackages = "com/csci927/pandemicamentalhealth/mapper")
@SpringBootApplication
public class PandemicaMentalhealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandemicaMentalhealthApplication.class, args);
    }

}
