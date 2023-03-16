package case_study_furama.models;

public class House extends Facility {
//    private String roomStandards;// Tieu chuan phong
//    private int numberFloors;// so tang`

    protected String roomStandards(String roomStandards){
        return null;
    }

    protected int numberFloors(int numberFloors){
        return 0;
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


//    public House() {
//    }
//
//    public House(String roomStandards, int numberFloors) {
//        this.roomStandards = roomStandards;
//        this.numberFloors = numberFloors;
//    }
//
//    public House(String servicename, double areaUsed, int rentalCost, int maximumPeople, String rentalType, String roomStandards, int numberFloors) {
//        super(servicename, areaUsed, rentalCost, maximumPeople, rentalType);
//        this.roomStandards = roomStandards;
//        this.numberFloors = numberFloors;
//    }
//
//    public String getRoomStandards() {
//        return roomStandards;
//    }
//
//    public void setRoomStandards(String roomStandards) {
//        this.roomStandards = roomStandards;
//    }
//
//    public int getNumberFloors() {
//        return numberFloors;
//    }
//
//    public void setNumberFloors(int numberFloors) {
//        this.numberFloors = numberFloors;
//    }
}
