package case_study_furama.services.facility_service;

import case_study_furama.models.facility.Villa;

import java.util.List;

public interface IVillaService {
    Villa addVilla();
    void editVillaList();
    void deleteVilla();
    void displayVillaList();
}
