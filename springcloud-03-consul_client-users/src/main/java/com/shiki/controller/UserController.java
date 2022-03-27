package com.shiki.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class UserController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired  //负载均衡客户端对象
    LoadBalancerClient loadBalancerClient;

    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;

    @GetMapping("/user")
    public String demo(){

        //使用RestTemplate 模拟浏览器发送请求  请求地址是用户服务 用户服务使用的GetMapping 返回值是String
        // 所以这里使用 get 方式  并且 返回的类型是string.class
       /*   log.info("进入 User Demo.......");

          RestTemplate restTemplate = new RestTemplate();
          String result = restTemplate.getForObject("http://"+randomHost()+"/order", String.class);
        */

        /*
        * 使用 discoveryClient 事项
        * */


//        List<ServiceInstance> orders = discoveryClient.getInstances("ORDERS");//得到列表
//
//        orders.forEach(order ->  //打印列表
//        {
//            log.info("服务主机:{} 服务端口:{} ,服务主机 地址:{}",order.getHost(),order.getPort(),order.getUri());
//        });
//          //发送请求 得到结果
//        String result = new RestTemplate().getForObject(orders.get(0).getUri()+ "/order", String.class);
//
//
        /*
        *  使用LoadBalancerClient     使用负载均衡客户端对象 ，他已经做好负载均衡了
        * */
//        ServiceInstance orders1 = loadBalancerClient.choose("ORDERS");
//
//        log.info("服务主机:{} 服务端口:{} ,服务主机 地址:{}",orders1.getHost(),orders1.getPort(),orders1.getUri());
//        String result = new RestTemplate().getForObject(orders1.getUri()+ "/order", String.class);


/*
*
*   使用@LoadBalance注解  让当前的方法、对象 具有Ribbon 负载均衡的特性
* */
        String result = restTemplate.getForObject("http://ORDERS/order", String.class);

        return "ok------------>"+result;
    }

//利用随机数实现负载均衡，前提条件我们已知 所有的主机端口
    public  String  randomHost(){
        List<String> hosts =new ArrayList<>();
        hosts.add("localhost:8000");
        hosts.add("localhost:8002");
        int i = new Random().nextInt(hosts.size());
        return hosts.get(i);
    }
}
