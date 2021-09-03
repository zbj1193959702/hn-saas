package com.hn.saas.service;

import com.hn.saas.entities.Product;
import com.hn.saas.service.callback.ProductClientCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



/**
 * 指定调用的服务  microservice-product-provider
 */
@FeignClient(value = "microservice-product-provider", fallback = ProductClientCallBack.class)
public interface ProductClientService {

    /**
     * 注解不可省略 @PathVariable("id")
     */
    @GetMapping(value = "/product/get/{id}")
    Product get(@PathVariable("id")Long id);

    /**
     * 返回对象Product 必须有无参构造函数
     */
    @GetMapping(value = "/product/list")
    List<Product> list();

    @RequestMapping(value = "/product/add")
    boolean add(Product product);
}
