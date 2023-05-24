package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void create(Product product);
    void delete(Integer id);
    Product getProductByCode(Integer id);
    void update(Product product);
    List<Product> search(String name);


}
