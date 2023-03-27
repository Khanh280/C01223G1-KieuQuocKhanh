package case_study_furama.models.facility;


public class House extends Facility {
    private String roomStandards;// Tieu chuan phong
    private int numberFloors;// so tang`

    protected String roomStandards(String roomStandards) {
        return null;
    }

    protected int numberFloors(int numberFloors) {
        return 0;
    }

    @Override
    public String getRentalType() {
        return null;
    }

    public House() {

    }

    public House(String servicename, double areaUsed, int rentalCost, int maximumPeople, String rentalType, String roomStandards, int numberFloors) {
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

    @Override
    public String toString() {
        return "House{" +
                "serviceName='" + this.getServicename() + '\'' +
                ", areaUsed=" + this.getAreaUsed() +
                ", rentalCost=" + this.getRentalCost() +
                ", maximumPeople=" + this.getMaximumPeople() +
                ", rentalType='" + this.getRentalType() + '\'' +
                "roomStandards='" + this.getRoomStandards() + '\'' +
                ", numberFloors=" + this.getNumberFloors() +
                '}';
    }

    public String getInfoToFile() {
        return this.getServicename() +
                "," + this.getAreaUsed() +
                "," + this.getRentalCost() +
                "," + this.getMaximumPeople() +
                "," + this.getRentalType() +
                "," + this.getRoomStandards() +
                "," + this.getNumberFloors();
    }
}
