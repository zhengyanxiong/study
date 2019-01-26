package com.bernie.servicemember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Bernie
 * @Date 2019/1/26 18:08
 **/
@SpringBootApplication
@EnableEurekaClient
public class ServiceMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMemberApplication.class, args);
    }
}
