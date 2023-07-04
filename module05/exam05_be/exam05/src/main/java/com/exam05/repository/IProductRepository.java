package com.exam05.repository;

import com.exam05.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select p from Product p")
    List<Product> findAllProduct();
}
