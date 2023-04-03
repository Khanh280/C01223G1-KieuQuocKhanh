package case_study_furama.services.person_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.person.Customer;
import case_study_furama.repository.impl_repository.CustomerRepository;
import case_study_furama.services.person_service.ICustomerService;
import case_study_furama.utils.CheckRegexService;
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

    @Override
    public void addCustomer() {
        String horse = CheckRegexService.checkHorse();
        int count = 0;
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
                                "\n7. Loại khách hàng" +
                                "\n8. Dịa chỉ" +
                                "\n0. Thoat" +
                                "\nChọn chức năng: ");
                        String choose = scanner.nextLine();
                        switch (choose) {
                            case "1":
                                customers.get(i).setName(scanner.nextLine());
                                break;
                            case "2":
                                customers.get(i).setBirthDay(scanner.nextLine());
                                break;
                            case "3":
                                customers.get(i).setGender(scanner.nextLine());
                                break;
                            case "4":
                                customers.get(i).setId(scanner.nextLine());
                                break;
                            case "5":
                                customers.get(i).setPhoneNumber(scanner.nextLine());
                                break;
                            case "6":
                                customers.get(i).setEmail(scanner.nextLine());
                                break;
                            case "7":
                                System.out.println("Nhập loại khách hàng: " +
                                        "\n1. Diamond" +
                                        "\n2. Platinium" +
                                        "\n3. Gold" +
                                        "\n4. Silver" +
                                        "\n5. Member" +
                                        "\nChọn: ");
                                int chooseGuestType = Integer.parseInt(scanner.nextLine());
                                customers.get(i).setGuestType(FuramaData.guestTypeList.get(chooseGuestType - 1));
                                break;
                            case "8":
                                customers.get(i).setAddress(scanner.nextLine());
                                break;
                            case "0":
                                flag = false;
                                break;
                            default:
                                System.out.println("Vui lòng chọn đúng thông tin muốn sửa.");
                        }
                        customerRepository.editCustomer(customers);
                    } while (flag);
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
