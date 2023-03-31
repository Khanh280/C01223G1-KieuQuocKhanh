package case_study_furama.services.facility_service;

import case_study_furama.models.facility.Room;
import case_study_furama.models.facility.Villa;

public interface IRoomService {
    Room addRoom();
    void editRoomList();
    void deleteRoom();
    void displayRoomList();
}
