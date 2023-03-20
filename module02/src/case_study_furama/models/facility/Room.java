package case_study_furama.models.facility;

import case_study_furama.models.facility.Facility;

public class Room extends Facility {
    private String freeService;//dich vu mien phi

    protected String freeService(String freeService){
        return null;
    }
    public Room() {
    }

    @Override
    public String getRentalType() {
        return null;
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String servicename, double areaUsed, int rentalCost, int maximumPeople, String rentalType, String freeService) {
        super(servicename, areaUsed, rentalCost, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
