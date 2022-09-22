package com.csci927.pandemicabootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/csci927/pandemicabootdemo/mapper")
public class PandemicaBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandemicaBootDemoApplication.class, args);
    }

}
