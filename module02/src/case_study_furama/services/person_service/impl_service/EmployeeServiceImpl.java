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
        System.out.print("Nhập mã nhân viên: ");
        String horse = CheckRegexService.checkHorse();
        int count = 0;
        employees = ReadAndWriteDataEmployee.readFileToList();
        for (int i = 0; i < employees.size(); i++) {
            if (horse.equals(employees.get(i).getHorse())) {
                System.out.println("Mã nhân viên đã tồn tại.");
                return;
            } else {
                count++;
            }
        }
        try {
            if (count == employees.size()) {
                String name = CheckRegexService.checkName();
                String birthDay = CheckRegexService.checkBirthDay();
                System.out.print("Nhập giới tính: ");
                String gender = scanner.nextLine();
                System.out.print("Nhập số CMND: ");
                String id = scanner.nextLine();
                System.out.print("Nhập số điện thoại: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Nhập email: ");
                String email = scanner.nextLine();
                System.out.println("Chọn trình độ chuyên môn: " +
                        "\n1. Trung cấp." +
                        "\n2. Cao đẳng." +
                        "\n3. Đại học." +
                        "\n4. Sau đại học.");
                int chooseDegree = Integer.parseInt(scanner.nextLine());
                String degree = FuramaData.degreeList.get(chooseDegree - 1);
                System.out.println("Chọn vị trí: " +
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
            System.out.println("Thông tin nhân viên không hợp lệ vui lòng nhập lại.");
        }
    }

    public long getSalary(int chooseDegree, int chooseLocation) {
        // Chua co cong thuc tinh luong cu the
        return 0;
    }

    @Override
    public void editEmployee() {
        try {
            int count = 0;
            employees = employeeRepository.displayListEmployee();
            System.out.print("Nhập mã nhân viên: ");
            String horse = scanner.nextLine();
            for (int i = 0; i < employees.size(); i++) {
                if (horse.equals(employees.get(i).getHorse())) {
                    boolean flag;
                    do {
                        flag = true;
                        System.out.print("Chọn thông tin muốn sữa: " +
                                "\n1. Ten" +
                                "\n2. Ngay sinh" +
                                "\n3. Gioi tinh" +
                                "\n4. CMND" +
                                "\n5. So dien thoai" +
                                "\n6. Email" +
                                "\n7. Trinh do chuyen mon" +
                                "\n8. Vi tri" +
                                "\n9. Luong" +
                                "\n0. Thoat"+
                                "\nChọn chức năng: ");
                        String choose = scanner.nextLine();
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
                                System.out.print("Chọn trình độ chuyên môn: " +
                                        "\n1. Trung cấp." +
                                        "\n2. Cao đẳng." +
                                        "\n3. Đại học." +
                                        "\n4. Sau đại học."+
                                        "\nChọn trình độ: ");
                                int chooseDegree = Integer.parseInt(scanner.nextLine());
                                employees.get(i).setDegree(FuramaData.degreeList.get(chooseDegree - 1));
                                break;
                            case "8":
                                System.out.print("Chọn vị trí: " +
                                        "\n1. Lễ tân." +
                                        "\n2. Phục vụ." +
                                        "\n3. Chuyên viên." +
                                        "\n4. Giám sát." +
                                        "\n5. Quản lý." +
                                        "\n6. Giám đốc."+
                                        "\nChọn vị trí: ");
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
                                System.out.println("Vui lòng chọn đúng thông tin muốn sửa.");
                        }
                        employeeRepository.editEmployee(employees);
                    } while (flag);
                    return;
                } else {
                    count++;
                }
                if (count == employees.size()) {
                    System.out.println("Mã nhân viên không tồn tại.");
                }
            }
        } catch (Exception e) {
            System.out.println("Thông tin nhân viên không hợp lệ vui lòng nhập lại.");
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
        try {
            int count = 0;
            employees = employeeRepository.displayListEmployee();
            System.out.print("Nhập mã nhân viên: ");
            String horse = scanner.nextLine();
            for (int i = 0; i < employees.size(); i++) {
                if (horse.equals(employees.get(i).getHorse())) {
                    System.out.println("Bạn xác nhận xóa nhân viên " + employees.get(i).getName() + "\n1. Yes." + "\n2. No.");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            employees.remove(i);
                            System.out.println("Bạn đã xóa thành công nhân viên có mã " + horse);
                            employeeRepository.deleteEmployee(employees);
                            return;
                        case "2":
                            System.out.println("Bạn đã không xóa.");
                            break;
                        default:
                            System.out.println("Vui lòng chọn lại.");
                    }
                    return;
                } else {
                    count++;
                }
                if (count == employees.size()) {
                    System.out.println("Mã nhân viên không tồn tại.");
                }
            }
        } catch (Exception e) {
            System.out.println("Mã nhân viên không đúng.");
        }
    }
}
