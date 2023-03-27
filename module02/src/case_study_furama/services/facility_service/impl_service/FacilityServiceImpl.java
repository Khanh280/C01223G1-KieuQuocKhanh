package case_study_furama.services.facility_service.impl_service;


import case_study_furama.models.facility.Facility;
import case_study_furama.models.facility.House;
import case_study_furama.services.facility_service.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    static Map<Facility, Integer> map = new LinkedHashMap<>();
    static VillaServiceImpl villa = new VillaServiceImpl();
    static HouseServiceImpl house = new HouseServiceImpl();
    static RoomServiceImpl room = new RoomServiceImpl();

    @Override
    public void displayListFacility() {
        System.out.println("Chon dich vu muon them: " +
                "\n1. Display Villa." +
                "\n2. Display House." +
                "\n3. Display Room." +
                "\n4. Back to menu.");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                villa.displayVillaList();
                break;
            case "2":
                house.displayHouseList();
                break;
            case "3":
                room.displayRoomList();
                break;
            case "4":
                break;
            default:
                System.out.println("Vui long chon lai.");
        }
    }

    @Override
    public void addNewFacility() {
        System.out.println("Chon dich vu muon them: " +
                "\n1. Add new Villa." +
                "\n2. Add new House." +
                "\n3. Add new Room." +
                "\n4. Back to menu.");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                villa.addVilla();
                break;
            case "2":
                house.addHouse();
                break;
            case "3":
                room.addRoom();
                break;
            case "4":
                break;
            default:
                System.out.println("Vui long chon lai.");
        }
    }

    @Override
    public void displayListFacilityMaintrnance() {
    }
}
