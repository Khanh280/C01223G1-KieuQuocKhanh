package case_study_furama.repository.impl_repository;

import case_study_furama.models.person.Employee;
import case_study_furama.repository.IEmployeeRepository;
import case_study_furama.utils.ReadAndWriteDataEmployee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(List<Employee> employees) {
        ReadAndWriteDataEmployee.writeEmployeeToFile(employees, false);
    }

    @Override
    public void editEmployee(List<Employee> employees) {
        ReadAndWriteDataEmployee.writeEmployeeToFile(employees, false);
    }

    @Override
    public List<Employee> displayListEmployee() {
        employees = ReadAndWriteDataEmployee.readFileToList();
        return employees;
    }

    @Override
    public void deleteEmployee(List<Employee> employees) {
        if (employees.size() == 0) {
            ReadAndWriteDataEmployee.writeEmployeeToFile(null, false);
        } else {
            ReadAndWriteDataEmployee.writeEmployeeToFile(employees, false);
        }
    }
}
