package com.shiki.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrdersController {

    @Value("${server.port}")
    private  int port;

    @GetMapping("/order")
    public String demo(){
        log.info("==========>OrdersController");
        return "进入了Order demo,当前提供的端口为--->"+port;
    }
}
