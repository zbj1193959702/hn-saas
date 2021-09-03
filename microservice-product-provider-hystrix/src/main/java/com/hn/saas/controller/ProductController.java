package com.hn.saas.controller;

import com.hn.saas.entities.Product;
import com.hn.saas.exception.BusinessException;
import com.hn.saas.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by biji.zhao on 2021/8/30
 */

@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping(value = "/product/add")
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    /**
     * 服务端熔断
     * 注解：@HystrixCommand
     * 当get方法出现异常时，则会调用fallbackMethod指定的方法处理
     */
    @HystrixCommand(fallbackMethod = "getFallback")
    @GetMapping(value = "/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        // 模拟异常
        Product product = productService.get(id);
        if(product == null) {
            throw new BusinessException("ID=" + id + "无效");
        }
        return productService.get(id);
    }

    // 当get方法出现异常时，则会调用此方法. 注意此方法的返回值，参数列表与原方法一致
    public Product getFallback(@PathVariable("id") Long id) {
        return new Product(id, "ID=" + id + "无效--提供者：@HystrixCommand return", "无有效数据库");
    }

    @GetMapping(value = "/product/list")
    public List<Product> list() {
        return productService.list();
    }

}
