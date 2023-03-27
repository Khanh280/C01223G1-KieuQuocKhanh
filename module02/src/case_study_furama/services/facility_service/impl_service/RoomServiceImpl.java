package case_study_furama.services.facility_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.facility.Room;
import case_study_furama.services.facility_service.IRoomService;
import case_study_furama.utils.ReadAndWriteDataRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomServiceImpl extends Room implements IRoomService {
    static List<Room> rooms = new ArrayList<>();
    static Room room = new Room();
    static Scanner scanner = new Scanner(System.in);
    @Override
    public void addRoom() {
        rooms = ReadAndWriteDataRoom.readFileToList();
        System.out.print("Nhap ten Room: ");
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
        System.out.print("Duch vu mien phi: ");
        String freeService = scanner.nextLine();
        room = new Room(serviceName,areaUsed,rentalCost,maximunPeople,rentalType,freeService);
        rooms.add(room);
        ReadAndWriteDataRoom.writeRoomToFile(rooms, false);
    }

    @Override
    public void editRoomList() {

    }

    @Override
    public void deleteRoom() {

    }

    @Override
    public void displayRoomList() {
        rooms = ReadAndWriteDataRoom.readFileToList();
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i));
        }
    }
}
