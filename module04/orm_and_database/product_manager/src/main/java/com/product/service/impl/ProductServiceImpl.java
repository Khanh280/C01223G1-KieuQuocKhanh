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
    private static List<Product> productList = new ArrayList<>();
    static {
//        productList.add(new Product("IP12","Iphone 12 Pro Max","Mau vang",25d,"Apple"));
//        productList.add(new Product("IP11","Iphone 11 Pro Max","Mau vang",15d,"Apple"));
//        productList.add(new Product("IPX","Iphone X","Mau vang",30d,"Apple"));
//        productList.add(new Product("SS","SamSung s21 ultra","Mau trang",40d,"SamSung"));
//        productList.add(new Product("VV","Vivo Y21","Mau xanh",20d,"Vivo"));
    }
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
