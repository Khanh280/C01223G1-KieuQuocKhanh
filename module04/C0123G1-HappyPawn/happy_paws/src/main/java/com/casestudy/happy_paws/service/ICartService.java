package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Cart;
import com.casestudy.happy_paws.model.Employee;
import com.casestudy.happy_paws.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICartService {
    List<Cart> getAll(Integer customerId);

    void deleteCart(Long id);

    Cart findById(Long cartId);

    void save(Cart cart1);
    Integer countProductQuantity();
    Integer countItemQuantity(Integer customerId);
    Float countTotalPayment(Integer customerId);
    boolean payMentCart(Integer customerId);
}
