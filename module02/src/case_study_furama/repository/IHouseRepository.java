package case_study_furama.repository;

import case_study_furama.models.facility.House;

import java.util.List;

public interface IHouseRepository {
    void addHouse(List<House> houses);

    void editHouseList();

    void deleteHouse();

    List<House> displayHouseList();
}
