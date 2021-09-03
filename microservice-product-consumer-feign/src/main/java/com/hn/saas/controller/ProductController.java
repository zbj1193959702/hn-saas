package com.hn.saas.controller;

import com.hn.saas.entities.Product;
import com.hn.saas.service.ProductClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by biji.zhao on 2021/8/30
 */
@RestController
public class ProductController {

    @Resource
    private ProductClientService productClientService;

    @RequestMapping(value = "/consumer/product/add")
    public boolean add(Product product) {
        return productClientService.add(product);
    }

    @GetMapping(value = "/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        return productClientService.get(id);
    }

    @GetMapping(value = "/consumer/product/list")
    public List<Product> list() {
        return productClientService.list();
    }

}
