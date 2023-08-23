package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "update product set is_delete = true where id=:id", nativeQuery = true)
    @Modifying
    @Transactional
    void deletebyId(@Param("id") Long id);

    @Query(value = "select p from Product p where p.isDelete = false")
    Page<Product> findAllProduct(Pageable pageable);

    @Query(value = "select p from Product p where p.name like :name and p.origin like :origin and p.productType.nameTypeProduct like :nameProductType and p.isDelete=false ")
    Page<Product> findByNameAndOrigin(@Param("name") String name,@Param("origin") String origin,@Param("nameProductType") String nameProductType,Pageable pageable);
}

