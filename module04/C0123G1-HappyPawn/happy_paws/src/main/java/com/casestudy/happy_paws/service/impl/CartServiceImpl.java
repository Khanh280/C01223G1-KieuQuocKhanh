package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Cart;
import com.casestudy.happy_paws.model.Product;
import com.casestudy.happy_paws.repository.ICartRepo;
import com.casestudy.happy_paws.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartRepo iCartRepo;

    @Override
    public List<Cart> getAll(Integer customerId) {
        return iCartRepo.getCartByCustomer(customerId);
    }


    @Override
    public void deleteCart(Long id) {
        iCartRepo.deleteById(id);
    }

    @Override
    public Cart findById(Long cartId) {
        return iCartRepo.findById(cartId).get();
    }

    @Override
    public void save(Cart cart1) {
        iCartRepo.save(cart1);
    }
    public Integer countProductQuantity() {
        List<Cart> carts = iCartRepo.findAll();
        Integer productQuantity = 0;
        for (Cart c : carts) {
            productQuantity += c.getQuantity();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(Integer customerId) {
//        List<Cart> carts = iCartRepo.findAll();
        return iCartRepo.countItemQuantity(customerId);
    }

    public Float countTotalPayment(Integer customerId) {
//        List<Cart> carts = iCartRepo.findAll();
//        float payment = 0;
//        for (Cart c : carts) {
//            payment += c.getProduct().getPrice() * (float) c.getQuantity();
//        }
        return iCartRepo.getTotalPricecart(customerId);
    }

    @Override
    public boolean payMentCart(Integer customerId) {
        try{
            iCartRepo.payMentCart(customerId);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
