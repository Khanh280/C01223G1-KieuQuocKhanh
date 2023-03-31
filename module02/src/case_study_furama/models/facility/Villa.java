package case_study_furama.models.facility;

public class Villa extends Facility {
    private String roomStandards;// Tieu chuan phong
    private String poolArea; // dien tich ho boi
    private String numberFloors;// so tang`

    public Villa() {

    }

    public Villa(String servicename, String areaUsed, String rentalCost, String maximumPeople, String rentalType, String roomStandards, String poolArea, String numberFloors) {
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

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(String numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "|Service Name= " + this.getServicename() +
                "| Area Used= " + this.getAreaUsed() +
                "| Rental Cost= " + this.getRentalCost() +
                "| Maximum People= " + this.getMaximumPeople() +
                "| Rental Type= " + this.getRentalType() +
                "| Room Standards= " + this.getRoomStandards() +
                "| Pool Area= " + this.getPoolArea() +
                "| Number Floors= " + this.getNumberFloors();
    }

    @Override
    public String getInfoToCSV() {
        return this.getServicename() +
                "," + this.getAreaUsed() +
                "," + this.getRentalCost() +
                "," + this.getMaximumPeople() +
                "," + this.getRentalType() +
                "," + this.getRoomStandards() +
                "," + this.getPoolArea() +
                "," + this.getNumberFloors();
    }
}
