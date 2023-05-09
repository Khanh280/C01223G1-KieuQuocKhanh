package models.service.impl;

import models.repository.ICustomerRepository;
import models.repository.impl.CustomerRepositoryImpl;
import models.service.ICustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServiceImpl implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepositoryImpl();


    @Override
    public void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        customerRepository.saveCustomer(request,response);
    }

    @Override
    public boolean checkAccount(String userName, String password) {
        return customerRepository.checkAccount(userName, password);
    }
}
