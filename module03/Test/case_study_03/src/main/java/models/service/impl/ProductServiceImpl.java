package models.service.impl;

import models.model.Products;
import models.repository.IProductRepository;
import models.repository.impl.ProductRepositoryImpl;
import models.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public boolean addProduct(HttpServletRequest request, HttpServletResponse response) {
       return productRepository.addProduct(request,response);
    }

    @Override
    public List<Products> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void delete(int productId) {
        productRepository.delete(productId);
    }

    @Override
    public void update(Products products) {
         productRepository.update(products);
    }


}
