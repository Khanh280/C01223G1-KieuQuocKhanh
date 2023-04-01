package case_study_furama.services.facility_service.impl_service;

import case_study_furama.models.facility.House;
import case_study_furama.repository.IHouseRepository;
import case_study_furama.repository.impl_repository.HouseRepositoryImpl;
import case_study_furama.services.facility_service.IHouseService;
import case_study_furama.services.CheckRegexService;

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
        String serviceName = CheckRegexService.checkHouseName();
        String areaUsed = CheckRegexService.checkAreaUser();
        String rentalCost = CheckRegexService.checkRentalCost();
        String maximunPeople = CheckRegexService.checkMaximunPeople();
        String rentalType = CheckRegexService.checkRentalType();
        String roomStandards = CheckRegexService.checkRoomStandards();
        String numberFloors = CheckRegexService.checkNumberFloors();
        house = new House(serviceName, areaUsed, rentalCost, maximunPeople, rentalType, roomStandards, numberFloors);
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
