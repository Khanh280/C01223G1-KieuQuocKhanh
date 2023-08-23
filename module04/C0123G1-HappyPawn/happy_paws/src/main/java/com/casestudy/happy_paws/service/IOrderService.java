package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.dto.OrderDTO;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.Orders;
import com.casestudy.happy_paws.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    Page<OrderDTO> findAllOrder();
    Page<Orders> findAll(Pageable pageable);
    Page<Customer> findAllCustomer(Pageable pageable);
    boolean saveOrder(Orders orders);
    Page<Orders> searchByNameAndPhone(String name, String phone,Pageable pageable);
    Page<Customer> searchCustomerByNameAndPhone(String name, String phone,Pageable pageable);
    Page<Product> searchProductByNameAndPrice(String name, Integer chosePrice, Pageable pageable);
}
