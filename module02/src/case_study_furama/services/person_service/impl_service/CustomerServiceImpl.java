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
        System.out.print("Enter Horse: ");
        String horse = CheckRegexService.checkHorse();
        int count = 0;
        customers = ReadAndWriteDataCustomer.readFileToList();
        for (int i = 0; i < customers.size(); i++) {
            if (horse.equals(customers.get(i).getHorse())) {
                System.out.println("Customer Code already exists: ");
                return;
            } else {
                count++;
            }
        }
        try {
            if (count == customers.size()) {
                String name = CheckRegexService.checkName();
                String birthDay = CheckRegexService.checkBirthDay();
                System.out.print("Enter Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter ID: ");
                String id = scanner.nextLine();
                System.out.print("ENter Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.println("Enter a customer type: " +
                        "\n1. Diamond" +
                        "\n2. Platinium" +
                        "\n3. Gold" +
                        "\n4. Silver" +
                        "\n5. Member");
                int chooseGuestType = Integer.parseInt(scanner.nextLine());
                String guestType = FuramaData.guestTypeList.get(chooseGuestType - 1);
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();
                customer = new Customer(horse, name, birthDay, gender, id, phoneNumber, email, guestType, address);
                customers.add(customer);
                customerRepository.addCustomer(customers);
            }
        } catch (Exception e) {
            System.out.println("Invalid Customer Code.");
        }
    }

    @Override
    public void editCustomer() {
        int count = 0;
        System.out.print("Enter your customer code: ");
        String horse = scanner.nextLine();
        customers = ReadAndWriteDataCustomer.readFileToList();
        for (int i = 0; i < customers.size(); i++) {
            if (horse.equals(customers.get(i).getHorse())) {
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
                            "\n7. Type of customer" +
                            "\n8. Address" +
                            "\n0. Exit" +
                            "\nChoose: ");
                    String choose = scanner.nextLine();
                    try {
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
                                System.out.println("Enter a customer type: " +
                                        "\n1. Diamond" +
                                        "\n2. Platinium" +
                                        "\n3. Gold" +
                                        "\n4. Silver" +
                                        "\n5. Member" +
                                        "\nChoose: ");
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
                                System.out.println("Please select the correct information you want to correct.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid customer information please re-enter.");
                    }
                    customerRepository.editCustomer(customers);
                } while (flag);
                return;
            } else {
                count++;
            }
            if (count == customers.size()) {
                System.out.println("Customer Code does not exist.");
            }
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

        int count = 0;
        System.out.println("Enter the customer ID you want to remove: ");
        String horse = scanner.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (horse.equals(customers.get(i).getHorse())) {
                boolean flag;
                do {
                    flag = true;
                    System.out.println("You confirm customer deletion " + customers.get(i).getName() +
                            "\n1. Yes." +
                            "\n2. No.");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            customers.remove(i);
                            System.out.println("You've successfully removed a customer with code: " + horse);
                            customerRepository.deleteCustomer(customers);
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
            if (count == customers.size()) {
                System.out.println("Customer Code does not exist.");
            }
        }
    }
}
