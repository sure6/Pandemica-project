package com.csci927.pandemicaprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class PandemicaProviderApplication {

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(PandemicaProviderApplication.class, args);
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();
        System.in.read();
    }

}
