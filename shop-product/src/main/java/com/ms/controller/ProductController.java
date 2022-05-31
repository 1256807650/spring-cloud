package com.ms.controller;

import com.ms.domain.Product;
import com.ms.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    private ProductService productService;
    ProductController(ProductService productService){
        this.productService=productService;
    }
    //商品信息查询
    @RequestMapping("/selectProductById/{id}")
    public Product selectProductById(@PathVariable("id")Integer id){
        log.info("接下来进行id为{}的商品信息查询！！！",id);
        return productService.findById(id);
    }
}
