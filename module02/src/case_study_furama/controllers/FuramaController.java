package case_study_furama.controllers;


import case_study_furama.services.facility_service.impl_service.FacilityServiceImpl;
import case_study_furama.services.person_service.impl_service.CustomerServiceImpl;
import case_study_furama.services.person_service.impl_service.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    static Scanner sc = new Scanner(System.in);
    static EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
    static CustomerServiceImpl customerServiceServiceImpl = new CustomerServiceImpl();
    static FacilityServiceImpl facilityServiceServiceImpl = new FacilityServiceImpl();

    public static void displayMainMenu() {
        boolean flag;
        do {
            flag = true;
            System.out.println("Select." +
                    "\n1. Employee Management" +
                    "\n2. Customer Management" +
                    "\n3. Facility Management" +
                    "\n4. Booking Management" +
                    "\n5. Promotion Management" +
                    "\n6. Exit");
            try {
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        employeeManagement();
                        break;
                    case 2:
                        customerManagement();
                        break;
                    case 3:
                        facilityManagement();
                        break;
                    case 4:
                        bookingManagement();
                        break;
                    case 5:
                        promotionManagement();
                        break;
                    case 6:
                        System.out.println("Exit........");
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Selection error...");
            }
        } while (flag);
    }

    public static void employeeManagement() {
        boolean flag;
        do {
            flag = true;
            System.out.println("List Employees." +
                    "\n1. Display list Employees" +
                    "\n2. Add new Employee" +
                    "\n3. Edit Employee" +
                    "\n4. Delete Employee" +
                    "\n5. Return main menu");
            try {
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("------------------------------FURAMA EMPLOYEE------------------------------");
                        employeeServiceImpl.displayListEmployee();
                        break;
                    case 2:
                        employeeServiceImpl.addEmployee();
                        break;
                    case 3:
                        employeeServiceImpl.editEmployee();
                        break;
                    case 4:
                        employeeServiceImpl.deleteEmployee();
                        break;
                    case 5:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Selection error...");
            }
        } while (flag);
    }

    public static void customerManagement() {
        boolean flag;
        do {
            flag = true;
            System.out.println("Customer Management" +
                    "\n1. Display list customers" +
                    "\n2. Add new customer" +
                    "\n3. Edit customer" +
                    "\n4. Delete customer" +
                    "\n5. Return main menu");
            try {
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("------------------------------FURAMA CUSTOMER------------------------------");
                        customerServiceServiceImpl.displayListCustomer();
                        break;
                    case 2:
                        customerServiceServiceImpl.addCustomer();
                        break;
                    case 3:
                        customerServiceServiceImpl.editCustomer();
                        break;
                    case 4:
                        customerServiceServiceImpl.deleteCustomer();
                        break;
                    case 5:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Selection error...");
            }
        } while (flag);
    }

    public static void facilityManagement() {
        boolean flag;
        do {
            flag = true;
            System.out.println("Facility Management " +
                    "\n1. Display list facility" +
                    "\n2. Add new facility" +
                    "\n3. Display list facility maintenance" +
                    "\n4. Return main menu");
            try {
                String choose = sc.nextLine();
                switch (choose) {
                    case "1":
                        facilityServiceServiceImpl.displayListFacility();
                        break;
                    case "2":
                        facilityServiceServiceImpl.addNewFacility();
                        break;
                    case "3":
                        facilityServiceServiceImpl.displayListFacilityMaintrnance();
                        break;
                    case "4":
                        flag = false;
                        break;
                    default:
                        System.out.println("Vui long chon lai.");
                }
            } catch (Exception e) {
                System.out.println("Selection error...");
            }
        } while (flag);
    }

    public static void bookingManagement() {
        boolean flag;
        do {
            flag = true;
            System.out.println("Booking Management " +
                    "\n1. Add new booking " +
                    "\n2. Display list booking" +
                    "\n3. Create new contract" +
                    "\n4. Display list contracts" +
                    "\n5. Edit contracts" +
                    "\n6. Return main menu");
            try {
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Selection error...");
            }
        } while (flag);
    }

    public static void promotionManagement() {
        boolean flag;
        do {
            flag = true;
            System.out.println("Promotion Management  " +
                    "\n1. Display list customers use service" +
                    "\n2. Display list customers get voucher" +
                    "\n3. Return main menu");
            try {
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Selection error...");
            }
        } while (flag);
    }
}
