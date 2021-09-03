package com.hn.saas.service;

import com.hn.saas.entities.Product;

import java.util.List;

/**
 * create by biji.zhao on 2021/8/30
 */
public interface ProductService {

    boolean add(Product product);

    Product get(Long id);

    List<Product> list();
}
