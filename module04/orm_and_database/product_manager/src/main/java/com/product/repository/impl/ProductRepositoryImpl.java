package com.product.repository.impl;

import com.product.model.Product;
import com.product.repository.BaseRepository;
import com.product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    @Override
    public List<Product> getAll() {
        List<Product> productList = BaseRepository.entityManager.createQuery("select s from Product s", Product.class).getResultList();
        return productList;
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        Product product = BaseRepository.entityManager.find(Product.class,id);
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public Product getProductByCode(Integer id) {
        Product product = BaseRepository.entityManager.find(Product.class,id);
        return product;
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = BaseRepository.entityManager.createQuery("select s from Product s where s.name like :name", Product.class).setParameter("name",'%' +name+'%').getResultList();
        return productList;
    }
}
