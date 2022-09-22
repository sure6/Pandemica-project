package com.csci927.pandemicabootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/registerSuccessfull.html").setViewName("index");
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(loginInterceptor);
        // Intercept path
        ir.addPathPatterns("/oauth/*");
        // Do not intercept paths
        List<String> irs = new ArrayList<String>();
        irs.add("/userAccount/*");
        irs.add("/index");

        ir.excludePathPatterns(irs);
    }

    //All CSS, JS,images, etc. go to the static path and everything else goes to templates
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
    }
}