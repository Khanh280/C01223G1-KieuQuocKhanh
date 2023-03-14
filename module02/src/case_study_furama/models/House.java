package case_study_furama.models;

public class House extends Facility {
    private String roomStandards;// Tieu chuan phong
    private int numberFloors;// so tang`

    public House() {
    }

    public House(String roomStandards, int numberFloors) {
        this.roomStandards = roomStandards;
        this.numberFloors = numberFloors;
    }

    public House(String servicename, double areaUsed, double rentalCost, int maximumPeople, String rentalType, String roomStandards, int numberFloors) {
        super(servicename, areaUsed, rentalCost, maximumPeople, rentalType);
        this.roomStandards = roomStandards;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }
}
