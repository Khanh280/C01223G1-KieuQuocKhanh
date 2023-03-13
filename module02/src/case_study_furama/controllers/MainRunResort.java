package case_study_furama.controllers;

import java.util.Scanner;

public class MainRunResort {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("Select." +
                "\n1. Employee Management" +
                "\n2. Customer Management" +
                "\n3. Facility Management" +
                "\n4. Booking Management" +
                "\n5. Promotion Management" +
                "\n6. Exit");
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
                break;
        }
    }

    public static void employeeManagement() {
        System.out.println("List employees." +
                "\n1. Display list employees" +
                "\n2. Add new employee" +
                "\n3. Edit employee" +
                "\n4. Return main menu");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public static void customerManagement() {
        System.out.println("Customer Management" +
                "\n1. Display list customers" +
                "\n2. Add new customer" +
                "\n3. Edit customer" +
                "\n4. Return main menu");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public static void facilityManagement() {
        System.out.println("Facility Management " +
                "\n1. Display list facility" +
                "\n2. Add new facility" +
                "\n3. Display list facility maintenance" +
                "\n4. Return main menu");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public static void bookingManagement() {
        System.out.println("Booking Management " +
                "\n1. Add new booking " +
                "\n2. Display list booking" +
                "\n3. Create new contract" +
                "\n4. Display list contracts" +
                "\n5. Edit contracts" +
                "\n6. Return main menu");
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
                displayMainMenu();
                break;
        }
    }

    public static void promotionManagement() {
        System.out.println("Promotion Management  " +
                "\n1. Display list customers use service" +
                "\n2. Display list customers get voucher" +
                "\n3. Return main menu");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                displayMainMenu();
                break;
        }
    }
}
