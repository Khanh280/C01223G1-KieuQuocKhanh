package case_study_furama.repository;

import case_study_furama.models.facility.Facility;

import java.util.Map;

public interface IFacilityRepository {
    void displayListFacility();
    void addNewFacility(Facility facility);
    Map<Facility, Integer> displayListFacilityMaintrnance();
}
