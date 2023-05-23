package com.thymeleaf.service.impl;

import com.thymeleaf.model.Product;
import com.thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product("IP12","Iphone 12 Pro Max","Mau vang",25d,"Apple"));
        productList.add(new Product("IP11","Iphone 11 Pro Max","Mau vang",15d,"Apple"));
        productList.add(new Product("IPX","Iphone X","Mau vang",30d,"Apple"));
        productList.add(new Product("SS","SamSung s21 ultra","Mau trang",40d,"SamSung"));
        productList.add(new Product("VV","Vivo Y21","Mau xanh",20d,"Vivo"));
    }
    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void delete(String codeProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if(codeProduct.equals(productList.get(i).getCodeProduct())){
                productList.remove(productList.get(i));
                break;
            }
        }
    }

    @Override
    public Product getProductByCode(String codeProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if(codeProduct.equals(productList.get(i).getCodeProduct())){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if(product.getCodeProduct().equals(productList.get(i).getCodeProduct())){
                productList.set(i,product);
                break;
            }
        }
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productsListSearch = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                productsListSearch.add(productList.get(i));
            }
        }
        return productsListSearch ;
    }
}
