package models.service.impl;

import models.model.Customer;
import models.repository.ICustomerRepository;
import models.repository.Impl.CustomerRepositoryImpl;
import models.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepositoryImpl();


    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList= customerRepository.getAllCustomer();
        return customerList;
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id, int accountId) {
        return customerRepository.deleteCustomer(id,accountId);
    }

    @Override
    public List<Customer> searchCustomer(String nameCustomer,String addressCustomer,String phoneNumber) {
        return customerRepository.searchCustomer(nameCustomer,addressCustomer,phoneNumber);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return customerRepository.editCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public Customer getCustomerById1(int id) {
        return customerRepository.getCustomerById1(id);
    }
}
