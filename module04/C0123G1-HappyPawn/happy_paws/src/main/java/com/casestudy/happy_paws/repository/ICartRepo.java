package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ICartRepo extends JpaRepository<Cart,Long> {
    @Query(value = "select c from  Cart  c where c.customer.customerId = :customerId and c.pendingStatus = false")
    List<Cart> getCartByCustomer(@Param("customerId") Integer customerId);
    @Query(value = "update Cart  c set c.pendingStatus = true where c.customer.customerId = :customerId and c.pendingStatus = false")
    @Modifying
    @Transactional
    void payMentCart(@Param("customerId")Integer customerId);
    @Query(value = "select sum(c.quantity * c.product.price) from Cart c where c.customer.customerId = :customerId and c.pendingStatus = false")
    Float getTotalPricecart(@Param("customerId") Integer customerId);
    @Query(value = "select count(c.cartId) from Cart  c where c.customer.customerId = :customerId and c.pendingStatus = false")
    Integer countItemQuantity(@Param("customerId") Integer customerId);
}
