package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.Employee;
import com.casestudy.happy_paws.repository.IAccountRepository;
import com.casestudy.happy_paws.repository.ICustomerRepository;
import com.casestudy.happy_paws.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getAllPage(int page) {
        return customerRepository.findAllCustomer(PageRequest.of(page, 5,Sort.by("createTime").descending()));
    }


    @Transactional(rollbackOn = Throwable.class)
    @Override
    public boolean save(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer findById(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer customerId) {
        customerRepository.deleteByIdCustomer(customerId);
    }

    public int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public Page<Customer> findByCustomer(String name, String phone, String username, Pageable pageable) {
        return customerRepository.findByCustomer(name, phone, username, pageable);

    }

    @Override
    public Page<Customer> findCustomer(String s, String s1, Pageable pageable) {
        return customerRepository.findCustomerToBookService(s,s1,pageable);
    }

    @Override
    public Customer findCustomerByUserName(String userName) {
        return customerRepository.findCustomerByUserName(userName);
    }
    @Transactional(rollbackOn = Throwable.class)

    @Override
    public boolean checkCustomer(Customer customer) {
            try {
                List<Customer> customers = customerRepository.findAll();
                List<Account> accounts = accountRepository.findAllAccounts();
//                for (int i = 0; i < accounts.size(); i++) {
//                    if (accounts.get(i).getUsername().equals(customer.getAccount().getUsername())) {
//                        return false;
//                    }
//                }
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getEmail().equals(customer.getEmail()) || customers.get(i).getPhone().equals(customer.getPhone())) {
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }
            return true;
        }


}

