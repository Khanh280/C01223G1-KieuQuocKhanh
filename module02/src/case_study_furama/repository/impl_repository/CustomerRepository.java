package case_study_furama.repository.impl_repository;

import case_study_furama.models.person.Customer;
import case_study_furama.repository.ICustomerRepository;
import case_study_furama.utils.ReadAndWriteDataCustomer;
import case_study_furama.utils.ReadAndWriteDataEmployee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    static List<Customer> customers = new LinkedList<>();

    @Override
    public void addCustomer(List<Customer> customers) {
        ReadAndWriteDataCustomer.writeCustomerToFile(customers, false);
    }

    @Override
    public void editCustomer(List<Customer> customers) {
        ReadAndWriteDataCustomer.writeCustomerToFile(customers, false);
    }

    @Override
    public List<Customer> displayListCustomer() {
        customers = ReadAndWriteDataCustomer.readFileToList();
        return customers;
    }

    @Override
    public void deleteCustomer(List<Customer> customers) {
        if (customers.size() == 0) {
            ReadAndWriteDataCustomer.writeCustomerToFile(null, false);
        } else {
            ReadAndWriteDataCustomer.writeCustomerToFile(customers, false);
        }
    }
}
