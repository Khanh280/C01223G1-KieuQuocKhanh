package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.dto.CustomerDTO;
import com.casestudy.happy_paws.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Page<Customer> getAllPage(int page);

    boolean save(Customer customer);

    Customer findById(Integer customerId);

    void update(Customer customer);

    void delete(Integer customerId);
    int getRandom(int min, int max) ;

    Page<Customer> findByCustomer(String name, String phone, String username, Pageable pageable);

    Page<Customer> findCustomer(String s, String s1,  Pageable pageable);
    Customer findCustomerByUserName(String userName);

    boolean checkCustomer(Customer customer);

}
