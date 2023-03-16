package case_study_furama.models;

public class Room extends Facility {
//    private String freeService;//dich vu mien phi

    protected String freeService(String freeService){
        return null;
    }
    @Override
    protected String serviceName(String serviceName) {
        return null;
    }

    @Override
    protected double areaUsed(double areaUsed) {
        return 0;
    }

    @Override
    protected int rentalCost(int rentalCost) {
        return 0;
    }

    @Override
    protected int maximumPeople(int maximumPeople) {
        return 0;
    }

    @Override
    protected String rentalType(String rentalType) {
        return null;
    }

//    public Room() {
//    }
//
//    public Room(String freeService) {
//        this.freeService = freeService;
//    }
//
//    public Room(String servicename, double areaUsed, int rentalCost, int maximumPeople, String rentalType, String freeService) {
//        super(servicename, areaUsed, rentalCost, maximumPeople, rentalType);
//        this.freeService = freeService;
//    }
//
//    public String getFreeService() {
//        return freeService;
//    }
//
//    public void setFreeService(String freeService) {
//        this.freeService = freeService;
//    }
}
