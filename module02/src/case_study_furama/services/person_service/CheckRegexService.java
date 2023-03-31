package case_study_furama.services.person_service;

import case_study_furama.data.FuramaData;
import case_study_furama.services.facility_service.impl_service.FacilityServiceImpl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckRegexService {
    static final String VILLA_HORSE_REGEX = "^(SV)(VL)-[0-9]{4}$";
    static final String ROOM_HORSE_REGEX = "^(SV)(RO)-[0-9]{4}$";
    static final String HOUSE_HORSE_REGEX = "^(SV)(HO)-[0-9]{4}$";
    static final String AREA_USER_AND_POOL_REGEX = "^[3-9](?:\\.\\d+)?$";
    static final String RENTAL_COST_REGEX = "^[1-9]+$";
    static final String MAXIMUM_PEOPLE_REGEX = "^((1[0-9])|[1-9])$";
    static final String NUMBER_FLOORS_PEOPLE_REGEX = "^[1-9]+$";
    static final String STANDARDS_REGEX = "^[A-Z][a-z]+$";
    static final String RENTAL_TYPE_REGEX = "^[1-3]$";
    static Scanner scanner = new Scanner(System.in);

    public static String checkVillaName() {
        String serviceName;
        boolean check;
        do {
            System.out.println("Nhập mã Villa: ");
            serviceName = scanner.nextLine();
            check = Pattern.matches(VILLA_HORSE_REGEX, serviceName);
            if (!check) {
                System.out.println("Mã dịch vụ không hợp lệ.");
            }
        } while (!check);
        return serviceName;
    }
    public static String checkRoomName() {
        String serviceName;
        boolean check;
        do {
            System.out.println("Nhập mã Room: ");
            serviceName = scanner.nextLine();
            check = Pattern.matches(ROOM_HORSE_REGEX, serviceName);
            if (!check) {
                System.out.println("Mã dịch vụ không hợp lệ.");
            }
        } while (!check);
        return serviceName;
    }
    public static String checkHouseName() {
        String serviceName;
        boolean check;
        do {
            System.out.println("Nhập mã House: ");
            serviceName = scanner.nextLine();
            check = Pattern.matches(HOUSE_HORSE_REGEX, serviceName);
            if (!check) {
                System.out.println("Mã dịch vụ không hợp lệ.");
            }
        } while (!check);
        return serviceName;
    }

    public static String checkAreaUser() {
        String areaUsed;
        boolean check;
        do {
            System.out.println("Nhập diện tích sử dụng: ");
            areaUsed = scanner.nextLine();
            check = Pattern.matches(AREA_USER_AND_POOL_REGEX, areaUsed);
            if (!check) {
                System.out.println("Diện tích phải lớn hơn 30m2.");
            }
        } while (!check);
        return areaUsed;
    }

    public static String checkRentalCost() {
        String rentalCost;
        boolean check;
        do {
            System.out.println("Chi phí thuê: ");
            rentalCost = scanner.nextLine();
            check = Pattern.matches(RENTAL_COST_REGEX, rentalCost);
            if (!check) {
                System.out.println("Chi phí thuê không hợp lệ.");
            }
        } while (!check);
        return rentalCost;
    }

    public static String checkMaximunPeople() {
        String maximunPeople;
        boolean check;
        do {
            System.out.println("Số lượng khách tối đa: ");
            maximunPeople = scanner.nextLine();
            check = Pattern.matches(MAXIMUM_PEOPLE_REGEX, maximunPeople);
            if (!check) {
                System.out.println("Số lượng khách không hợp lệ.");
            }
        } while (!check);
        return maximunPeople;
    }

    public static String checkRoomStandards() {
        String roomStandards;
        boolean check;
        do {
            System.out.println("Tiêu chuẩn phòng: ");
            roomStandards = scanner.nextLine();
            check = Pattern.matches(STANDARDS_REGEX, roomStandards);
            if (!check) {
                System.out.println("Tiêu chuẩn phòng không hợp lệ.");
            }
        } while (!check);
        return roomStandards;
    }

    public static String checkAreaPool() {
        String poolArea;
        boolean check;
        do {
            System.out.println("Diện tích hồ bơi: ");
            poolArea = scanner.nextLine();
            check = Pattern.matches(AREA_USER_AND_POOL_REGEX, poolArea);
            if (!check) {
                System.out.println("Diện tích hồ bơi phải lớn hơn 30m2.");
            }
        } while (!check);
        return poolArea;
    }

    public static String checkNumberFloors() {
        String numberFloors;
        boolean check;
        do {
            System.out.println("Số tầng: ");
            numberFloors = scanner.nextLine();
            check = Pattern.matches(NUMBER_FLOORS_PEOPLE_REGEX, numberFloors);
            if (!check) {
                System.out.println("Số tầng không hợp lệ.");
            }
        } while (!check);
        return numberFloors;
    }

    public static String checkRentalType() {
        String rentalType;
        String choose;
        boolean check;
        do {
            System.out.println("Kiểu thuê: " +
                    "\n1. Năm." +
                    "\n2. Tháng." +
                    "\n3. Ngày.");
            choose = scanner.nextLine();
            check = Pattern.matches(RENTAL_TYPE_REGEX, choose);
            if (!check) {
                System.out.println("Kiểu thuê không hợp lệ.");
            }
        } while (!check);
        rentalType = FuramaData.rentalType.get(Integer.parseInt(choose) - 1);
        return rentalType;
    }
    public static String checkServiceType() {
        String choose;
        boolean check;
        do {
            System.out.print("Loai dich vu: " +
                    "\n1. Villa" +
                    "\n2. Room" +
                    "\n3. House");
            choose = scanner.nextLine();
            check = Pattern.matches(RENTAL_TYPE_REGEX, choose);
            if (!check) {
                System.out.println("Kiểu thuê không hợp lệ.");
            }
        } while (!check);
        return choose;
    }
}
