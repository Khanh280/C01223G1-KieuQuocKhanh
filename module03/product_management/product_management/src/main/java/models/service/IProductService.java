package models.service;

import models.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void saveProduct(Product product);
    void upDateProduct(Product product);
    void deleteProduct(int idDelete);
}
