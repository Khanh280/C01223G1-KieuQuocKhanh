package io_binary_file.product_manager.repository;

import io_binary_file.product_manager.models.Product;

import java.util.List;

public interface IProductRepository {

    void add(List<Product> productList);

    List<Product> display();

    void search(String nameProduct);
}
