package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Product;
import com.casestudy.happy_paws.repository.IProductRepository;
import com.casestudy.happy_paws.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAllProduct(pageable);
    }

    @Override
    public boolean save(Product product) {
        try {
            productRepository.save(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            productRepository.deletebyId(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Page<Product> search(String name, String origin,String nameProductType,Pageable pageable) {
        return productRepository.findByNameAndOrigin(name,origin,nameProductType,pageable);
    }
}
