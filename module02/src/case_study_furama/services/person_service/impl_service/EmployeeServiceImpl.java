package case_study_furama.services.person_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.person.Employee;
import case_study_furama.repository.impl_repository.EmployeeRepositoryImpl;
import case_study_furama.services.person_service.IEmployeeService;
import case_study_furama.utils.CheckRegexService;
import case_study_furama.utils.ReadAndWriteDataEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeServiceImpl extends Employee implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> employees = new ArrayList<>();
    static Employee employee = new Employee();
    static EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();


    @Override
    public void addEmployee() {
        System.out.print("Enter Employee Code: ");
        String horse = CheckRegexService.checkHorse();
        int count = 0;
        employees = ReadAndWriteDataEmployee.readFileToList();
        for (int i = 0; i < employees.size(); i++) {
            if (horse.equals(employees.get(i).getHorse())) {
                System.out.println("Employee code already exists.");
                return;
            } else {
                count++;
            }
        }
        try {
            if (count == employees.size()) {
                String name = CheckRegexService.checkName();
                String birthDay = CheckRegexService.checkBirthDay();
                System.out.print("Enter Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.println("Choose Gegree: " +
                        "\n1. Trung cấp." +
                        "\n2. Cao đẳng." +
                        "\n3. Đại học." +
                        "\n4. Sau đại học.");
                int chooseDegree = Integer.parseInt(scanner.nextLine());
                String degree = FuramaData.degreeList.get(chooseDegree - 1);
                System.out.println("Choose Location: " +
                        "\n1. Lễ tân." +
                        "\n2. Phục vụ." +
                        "\n3. Chuyên viên." +
                        "\n4. Giám sát." +
                        "\n5. Quản lý." +
                        "\n6. Giám đốc.");
                int chooseLocation = Integer.parseInt(scanner.nextLine());
                String location = FuramaData.locationList.get(chooseLocation - 1);
                String salary = String.valueOf(getSalary(chooseDegree, chooseLocation));
                employee = new Employee(horse, name, birthDay, gender, id, phoneNumber, email, degree, location, salary);
                employees.add(employee);
                employeeRepository.addEmployee(employees);
            }
        } catch (Exception e) {
            System.out.println("Invalid employee information please re-enter.");
        }
    }

    public long getSalary(int chooseDegree, int chooseLocation) {
        // Chua co cong thuc tinh luong cu the
        return 0;
    }

    @Override
    public void editEmployee() {
        int count = 0;
        employees = employeeRepository.displayListEmployee();
        System.out.print("Enter Employee Code: ");
        String horse = scanner.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (horse.equals(employees.get(i).getHorse())) {
                boolean flag;
                do {
                    flag = true;
                    System.out.print("Select the information you want to edit: " +
                            "\n1. Name" +
                            "\n2. Birth Day" +
                            "\n3. Gender" +
                            "\n4. ID" +
                            "\n5. Phone Number" +
                            "\n6. Email" +
                            "\n7. Degrre" +
                            "\n8. Location" +
                            "\n9. Salary" +
                            "\n0. Exit" +
                            "\nEnter choose: ");
                    String choose = scanner.nextLine();
                    try {
                        switch (choose) {
                            case "1":
                                employees.get(i).setName(CheckRegexService.checkName());
                                break;
                            case "2":
                                employees.get(i).setBirthDay(scanner.nextLine());
                                break;
                            case "3":
                                employees.get(i).setGender(scanner.nextLine());
                                break;
                            case "4":
                                employees.get(i).setId(scanner.nextLine());
                                break;
                            case "5":
                                employees.get(i).setPhoneNumber(scanner.nextLine());
                                break;
                            case "6":
                                employees.get(i).setEmail(scanner.nextLine());
                                break;
                            case "7":
                                System.out.print("Choose Degree: " +
                                        "\n1. Trung cấp." +
                                        "\n2. Cao đẳng." +
                                        "\n3. Đại học." +
                                        "\n4. Sau đại học." +
                                        "\nEnter choose: ");
                                int chooseDegree = Integer.parseInt(scanner.nextLine());
                                employees.get(i).setDegree(FuramaData.degreeList.get(chooseDegree - 1));
                                break;
                            case "8":
                                System.out.print("Choose Location: " +
                                        "\n1. Lễ tân." +
                                        "\n2. Phục vụ." +
                                        "\n3. Chuyên viên." +
                                        "\n4. Giám sát." +
                                        "\n5. Quản lý." +
                                        "\n6. Giám đốc." +
                                        "\nEnter choose: ");
                                int chooseLocation = Integer.parseInt(scanner.nextLine());
                                employees.get(i).setLocation(FuramaData.locationList.get(chooseLocation - 1));
                                break;
                            case "9":
                                employees.get(i).setSalary(scanner.nextLine());
                                break;
                            case "0":
                                flag = false;
                                break;
                            default:
                                System.out.println("Please select the correct information you want to correct.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid employee information please re-enter.");
                    }
                    employeeRepository.editEmployee(employees);
                } while (flag);
                return;
            } else {
                count++;
            }
            if (count == employees.size()) {
                System.out.println("Employee Code doesn't exist.");
            }
        }
    }

    @Override
    public void displayListEmployee() {
        employees = employeeRepository.displayListEmployee();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
    }

    @Override
    public void deleteEmployee() {
        int count = 0;
        employees = employeeRepository.displayListEmployee();
        System.out.print("Enter Employee Code: ");
        String horse = scanner.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (horse.equals(employees.get(i).getHorse())) {
                boolean flag;
                do {
                    flag = true;
                    System.out.println("You confirm the employee's deletion " + employees.get(i).getName() + "\n1. Yes." + "\n2. No.");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            employees.remove(i);
                            System.out.println("You've successfully removed the employee whose code " + horse);
                            employeeRepository.deleteEmployee(employees);
                            return;
                        case "2":
                            System.out.println("You didn't delete.");
                            break;
                        default:
                            flag = false;
                            System.out.println("Please select again.");
                    }
                } while (!flag);
                return;
            } else {
                count++;
            }
            if (count == employees.size()) {
                System.out.println("Employee Code doesn't exist.");
            }
        }
    }
}
