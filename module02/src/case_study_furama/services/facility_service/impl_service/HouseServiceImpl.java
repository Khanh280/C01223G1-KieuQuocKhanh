package case_study_furama.services.facility_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.facility.House;
import case_study_furama.repository.IHouseRepository;
import case_study_furama.repository.impl_repository.HouseRepositoryImpl;
import case_study_furama.services.facility_service.IHouseService;
import case_study_furama.services.person_service.CheckRegexService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseServiceImpl extends House implements IHouseService {
    static Scanner scanner = new Scanner(System.in);
    static List<House> houses = new ArrayList<>();
    static IHouseRepository houseRepository = new HouseRepositoryImpl();
    static House house = new House();
    @Override
    public House addHouse() {
        System.out.print("Nhập tên House: ");
        String serviceName = CheckRegexService.checkHouseName();
        System.out.print("Nhập diện tích sử dụng: ");
        String areaUsed = CheckRegexService.checkAreaUser();
        System.out.print("Chi phí thuê: ");
        String rentalCost = CheckRegexService.checkRentalCost();
        System.out.print("Số lượng khách tối đa: ");
        String maximunPeople = CheckRegexService.checkMaximunPeople();
        String rentalType = CheckRegexService.checkRentalType();
        System.out.print("Tiêu chuẩn phòng: ");
        String roomStandards = CheckRegexService.checkRoomStandards();
        System.out.println("Số tầng");
        String numberFloors = CheckRegexService.checkNumberFloors();
        house = new House(serviceName,areaUsed,rentalCost,maximunPeople,rentalType, roomStandards,numberFloors);
        houses.add(house);
        houseRepository.addHouse(houses);
        return house;
    }

    @Override
    public void editHouseList() {

    }

    @Override
    public void deleteHouse() {

    }

    @Override
    public void displayHouseList() {
        houses = houseRepository.displayHouseList();
        for (int i = 0; i < houses.size(); i++) {
            System.out.println(houses.get(i));
        }
    }
}
