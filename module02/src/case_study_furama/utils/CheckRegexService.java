package case_study_furama.utils;

import case_study_furama.data.FuramaData;
import case_study_furama.models.Booking;
import case_study_furama.models.Contract;
import case_study_furama.models.facility.House;
import case_study_furama.models.facility.Room;
import case_study_furama.models.facility.Villa;
import case_study_furama.models.person.Customer;

import java.util.*;
import java.util.regex.Pattern;

public class CheckRegexService {
    static final String BIRTHDAY_REGEX = "^((0[1-9]|[12][0-9])|3[01])/((0[1-9])|(1[0-2]))/((19((2[4-9])|([3-9][0-9])))|200[0-5])$";
    static final String DATE_BOOKING = "^(((0[1-9])|[12][0-9])|3[01])/((0[1-9])|1[0-2])/([2-9]((0[2-9][3-9])|[1-9][0-9][0-9]))$";
    static final String AREA_USER_AND_POOL_REGEX = "^((([3-9][0-9]+)|[1-9][0-9][0-9]+)(?:\\.\\d+)?)$";
    static final String MAXIMUM_PEOPLE_REGEX = "^((1[0-9])|[1-9])$";
    static final String VILLA_HORSE_REGEX = "^(SV)(VL)-[0-9]{4}$";
    static final String HOUSE_HORSE_REGEX = "^(SV)(HO)-[0-9]{4}$";
    static final String ROOM_HORSE_REGEX = "^(SV)(RO)-[0-9]{4}$";
    static final String HORSE_BOOKING_REGEX = "^[A-Z]{2,}[a-z0-9]+$";
    static final String NUMBER_FLOORS_PEOPLE_REGEX = "^[1-9]([0-9]+)?$";
    static final String STANDARDS_REGEX = "^[A-Z][A-Za-z]+$";
    static final String NUMBER_INTEGER_REGEX = "^[1-9][0-9]+$";
    static final String NAME_REGEX = "^(([A-Z][a-z]*)(\\s([A-Z][a-z]*)))(\\s([A-Z][a-z]*))*$";
    static final String RENTAL_TYPE_REGEX = "^[1-3]$";
    static final String ID_REGEX = "^[A-Z0-9]+$";
    static Scanner scanner = new Scanner(System.in);
    static List<Villa> villaList = new ArrayList<>();
    static List<Room> roomList = new ArrayList<>();
    static List<House> houseList = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static Set<Booking> bookingList = new TreeSet<>();

    public static String checkGuestHorse(String bookingHorse) {
        bookingList = ReadAndWriteDataBooking.readFileToSet();
        String guestHorse;
        boolean flag;
        do {
            flag = true;
            int count = 0;
            guestHorse = scanner.nextLine();
            for (Booking b : bookingList) {
                if (b.getGuestHorse().equals(guestHorse) && b.getBookingHorse().equals(bookingHorse)) {
                    return guestHorse;
                } else {
                    count++;
                }
            }
            if (count == bookingList.size()) {
                flag = false;
                System.out.print("Mã khách hàng không trùng khớp với mã Booking.\nNhập lại:");
            }
        } while (!flag);
        return guestHorse;
    }

    public static String checkGuestHorseBookingByContracts() {
        customers = ReadAndWriteDataCustomer.readFileToList();
        String guestHorse;
        boolean flag;
        do {
            flag = true;
            int count = 0;
            System.out.print("Chọn mã khách hàng: ");
            guestHorse = scanner.nextLine();
            for (int i = 0; i < customers.size(); i++) {
                if (!customers.get(i).getHorse().equals(guestHorse)) {
                    count++;
                }
            }
            if (count == customers.size()) {
                flag = false;
                System.out.print("Mã khách hàng không tồn tại.\nNhập lại:");
            }
        } while (!flag);
        return guestHorse;
    }

    public static String checkHorseBooking() {
        String horseBooking;
        boolean check;
        do {
            System.out.print("Nhập mã booking: ");
            horseBooking = scanner.nextLine();
            check = Pattern.matches(HORSE_BOOKING_REGEX, horseBooking);
            if (!check) {
                System.out.print("Mã không hợp lệ");
            }
        } while (!check);
        return horseBooking;
    }

    public static String checkHorseBookingEditContracts() {
        bookingList = ReadAndWriteDataBooking.readFileToSet();
        String horseBooking;
        boolean check;
        do {
            int count = 0;
            horseBooking = scanner.nextLine();
            check = Pattern.matches(HORSE_BOOKING_REGEX, horseBooking);
            if (!check) {
                System.out.print("Mã không hợp lệ");
            } else {
                for (Booking b : bookingList) {
                    if (!b.getBookingHorse().equals(horseBooking)) {
                        count++;
                    } else {
                        return horseBooking;
                    }
                }
                if (count == bookingList.size()) {
                    check = false;
                    System.out.print("Mã không tồn tại ");
                }
            }
        } while (!check);
        return horseBooking;
    }

    public static String checkHorseBookingByContracts(Queue<Booking> bookingQueue, List<Contract> contractList) {
        bookingList = ReadAndWriteDataBooking.readFileToSet();
        String horseBooking;
        boolean check;
        do {
            int count = 0;
            horseBooking = scanner.nextLine();
            check = Pattern.matches(HORSE_BOOKING_REGEX, horseBooking);
            if (!check) {
                System.out.print("Mã không hợp lệ");
            } else {
                for (int i = 0; i < contractList.size(); i++) {
                    if (contractList.get(i).getBookingHorse().equals(horseBooking)) {
                        check = false;
                        System.out.println("Mã Booking đã được tạo hợp đồng.");
                        break;
                    }
                }
                for (Booking b : bookingList) {
                    if (!b.getBookingHorse().equals(horseBooking)) {
                        count++;
                    }
                }
                if (count == bookingList.size()) {
                    check = false;
                    System.out.print("Mã không tồn tại ");
                } else if (bookingQueue.peek() != null) {
                    if (horseBooking.equals(bookingQueue.peek().getBookingHorse())) {
                        bookingQueue.poll();
                    } else {
                        check = false;
                        System.out.println("Mã Booking phải theo thứ tự");
                        for (Booking b : bookingQueue) {
                            System.out.println(b);
                        }
                    }
                }
            }
        } while (!check);
        return horseBooking;
    }

    public static String checkDate() {
        String date;
        boolean check;
        do {
            date = scanner.nextLine();
            check = Pattern.matches(DATE_BOOKING, date);
            if (!check) {
                System.out.println("Ngày không hợp lệ.");
            }
        } while (!check);
        return date;
    }

    public static String checkBirthDay() {
        String birthDay;
        boolean check;
        do {
            System.out.print("Nhập ngày sinh: ");
            birthDay = scanner.nextLine();
            check = Pattern.matches(BIRTHDAY_REGEX, birthDay);
            if (!check) {
                System.out.println("Ngày sinh không hợp lệ.");
            }
        } while (!check);
        return birthDay;
    }

    public static String checkVillaHorse() {
        villaList = ReadAndWriteDataVilla.readFileToList();
        String serviceName;
        boolean check;
        do {
            int count = 0;
            System.out.println("Nhập mã Villa: ");
            serviceName = scanner.nextLine();
            check = Pattern.matches(VILLA_HORSE_REGEX, serviceName);
            if (!check) {
                System.out.println("Mã dịch vụ không hợp lệ.");
            } else {
                for (int i = 0; i < villaList.size(); i++) {
                    if (!villaList.get(i).getServicename().equals(serviceName)) {
                        count++;
                    }
                }
                if (count == villaList.size()) {
                    check = false;
                    System.out.println("Mã dịch vụ không tồn tại .");
                }
            }
        } while (!check);
        return serviceName;
    }

    public static String checkRoomHorse() {
        roomList = ReadAndWriteDataRoom.readFileToList();
        String serviceName;
        boolean check;
        do {
            int count = 0;
            System.out.println("Nhập mã Room: ");
            serviceName = scanner.nextLine();
            check = Pattern.matches(ROOM_HORSE_REGEX, serviceName);
            if (!check) {
                System.out.println("Mã dịch vụ không hợp lệ.");
            } else {
                for (int i = 0; i < roomList.size(); i++) {
                    if (!roomList.get(i).getServicename().equals(serviceName)) {
                        count++;
                    }
                }
                if (count == roomList.size()) {
                    check = false;
                    System.out.println("Mã dịch vụ không tồn  .");
                }
            }
        } while (!check);
        return serviceName;
    }

    public static String checkHouseHorse() {
        houseList = ReadAndWriteDataHouse.readFileToList();
        String serviceName;
        boolean check;
        do {
            int count = 0;
            System.out.println("Nhập mã House: ");
            serviceName = scanner.nextLine();
            check = Pattern.matches(HOUSE_HORSE_REGEX, serviceName);
            if (!check) {
                System.out.println("Mã dịch vụ không hợp lệ.");
            } else {
                for (int i = 0; i < houseList.size(); i++) {
                    if (!houseList.get(i).getServicename().equals(serviceName)) {
                        count++;
                    }
                }
                if (count == houseList.size()) {
                    check = false;
                    System.out.println("Mã dịch vụ không tồn tại .");
                }
            }
        } while (!check);
        return serviceName;
    }

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
            int count = 0;
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
            check = Pattern.matches(NUMBER_INTEGER_REGEX, rentalCost);
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
            System.out.println("Loại dịch vụ: " +
                    "\n1. Villa" +
                    "\n2. Room" +
                    "\n3. House");
            choose = scanner.nextLine();
            check = Pattern.matches(RENTAL_TYPE_REGEX, choose);
            if (!check) {
                System.out.println("Loại dịch vụ không hợp lệ.");
            }
        } while (!check);
        return choose;
    }
    public static String checkName(){
        String name;
        boolean check;
        do{
            System.out.print("Nhập tên: ");
            name = scanner.nextLine();
            check = Pattern.matches(NAME_REGEX,name);
            if(!check){
                System.out.println("Tên không hợp lệ.\nNhập lại:");
            }
        }while (!check);
        return name;
    }
    public static String checkHorse(){
        String horse;
        boolean checkId;
        do {
            horse = scanner.nextLine();
            checkId = Pattern.matches(ID_REGEX, horse);
            if(!checkId){
                System.out.println("Mã không hợp lệ.\nNhập lại:");
            }
        } while (!checkId);
        return horse;
    }
}
