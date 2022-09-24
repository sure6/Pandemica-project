package com.cscsi927.pandemicahome;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@SpringBootApplication
public class PandemicaHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandemicaHomeApplication.class, args);
    }

}
