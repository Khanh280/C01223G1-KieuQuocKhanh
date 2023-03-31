package case_study_furama.services.facility_service;

import case_study_furama.models.facility.House;

public interface IHouseService {
    House addHouse();
    void editHouseList();
    void deleteHouse();
    void displayHouseList();
}
