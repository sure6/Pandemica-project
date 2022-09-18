package com.csci927.pandemicaconsumer;

import com.csci927.pandemicaapi.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class PandemicaConsumerApplication {

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(PandemicaConsumerApplication.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = context.getBean(OrderService.class);

        // Call the method to query the data
        orderService.initOrder("1");
        System.out.println("complete call...");
        System.in.read();;
    }


}
