package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void create(Product product);
    void delete(Integer id);
    Product getProductByCode(Integer id);
    void update(Product product);
    List<Product> search(String name);
}
