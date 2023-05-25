package com.product.service.impl;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void delete(Integer id) {
       productRepository.delete(id);
    }

    @Override
    public Product getProductByCode(Integer id) {
       Product product = productRepository.getProductByCode(id);
        return product;
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = productRepository.search(name);
        return productList ;
    }
}
