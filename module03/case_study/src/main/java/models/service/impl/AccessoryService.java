package models.service.impl;

import models.model.Product;
import models.repository.IAccessoryRepository;
import models.repository.Impl.AccessoryRepository;
import models.service.IAccessoryService;

import java.util.List;

public class AccessoryService implements IAccessoryService {
    private IAccessoryRepository accessoryRepository = new AccessoryRepository();

    @Override
    public List<Product> getList() {
        return accessoryRepository.getList();
    }

    @Override
    public Product findById(int id) {
        return accessoryRepository.findById(id);
    }

    @Override
    public boolean createAt(Product product) {
        return accessoryRepository.createAt(product);
    }

    @Override
    public boolean remove(int id) {
        return accessoryRepository.remove(id);
    }

    @Override
    public boolean edit(Product product) {
        return accessoryRepository.edit(product);
    }

    @Override
    public List<Product> search(String name, int startPrice, int endPrice) {
        return accessoryRepository.search(name, startPrice, endPrice);
    }

    @Override
    public List<Product> searchUser(String productName) {
        return accessoryRepository.searchUser(productName);
    }
}
