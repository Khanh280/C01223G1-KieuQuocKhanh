package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.ProductType;

import java.util.List;

public interface IProductTypeService {
   List<ProductType> findAll();
   boolean save(ProductType productType);
   boolean deleteById(Long id);
   ProductType findById(Long id);
}

