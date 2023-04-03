package case_study_furama.services.facility_service.impl_service;

import case_study_furama.models.facility.Room;
import case_study_furama.repository.IRoomRepository;
import case_study_furama.repository.impl_repository.RoomRepositoryImpl;
import case_study_furama.services.facility_service.IRoomService;
import case_study_furama.utils.CheckRegexService;
import case_study_furama.utils.ReadAndWriteDataRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomServiceImpl extends Room implements IRoomService {
    static List<Room> rooms = new ArrayList<>();
    static Room room = new Room();
    static IRoomRepository roomRepository = new RoomRepositoryImpl();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public Room addRoom() {
        rooms = ReadAndWriteDataRoom.readFileToList();
        String serviceName = CheckRegexService.checkRoomName();
        String areaUsed = CheckRegexService.checkAreaUser();
        String rentalCost = CheckRegexService.checkRentalCost();
        String maximunPeople = CheckRegexService.checkMaximunPeople();
        String rentalType = CheckRegexService.checkRentalType();
        System.out.print("Dịch vụ miễn phí đi kèm: ");
        String freeService = scanner.nextLine();
        room = new Room(serviceName, areaUsed, rentalCost, maximunPeople, rentalType, freeService);
        rooms.add(room);
        roomRepository.addRoom(rooms);
        return room;
    }

    @Override
    public void editRoomList() {

    }

    @Override
    public void deleteRoom() {

    }

    @Override
    public void displayRoomList() {
        rooms = roomRepository.displayRoomList();
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i));
        }
    }
}
