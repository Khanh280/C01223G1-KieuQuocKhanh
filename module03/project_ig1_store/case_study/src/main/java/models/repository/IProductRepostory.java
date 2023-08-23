package models.repository;


import models.model.Product;

import java.util.List;

public interface IProductRepostory {
    List<Product> getList();

    Product findByID(int id);

    boolean createAt(Product product);

    boolean remove(int id);

    boolean edit(Product product);

    List<Product> search(String name, int startPrice, int endPrice);
    List<Product> searchUser(String productName);

}
