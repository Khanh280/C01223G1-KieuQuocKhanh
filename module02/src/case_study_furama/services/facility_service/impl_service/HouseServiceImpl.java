package case_study_furama.services.facility_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.facility.House;
import case_study_furama.services.facility_service.IHouseService;
import case_study_furama.utils.ReadAndWriteDataHouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseServiceImpl extends House implements IHouseService {
    static Scanner scanner = new Scanner(System.in);
    static List<House> houses = new ArrayList<>();
    static House house = new House();
    @Override
    public void addHouse() {
        System.out.print("Nhap ten House: ");
        String serviceName = scanner.nextLine();
        System.out.print("Nhap dien tich su dung: ");
        double areaUsed = Double.parseDouble(scanner.nextLine());
        System.out.print("Chi phi thue: ");
        int rentalCost = Integer.parseInt(scanner.nextLine());
        System.out.print("So luong khach toi da: ");
        int maximunPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("Kieu thue: " +
                "\n1. Nam." +
                "\n2. Thang." +
                "\n3. Ngay.");
        int choose = Integer.parseInt(scanner.nextLine());
        String rentalType = FuramaData.rentalType.get(choose - 1);
        System.out.print("Tieu chuan phong: ");
        String roomStandards = scanner.nextLine();
        System.out.println("So tang");
        int numberFloors = Integer.parseInt(scanner.nextLine());
        house = new House(serviceName,areaUsed,rentalCost,maximunPeople,rentalType, roomStandards,numberFloors);
        houses.add(house);
        ReadAndWriteDataHouse.writeHouseToFile(houses,false);
    }

    @Override
    public void editHouseList() {

    }

    @Override
    public void deleteHouse() {

    }

    @Override
    public void displayHouseList() {
        houses = ReadAndWriteDataHouse.readFileToList();
        for (int i = 0; i < houses.size(); i++) {
            System.out.println(houses.get(i));
        }
    }
}
