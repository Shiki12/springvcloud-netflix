package com.shiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsersApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class,args);
        System.out.println("git first");
        System.out.println("git first222");
        System.out.println("hot -fix");
        System.out.println("master test");
        System.out.println("hot -test");
        System.out.println("push test");
        System.out.println("online test");
        System.out.println("git test");

    }

}
