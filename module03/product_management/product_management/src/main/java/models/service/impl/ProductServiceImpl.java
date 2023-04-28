package models.service.impl;

import models.model.Product;
import models.repository.IProductRepository;
import models.repository.impl.ProductRepositoryImpl;
import models.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> getAll() {
        List<Product> productList = productRepository.getAll();
        return productList;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void upDateProduct(Product product) {
        productRepository.upDateProduct(product);
    }

    @Override
    public void deleteProduct(int idDelete) {
        productRepository.deleteProduct(idDelete);
    }


}
