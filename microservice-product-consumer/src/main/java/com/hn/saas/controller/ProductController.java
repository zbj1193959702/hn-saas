package com.hn.saas.controller;

import cn.hutool.core.util.BooleanUtil;
import com.hn.saas.entities.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by biji.zhao on 2021/8/30
 */
@RestController
public class ProductController {

//    private static final String REST_URL_PREFIX = "http://localhost:8001";

    /**
     * Instances currently registered with Eureka
     * http://eureka6002.com:6002/          MICROSERVICE-PRODUCT-PROVIDER
     *
     * 修改为eureka注册中心的地址(好像是不区分大小写)
     */
    private static final String REST_URL_PREFIX = "http://microservice-product-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/product/add")
    public boolean add(Product product) {
        return BooleanUtil.isTrue(
                restTemplate.postForObject(REST_URL_PREFIX + "/product/add", product, Boolean.class)
        );
    }

    @GetMapping(value = "/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/product/get/" + id, Product.class);
    }

    @GetMapping(value = "/consumer/product/list")
    public List<Product> list() {
        return restTemplate.exchange(REST_URL_PREFIX + "/product/list", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {}).getBody();
    }

}
