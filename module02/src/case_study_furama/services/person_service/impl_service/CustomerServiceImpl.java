package case_study_furama.services.person_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.person.Customer;
import case_study_furama.repository.impl_repository.CustomerRepository;
import case_study_furama.services.person_service.ICustomerService;
import case_study_furama.utils.ReadAndWriteDataCustomer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerServiceImpl extends Customer implements ICustomerService {
    static List<Customer> customers = new LinkedList<>();
    static Customer customer = new Customer();
    static CustomerRepository customerRepository = new CustomerRepository();
    static Scanner scanner = new Scanner(System.in);
    static final String ID_REGEX = "^[0-9]+$";

    @Override
    public void addCustomer() {
        String horse;
        boolean checkId;
        int count = 0;
        do {
            System.out.print("Nhập mã khách hàng: ");
            horse = scanner.nextLine();
            checkId = Pattern.matches(ID_REGEX, horse);
            System.out.println(checkId ? "" : "Mã khách hàng không hợp lệ.");
        } while (!checkId);
        customers = ReadAndWriteDataCustomer.readFileToList();
        for (int i = 0; i < customers.size(); i++) {
            if (horse.equals(customers.get(i).getHorse())) {
                System.out.println("Mã khách hàng đã tồn tại: ");
                return;
            } else {
                count++;
            }
        }
        try {
            if (count == customers.size()) {
                System.out.print("Nhập tên: ");
                String name = scanner.nextLine();
                System.out.print("Nhập ngày sinh: ");
                String birthDay = scanner.nextLine();
                System.out.print("Nhâpj giới tính: ");
                String gender = scanner.nextLine();
                System.out.print("Nhập số CMND: ");
                String id = scanner.nextLine();
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
                customerRepository.addCustomer(customers);
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
            String horse = scanner.nextLine();
            customers = ReadAndWriteDataCustomer.readFileToList();
            for (int i = 0; i < customers.size(); i++) {
                if (horse.equals(customers.get(i).getHorse())) {
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập ngày sinh: ");
                    String birthDay = scanner.nextLine();
                    System.out.print("Nhập giới tính: ");
                    String gender = scanner.nextLine();
                    System.out.print("Nhập số CMND: ");
                    String id = scanner.nextLine();
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
                    customerRepository.editCustomer(customers);
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
        customers = customerRepository.displayListCustomer();
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
            String horse = scanner.nextLine();
            for (int i = 0; i < customers.size(); i++) {
                if (horse.equals(customers.get(i).getHorse())) {
                    System.out.println("Bạn xác nhận xóa khách hàng " + customers.get(i).getName() +
                            "\n1. Yes." +
                            "\n2. No.");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            customers.remove(i);
                            System.out.println("Bạn đã xóa thành công khách hàng có mã: " + horse);
                            customerRepository.deleteCustomer(customers);
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
