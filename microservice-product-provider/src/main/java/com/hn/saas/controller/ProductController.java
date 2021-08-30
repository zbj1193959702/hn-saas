package com.hn.saas.controller;

import com.hn.saas.entities.Product;
import com.hn.saas.service.ProductService;
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

    @GetMapping(value = "/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @GetMapping(value = "/product/list")
    public List<Product> list() {
        return productService.list();
    }

}
