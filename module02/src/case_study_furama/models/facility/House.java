package case_study_furama.models.facility;


public class House extends Facility {
    private String roomStandards;// Tieu chuan phong
    private String numberFloors;// so tang`

    public House() {

    }

    public House(String servicename, String areaUsed, String rentalCost, String maximumPeople, String rentalType, String roomStandards, String numberFloors) {
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
                "| Number Floors=" + this.getNumberFloors();
    }

    @Override
    public String getInfoToCSV() {
        return this.getServicename() +
                "," + this.getAreaUsed() +
                "," + this.getRentalCost() +
                "," + this.getMaximumPeople() +
                "," + this.getRentalType() +
                "," + this.getRoomStandards() +
                "," + this.getNumberFloors();
    }
}
