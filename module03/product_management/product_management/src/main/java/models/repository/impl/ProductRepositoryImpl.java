package models.repository.impl;

import models.model.Product;
import models.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Iphone X",10,"Mau vang"));
        productList.add(new Product(2,"Iphone 11 Pro",11,"Mau do"));
        productList.add(new Product(3,"Iphone 12 Pro Max",15,"Mau tim"));
        productList.add(new Product(4,"Iphone 14 Pro Max",35,"Mau xanh"));
    }


    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void saveProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void upDateProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if(product.getId() == productList.get(i).getId()){
                productList.set(i,product);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int idDelete) {
        for (int i = 0; i < productList.size(); i++) {
            if(idDelete == productList.get(i).getId()){
                productList.remove(i);
                break;
            }
        }
    }
}
