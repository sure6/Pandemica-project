package com.csci927.pandemicaregistration;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@MapperScan(basePackages = "com/csci927/pandemicaregistration/mapper")
@SpringBootApplication
public class PandemicaRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandemicaRegistrationApplication.class, args);
    }

}
