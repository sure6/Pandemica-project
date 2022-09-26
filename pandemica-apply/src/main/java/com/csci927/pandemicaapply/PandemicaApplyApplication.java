package com.csci927.pandemicaapply;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@MapperScan(basePackages = "com/csci927/pandemicaapply/mapper")
@SpringBootApplication
public class PandemicaApplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandemicaApplyApplication.class, args);
    }

}
