package case_study_furama.repository;

import case_study_furama.models.facility.Room;

import java.util.List;

public interface IRoomRepository {
    void addRoom(List<Room> rooms);

    void editRoomList();

    void deleteRoom();

    List<Room> displayRoomList();
}
