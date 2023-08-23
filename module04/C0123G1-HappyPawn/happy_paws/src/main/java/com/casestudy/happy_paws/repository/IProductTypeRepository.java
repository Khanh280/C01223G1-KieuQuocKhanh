package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
    @Query(value = "update product_type set is_delete=true where id= :id", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteProductTypeById(@Param("id") Long id);
    @Query(value = "select p from ProductType p where p.isDelete=false ")
    List<ProductType> findAllProductType();
}
