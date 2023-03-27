package case_study_furama.models.facility;

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

    @Override
    public String toString() {
        return "Room{" +
                "serviceName='" + this.getServicename() + '\'' +
                ", areaUsed=" + this.getAreaUsed() +
                ", rentalCost=" + this.getRentalCost() +
                ", maximumPeople=" + this.getMaximumPeople() +
                ", rentalType='" + this.getRentalType() + '\'' +
                "freeService='" + this.getFreeService()+ '\'' +
                '}';
    }
    public String getInfoToFile() {
        return this.getServicename() +
                "," + this.getAreaUsed() +
                "," + this.getRentalCost() +
                "," + this.getMaximumPeople() +
                "," + this.getRentalType() +
                "," + this.getFreeService() ;
    }
}
