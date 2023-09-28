package models.service.impl;

import models.model.Product;
import models.repository.IProductRepostory;
import models.repository.Impl.ProductRepository;
import models.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepostory productRepostory=new ProductRepository();
    @Override
    public List<Product> getList() {
        return productRepostory.getList();
    }

    @Override
    public Product findById(int id) {
        return productRepostory.findByID(id);
    }

    @Override
    public boolean createAt(Product product) {
        return productRepostory.createAt(product);
    }

    @Override
    public boolean remove(int id) {
        return productRepostory.remove(id);
    }

    @Override
    public boolean edit(Product product) {
        return productRepostory.edit(product);
    }

    @Override
    public List<Product> search(String name, int startPrice, int endPrice) {
        return productRepostory.search(name, startPrice, endPrice);
    }

    @Override
    public List<Product> searchUser(String productName) {
        return productRepostory.searchUser(productName);
    }
}
