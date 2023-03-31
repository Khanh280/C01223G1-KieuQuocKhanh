package case_study_furama.repository;

import case_study_furama.models.person.Customer;
import case_study_furama.models.person.Employee;

import java.util.List;

public interface ICustomerRepository {
    void addCustomer(List<Customer> customers);
    void editCustomer(List<Customer> customers);
    List<Customer> displayListCustomer();
    void deleteCustomer( List<Customer> customers);
}
