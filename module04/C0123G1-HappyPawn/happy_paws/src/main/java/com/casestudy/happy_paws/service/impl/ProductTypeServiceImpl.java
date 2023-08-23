package com.casestudy.happy_paws.service.impl;


import com.casestudy.happy_paws.model.ProductType;
import com.casestudy.happy_paws.repository.IProductTypeRepository;
import com.casestudy.happy_paws.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductTypeServiceImpl implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAllProductType();
    }

    @Override
    public boolean save(ProductType productType) {
        try {
            productTypeRepository.save(productType);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            productTypeRepository.deleteProductTypeById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public ProductType findById(Long id) {
        return productTypeRepository.findById(id).get();
    }
}
