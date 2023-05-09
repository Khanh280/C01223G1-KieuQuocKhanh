package models.service;

import models.model.Products;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IProductService {
    boolean addProduct(HttpServletRequest request, HttpServletResponse response);
    List<Products> getAll();
    void delete(int productId);
    void update(Products products);
}
