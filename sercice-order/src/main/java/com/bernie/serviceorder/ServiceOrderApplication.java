package com.bernie.serviceorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Bernie
 * @Date 2019/1/26 19:11
 **/
@EnableEurekaClient
@SpringBootApplication
public class ServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }

    @Bean
    @LoadBalanced   //做负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
