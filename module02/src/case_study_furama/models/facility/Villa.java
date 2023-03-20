package case_study_furama.models.facility;

public class Villa extends Facility {
    private String roomStandards;// Tieu chuan phong
    private double poolArea; // dien tich ho boi
    private int numberFloors;// so tang`

    protected String roomStandards(String roomStandards){
        return roomStandards;
    }

    protected double poolArea(double poolArea){
        return 0;
    }

    protected int numberFloors( int numberFloors){
        return 0;
    }

    @Override
    public String getRentalType() {
        return null;
    }

    @Override
    public String toString() {
        return "Villa{}";
    }

    public Villa() {

    }

    public Villa(String servicename, double areaUsed, int rentalCost, int maximumPeople, String rentalType, String roomStandards, double poolArea, int numberFloors) {
        super(servicename, areaUsed, rentalCost, maximumPeople, rentalType);
        this.roomStandards = roomStandards;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }
}
