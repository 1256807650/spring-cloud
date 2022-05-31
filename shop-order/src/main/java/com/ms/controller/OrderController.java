package com.ms.controller;

import com.alibaba.fastjson.JSON;
import com.ms.domain.Order;
import com.ms.domain.Product;
import com.ms.service.OrderService;
import com.ms.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//为了测试高并发，保留这个原始文件，但是把@RestController注掉
// @RestController
@Slf4j
public class OrderController {

    private RestTemplate restTemplate;
    private OrderService orderService;
    private DiscoveryClient discoveryClient;
    private ProductService productService;
    OrderController(RestTemplate restTemplate,OrderService orderService,DiscoveryClient discoveryClient,
                    ProductService productService){
        this.restTemplate=restTemplate;
        this.orderService=orderService;
        this.discoveryClient=discoveryClient;
        this.productService=productService;
    }
    //下单
    @RequestMapping("/placeOrder/{id}")
    public Order placeOrder(@PathVariable("id") Integer id){
        log.info("接收到id为{}的商品订单，接下来调用商品微服务查询商品信息",id);

        //调用商品微服务，查询商品信息
        //使用restTemplate写死的地址
        // Product product = restTemplate.getForObject("http://localhost:8081/selectProductById/"+id, Product.class);
        //直接使用服务提供者的第1个实例进行调用
        // List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        // ServiceInstance serviceInstance = instances.get(0);
        // Product product = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/selectProductById/"+id, Product.class);
        //利用rabbion来实现负载均衡的调用
        // String serverName="service-product";
        // Product product = restTemplate.getForObject("http://"+serverName+"/selectProductById/"+id, Product.class);
        //利用feign来实现远程调用
        Product product = productService.selectProductById(id);
        log.info("查询到商品信息：{}", JSON.toJSONString(product));
        //下单
        Order order= new Order();
        order.setUserId(1);
        order.setUsername("测试用户");
        order.setProductId(id);
        order.setProductName(product.getName());
        order.setProductPrice(product.getPrice());
        order.setNumber(1);
        Order order1=orderService.createOrder(order);
        log.info("下单成功：{}",JSON.toJSONString(order1));
        return order1;
    }
}
