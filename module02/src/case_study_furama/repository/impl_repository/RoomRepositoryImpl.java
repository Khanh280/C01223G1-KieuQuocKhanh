package case_study_furama.repository.impl_repository;

import case_study_furama.models.facility.Room;
import case_study_furama.repository.IRoomRepository;
import case_study_furama.utils.ReadAndWriteDataRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements IRoomRepository {
    List<Room> rooms = new ArrayList<>();

    @Override
    public void addRoom(List<Room> rooms) {
        ReadAndWriteDataRoom.writeRoomToFile(rooms, false);
    }

    @Override
    public void editRoomList() {

    }

    @Override
    public void deleteRoom() {

    }

    @Override
    public List<Room> displayRoomList() {
        rooms = ReadAndWriteDataRoom.readFileToList();
        return rooms;
    }
}
