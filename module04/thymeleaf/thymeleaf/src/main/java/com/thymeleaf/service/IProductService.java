package com.thymeleaf.service;

import com.thymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void create(Product product);
    void delete(String codeProduct);
    Product getProductByCode(String codeProduct);
    void update(Product product);
    List<Product> search(String name);
}
