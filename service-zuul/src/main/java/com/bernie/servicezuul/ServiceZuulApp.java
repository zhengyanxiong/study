package com.bernie.servicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Bernie
 * @Date 2019/1/26 22:19
 **/
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApp.class, args);
    }
}
