package com.csci927.pandemicavaccinebooking;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
@MapperScan(basePackages = "com/csci927/pandemicavaccinebooking/mapper")
public class PandemicaVaccinebookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandemicaVaccinebookingApplication.class, args);
    }

}
