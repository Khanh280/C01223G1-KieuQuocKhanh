package case_study_furama.repository;

import case_study_furama.models.facility.Villa;

import java.util.List;

public interface IVillaRepository {
    void addVilla(List<Villa> villas);
    void editVillaList();
    void deleteVilla();
    List<Villa> displayVillaList();
}
