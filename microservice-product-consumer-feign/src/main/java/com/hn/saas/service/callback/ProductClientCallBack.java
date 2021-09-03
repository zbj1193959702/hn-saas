package com.hn.saas.service.callback;

import com.hn.saas.entities.Product;
import com.hn.saas.service.ProductClientService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 客户端 即 消费者 的熔断机制
 */
@Component
public class ProductClientCallBack implements ProductClientService {
    @Override
    public Product get(Long id) {
        return new Product(id, "id="+ id + "服务无响应--ProductClientCallBack return", "无有效数据库");
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return false;
    }
}
