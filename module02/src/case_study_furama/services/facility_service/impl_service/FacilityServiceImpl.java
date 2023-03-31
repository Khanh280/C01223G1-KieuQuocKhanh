package case_study_furama.services.facility_service.impl_service;


import case_study_furama.data.TypeService;
import case_study_furama.models.facility.Facility;
import case_study_furama.models.facility.House;
import case_study_furama.models.facility.Room;
import case_study_furama.models.facility.Villa;
import case_study_furama.repository.IFacilityRepository;
import case_study_furama.repository.impl_repository.FacilityRepositoryImpl;
import case_study_furama.services.facility_service.IFacilityService;
import case_study_furama.services.facility_service.IHouseService;
import case_study_furama.services.facility_service.IRoomService;
import case_study_furama.services.facility_service.IVillaService;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    static IFacilityRepository facilityRepository = new FacilityRepositoryImpl();
    static Map<Facility, Integer> mapFacility = new LinkedHashMap<>();
    static IVillaService villaService = new VillaServiceImpl();
    static IHouseService houseService = new HouseServiceImpl();
    static IRoomService roomService = new RoomServiceImpl();
    static Villa villa = new Villa();
    static House house = new House();
    static Room room = new Room();
    public static void display(TypeService typeService){
        if(typeService == TypeService.VILLA){
            System.out.println("---------------------------------------VILLA LIST--------------------------------------");
            villaService.displayVillaList();
        } else if (typeService == TypeService.ROOM) {
            System.out.println("---------------------------------------ROOM LIST--------------------------------------");
            roomService.displayRoomList();
        } else if (typeService == TypeService.HOUSE) {
            System.out.println("---------------------------------------HOUSE LIST--------------------------------------");
            houseService.displayHouseList();
        }
    }


    @Override
    public void displayListFacility() {
        facilityRepository.displayListFacility();
    }

    @Override
    public void addNewFacility() {
        System.out.println("Chọn dịch vụ muốn thêm: " +
                "\n1. Add new Villa." +
                "\n2. Add new House." +
                "\n3. Add new Room." +
                "\n4. Back to menu.");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                villa = villaService.addVilla();
                facilityRepository.addNewFacility(villa);
                break;
            case "2":
                house = houseService.addHouse();
                facilityRepository.addNewFacility(house);
                break;
            case "3":
                room = roomService.addRoom();
                facilityRepository.addNewFacility(room);
                break;
            case "4":
                break;
            default:
                System.out.println("Vui lòng chọn lại.");
        }
    }

    @Override
    public void displayListFacilityMaintrnance() {
        mapFacility = facilityRepository.displayListFacilityMaintrnance();
        Set<Facility> set = mapFacility.keySet();
        for (Facility s : set) {
            if (mapFacility.get(s) >= 5) {
                System.out.println(s + " | Đã sử dụng " + mapFacility.get(s) + " lần, cần bảo trì.");
            }
        }
    }
}
