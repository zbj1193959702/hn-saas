package com.hn.saas.mapper;

import com.hn.saas.entities.Product;

import java.util.List;

/**
 * create by biji.zhao on 2021/8/30
 */
public interface ProductMapper {
    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);
}
