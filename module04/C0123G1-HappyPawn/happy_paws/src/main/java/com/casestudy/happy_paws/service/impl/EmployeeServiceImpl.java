package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.model.Employee;
import com.casestudy.happy_paws.model.Role;
import com.casestudy.happy_paws.repository.IAccountRepository;
import com.casestudy.happy_paws.repository.IEmployeeRepo;
import com.casestudy.happy_paws.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Component
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepo iEmployeeRepo;
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return iEmployeeRepo.getAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepo.save(employee);
    }

    @Override
    public boolean delete(Long id) {
        try {
            iEmployeeRepo.deleteEmployee(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepo.findById(id).get();
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepo.save(employee);
    }

    @Override
    public Page<Employee> findEmployee(String name, String phone, Pageable pageable) {
        return iEmployeeRepo.findEmployeeB(name, phone, pageable);
    }

    @Transactional(rollbackOn = Throwable.class)
    @Override
    public boolean checkEmployee(Employee employee) {
        try {
            List<Employee> staffList = iEmployeeRepo.findAll();
            List<Account> users = iAccountRepository.findAll();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(employee.getAccount().getUsername())) {
                    return false;
                }
            }
            for (int i = 0; i < staffList.size(); i++) {
                if (staffList.get(i).getEmail().equals(employee.getEmail()) || staffList.get(i).getPhone().equals(employee.getPhone())) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkEditEmployee(Employee employee) {
        List<Employee> staffList = iEmployeeRepo.findAll();
        for (int i = 0; i < staffList.size(); i++) {
            if (employee.getEmployeeId() != staffList.get(i).getEmployeeId()) {
                if ((staffList.get(i).getEmail().equals(employee.getEmail()) || staffList.get(i).getPhone().equals(employee.getPhone()))) {
                    return false;
                }
            }
        }
        return true;
    }

}
