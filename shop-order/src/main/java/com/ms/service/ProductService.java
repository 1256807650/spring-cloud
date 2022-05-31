package com.ms.service;

import com.ms.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//value 指定调用service的名称
@FeignClient(value = "service-product")
public interface ProductService {
    //FeignClient 的 value 值加上 RequestMapping 的值，就是一个完整的请求地址
    //"http://"+serverName+"/selectProductById/"+id
    //指定请求的URI部分
    @RequestMapping("/selectProductById/{id}")
    Product selectProductById(@PathVariable("id")Integer id);
}
