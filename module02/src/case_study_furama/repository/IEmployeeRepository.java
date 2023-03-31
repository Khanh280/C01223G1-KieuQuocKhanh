package case_study_furama.repository;

import case_study_furama.models.person.Employee;

import java.util.List;

public interface IEmployeeRepository {
    void addEmployee(List<Employee> employees);
    void editEmployee(List<Employee> employees);
    List<Employee> displayListEmployee();
    void deleteEmployee( List<Employee> employees);
}
