package com.ms.controller;

import com.alibaba.fastjson.JSON;
import com.ms.domain.Order;
import com.ms.domain.Product;
import com.ms.service.OrderService;
import com.ms.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//sentinel测试用
@RestController
@Slf4j
public class OrderController3 {
    //单纯的返回一个字符串
    @RequestMapping("/order/message1")
    public String message1(){
        log.info("接收到发送消息的接口1");
        return "message1";
    }
    //单纯的返回一个字符串
    @RequestMapping("/order/message2")
    public String message2(){
        log.info("接收到发送消息的接口2");
        return "message2";
    }
}
