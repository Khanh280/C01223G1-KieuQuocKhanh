package case_study_furama.services.facility_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.facility.Facility;
import case_study_furama.models.facility.House;
import case_study_furama.models.facility.Room;
import case_study_furama.models.facility.Villa;
import case_study_furama.services.facility_service.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    static Map<Facility, Integer> map = new LinkedHashMap<>();
    static VillaServiceImpl villa = new VillaServiceImpl();
    static House house = new House();
    static Room room = new Room();
    @Override
    public void displayListFacility() {

    }

    @Override
    public void addNewFacility() {
        System.out.print("Chon dich vu muon them: " +
                "\n1. Add new Villa." +
                "\n2. Add new House." +
                "\n3. Add new Room." +
                "\n4. Back to menu.");
        int choose = 0;
        String serviceName;
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {

        }
        switch (choose) {
            case 1:
                serviceName = "Villa";
                villa.addVilla(serviceName);
                break;
            case 2:
                serviceName = "House";
                break;
            case 3:
                serviceName = "Room";
                break;
            case 4:
                break;
        }
    }

    @Override
    public void displayListFacilityMaintrnance() {

    }
}
