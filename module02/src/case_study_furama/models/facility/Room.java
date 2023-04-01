package case_study_furama.models.facility;

public class Room extends Facility {
    private String freeService;//dich vu mien phi

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String servicename, String areaUsed, String rentalCost, String maximumPeople, String rentalType, String freeService) {
        super(servicename, areaUsed, rentalCost, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "|ServiceName = " + this.getServicename() +
                "|Area Used = " + this.getAreaUsed() +
                "|Rental Cost = " + this.getRentalCost() +
                "|Maximum People = " + this.getMaximumPeople() +
                "|Rental Type = " + this.getRentalType() +
                "|Free Service = " + this.getFreeService() + "|";
    }

    @Override
    public String getInfoToCSV() {
        return this.getServicename() +
                "," + this.getAreaUsed() +
                "," + this.getRentalCost() +
                "," + this.getMaximumPeople() +
                "," + this.getRentalType() +
                "," + this.getFreeService();
    }
}
