package case_study_furama.repository.impl_repository;

import case_study_furama.models.facility.Facility;
import case_study_furama.models.facility.House;
import case_study_furama.models.facility.Room;
import case_study_furama.models.facility.Villa;
import case_study_furama.repository.IFacilityRepository;
import case_study_furama.services.facility_service.IHouseService;
import case_study_furama.services.facility_service.IRoomService;
import case_study_furama.services.facility_service.IVillaService;
import case_study_furama.services.facility_service.impl_service.HouseServiceImpl;
import case_study_furama.services.facility_service.impl_service.RoomServiceImpl;
import case_study_furama.services.facility_service.impl_service.VillaServiceImpl;
import case_study_furama.utils.ReadAndWriteDataFacility;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepositoryImpl implements IFacilityRepository {
    Map<Facility, Integer> mapFacility = new LinkedHashMap<>();
    static IVillaService villaService = new VillaServiceImpl();
    static IHouseService houseService = new HouseServiceImpl();
    static IRoomService roomService = new RoomServiceImpl();

    @Override
    public void displayListFacility() {
        System.out.println("---------------------------------------------------------------VILLA LIST---------------------------------------------------------------");
        villaService.displayVillaList();
        System.out.println("---------------------------------------------------------------HOUSE LIST---------------------------------------------------------------");
        houseService.displayHouseList();
        System.out.println("---------------------------------------------------------------ROOM LIST---------------------------------------------------------------");
        roomService.displayRoomList();
    }

    @Override
    public void addNewFacility(Facility facility) {
        mapFacility = ReadAndWriteDataFacility.readFileToMap();
        if (facility instanceof Villa) {
            addFacilytyToFile(mapFacility, (Villa) facility);
        } else if (facility instanceof Room) {
            addFacilytyToFile(mapFacility, (Room) facility);
        } else if (facility instanceof House) {
            addFacilytyToFile(mapFacility, (House) facility);
        }
    }

    @Override
    public Map<Facility, Integer> displayListFacilityMaintrnance() {
        mapFacility = ReadAndWriteDataFacility.readFileToMap();
        return mapFacility;
    }

    public static void addFacilytyToFile(Map<Facility, Integer> mapFacility, Facility facility) {
        if (mapFacility.size() == 0) {
            mapFacility.put(facility, 1);
        } else {
            int count = 0;
            for (int i = 0; i < mapFacility.size(); i++) {
                Facility keyFacility = (Facility) mapFacility.keySet().toArray()[i];
                int vlaueFacility = (int) mapFacility.values().toArray()[i];
                if (facility.getServicename().equals(keyFacility.getServicename())) {
                    mapFacility.remove(keyFacility);
                    mapFacility.put(facility, vlaueFacility + 1);
                    break;
                } else {
                    count++;
                }
                if (count == mapFacility.size()) {
                    mapFacility.put(facility, 1);
                }
            }
        }
        ReadAndWriteDataFacility.writeFacilityToList(mapFacility, false);
    }
}
