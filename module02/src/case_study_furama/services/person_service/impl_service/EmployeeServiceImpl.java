package case_study_furama.services.person_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.person.Employee;
import case_study_furama.services.person_service.IEmployeeService;
import case_study_furama.utils.ReadAndWriteDataEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl extends Employee implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> employees = new ArrayList<>();
    static Employee employee = new Employee();

    @Override
    public void addEmployee() {
        try {
            int count = 0;
            System.out.print("Nhập mã nhân viên: ");
            int horse = Integer.parseInt(scanner.nextLine());
            employees = ReadAndWriteDataEmployee.readFileToList();
            for (int i = 0; i < employees.size(); i++) {
                if (horse == employees.get(i).getHorse()) {
                    System.out.println("Mã nhân viên đã tồn tại.");
                    return;
                } else {
                    count++;
                }
            }
            if (count == employees.size()) {
                System.out.print("Nhập tên : ");
                String name = scanner.nextLine();
                System.out.print("Nhập ngày sinh: ");
                String birthDay = scanner.nextLine();
                System.out.print("Nhập giới tính: ");
                String gender = scanner.nextLine();
                System.out.print("Nhập số CMND: ");
                int id = Integer.parseInt(scanner.nextLine());
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
                long salary = getSalary(chooseDegree, chooseLocation);
                employee = new Employee(horse, name, birthDay, gender, id, phoneNumber, email, degree, location, salary);
                employees.add(employee);
                ReadAndWriteDataEmployee.writeEmployeeToFile(employees, false);
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
            System.out.print("Nhập mã nhân viên: ");
            int horse = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < employees.size(); i++) {
                if (horse == employees.get(i).getHorse()) {
                    System.out.print("Nhập tên : ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập ngày sinh: ");
                    String birthDay = scanner.nextLine();
                    System.out.print("Nhập giới tính: ");
                    String gender = scanner.nextLine();
                    System.out.print("Nhập số CMND: ");
                    int id = Integer.parseInt(scanner.nextLine());
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
                    long salary = getSalary(chooseDegree, chooseLocation);
                    employee = new Employee(horse, name, birthDay, gender, id, phoneNumber, email, degree, location, salary);
                    employees.set(i, employee);
                    ReadAndWriteDataEmployee.writeEmployeeToFile(employees, false);
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
        employees = ReadAndWriteDataEmployee.readFileToList();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
    }

    @Override
    public void deleteEmployee() {
        try {
            System.out.print("Nhập mã nhân viên: ");
            int count = 0;
            int horse = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < employees.size(); i++) {
                if (horse == employees.get(i).getHorse()) {
                    System.out.println("Bạn xác nhận xóa nhân viên " + employees.get(i).getName() +
                            "\n1. Yes." +
                            "\n2. No.");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            employees.remove(i);
                            System.out.println("Bạn đã xóa thành công nhân viên có mã " + horse);
                            if (employees.size() == 0) {
                                ReadAndWriteDataEmployee.writeEmployeeToFile(null, false);
                            } else {
                                ReadAndWriteDataEmployee.writeEmployeeToFile(employees, false);
                            }
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
