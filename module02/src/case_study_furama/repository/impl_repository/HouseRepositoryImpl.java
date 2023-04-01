package case_study_furama.repository.impl_repository;

import case_study_furama.models.facility.House;
import case_study_furama.repository.IHouseRepository;
import case_study_furama.utils.ReadAndWriteDataHouse;

import java.util.ArrayList;
import java.util.List;

public class HouseRepositoryImpl implements IHouseRepository {
    List<House> houses = new ArrayList<>();

    @Override
    public void addHouse(List<House> houses) {
        ReadAndWriteDataHouse.writeHouseToFile(houses, false);
    }

    @Override
    public void editHouseList() {

    }

    @Override
    public void deleteHouse() {

    }

    @Override
    public List<House> displayHouseList() {
        houses = ReadAndWriteDataHouse.readFileToList();
        return houses;
    }
}
