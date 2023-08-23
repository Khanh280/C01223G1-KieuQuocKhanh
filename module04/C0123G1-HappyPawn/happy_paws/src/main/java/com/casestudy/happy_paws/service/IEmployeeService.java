package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> getAll(Pageable pageable);
    void save(Employee employee);
    boolean delete (Long id);
    Employee findById(Long id);
    void update(Employee employee);
    Page<Employee> findEmployee(String name , String phone,Pageable pageable);
    boolean checkEmployee(Employee employee);
    boolean checkEditEmployee(Employee employee);
}
