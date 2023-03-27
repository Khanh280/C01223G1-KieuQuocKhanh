package case_study_furama.services.person_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.person.Customer;
import case_study_furama.services.person_service.ICustomerService;
import case_study_furama.utils.ReadAndWriteDataCustomer;
import case_study_furama.utils.ReadAndWriteDataEmployee;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl extends Customer implements ICustomerService {
    static LinkedList<Customer> customers = new LinkedList<>();
    static Customer customer = new Customer();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addCustomer() {
        try {
            int count = 0;
            System.out.print("Nhập mã khách hàng: ");
            int horse = Integer.parseInt(scanner.nextLine());
            customers = ReadAndWriteDataCustomer.readFileToList();
            for (int i = 0; i < customers.size(); i++) {
                if (horse == customers.get(i).getHorse()) {
                    System.out.println("Mã khách hàng đã tồn tại: ");
                    return;
                } else {
                    count++;
                }
            }
            if (count == customers.size()) {
                System.out.print("Nhập tên: ");
                String name = scanner.nextLine();
                System.out.print("Nhập ngày sinh: ");
                String birthDay = scanner.nextLine();
                System.out.print("Nhâpj giới tính: ");
                String gender = scanner.nextLine();
                System.out.print("Nhập số CMND: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập số điện thoại: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Nhập email: ");
                String email = scanner.nextLine();
                System.out.println("Nhập loại khách hàng: " +
                        "\n1. Diamond" +
                        "\n2. Platinium" +
                        "\n3. Gold" +
                        "\n4. Silver" +
                        "\n5. Member");
                int chooseGuestType = Integer.parseInt(scanner.nextLine());
                String guestType = FuramaData.guestTypeList.get(chooseGuestType - 1);
                System.out.print("Nhập địa chỉ: ");
                String address = scanner.nextLine();
                customer = new Customer(horse, name, birthDay, gender, id, phoneNumber, email, guestType, address);
                customers.add(customer);
                ReadAndWriteDataCustomer.writeCustomerToFile(customers, false);
            }
        } catch (Exception e) {
            System.out.println("Mã khách hàng không hợp lệ.");
        }
    }

    @Override
    public void editCustomer() {
        try {
            int count = 0;
            System.out.print("Nhập mã khách hàng: ");
            int horse = Integer.parseInt(scanner.nextLine());
            customers = ReadAndWriteDataCustomer.readFileToList();
            for (int i = 0; i < customers.size(); i++) {
                if (horse == customers.get(i).getHorse()) {
                    System.out.print("Nhập tên: ");
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
                    System.out.println("Nhập loại khách hàng: " +
                            "\n1. Diamond" +
                            "\n2. Platinium" +
                            "\n3. Gold" +
                            "\n4. Silver" +
                            "\n5. Member");
                    int chooseGuestType = Integer.parseInt(scanner.nextLine());
                    String guestType = FuramaData.guestTypeList.get(chooseGuestType - 1);
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    customer = new Customer(horse, name, birthDay, gender, id, phoneNumber, email, guestType, address);
                    customers.set(i, customer);
                    ReadAndWriteDataCustomer.writeCustomerToFile(customers, false);
                    return;
                } else {
                    count++;
                }
                if (count == customers.size()) {
                    System.out.println("Mã khách hàng không tồn tại.");
                }
            }
        } catch (Exception e) {
            System.out.println("Mã khách hàng không tồn tại.");
        }
    }

    @Override
    public void displayListCustomer() {
        customers = ReadAndWriteDataCustomer.readFileToList();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i));
            ;
        }
    }

    @Override
    public void deleteCustomer() {
        try {
            int count = 0;
            System.out.println("Nhập mã khách hàng bạn muốn xóa: ");
            int horse = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < customers.size(); i++) {
                if (horse == customers.get(i).getHorse()) {
                    System.out.println("Bạn xác nhận xóa khách hàng " + customers.get(i).getName() +
                            "\n1. Yes." +
                            "\n2. No.");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            customers.remove(i);
                            System.out.println("Bạn đã xóa thành công khách hàng có mã: " + horse);
                            if (customers.size() == 0) {
                                ReadAndWriteDataCustomer.writeCustomerToFile(null, false);
                            } else {
                                ReadAndWriteDataCustomer.writeCustomerToFile(customers, false);
                            }
                            break;
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
                if (count == customers.size()) {
                    System.out.println("Mã khách hàng không tồn tại.");
                }
            }
        } catch (
                Exception e) {
            System.out.println("Mã khách hàng không tồn tại.");
        }
    }
}
