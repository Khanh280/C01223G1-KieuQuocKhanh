package case_study_furama.utils;

import case_study_furama.models.facility.Facility;

import javax.activation.CommandMap;
import java.util.Comparator;

public class SortMapFacilityByName implements Comparator<Facility> {
    @Override
    public int compare(Facility o1, Facility o2) {
        return o1.getServicename().compareTo(o2.getServicename());
    }
}
