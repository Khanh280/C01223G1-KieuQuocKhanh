package models.service;

import models.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer();

    boolean saveCustomer(Customer customer);

    boolean deleteCustomer(int id, int accountId);

    List<Customer> searchCustomer(String nameCustomer, String addressCustomer,String phoneNumber);

    Customer getCustomer(int id);

    boolean editCustomer(Customer customer);

    Customer getCustomerById(int id);
    Customer getCustomerById1(int id);
}
