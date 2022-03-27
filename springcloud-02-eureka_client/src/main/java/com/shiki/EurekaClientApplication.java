package com.shiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //开启eureka的服务
public class EurekaClientApplication {
    public static void main(String[] args) {
      SpringApplication.run(EurekaClientApplication.class,args);
    }

}
