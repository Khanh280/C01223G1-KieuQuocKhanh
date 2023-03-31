package case_study_furama.models.facility;

public abstract class Facility implements Comparable<Facility> {
    private String serviceName;// ten dich vu
    private String areaUsed; // dien tich su dung
    private String rentalCost; //chi phi thue
    private String maximumPeople; // so luong khach toi da
    private String rentalType; // kieu thue(nam, thang hoac ngay)

    protected Facility() {

    }

    protected Facility(String serviceName, String areaUsed, String rentalCost, String maximumPeople, String rentalType) {
        this.serviceName = serviceName;
        this.areaUsed = areaUsed;
        this.rentalCost = rentalCost;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
    }

    public String getServicename() {
        return serviceName;
    }

    public void setServicename(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(String areaUsed) {
        this.areaUsed = areaUsed;
    }

    public String getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(String rentalCost) {
        this.rentalCost = rentalCost;
    }

    public String getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(String maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", areaUsed=" + areaUsed +
                ", rentalCost=" + rentalCost +
                ", maximumPeople=" + maximumPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Facility o) {
        return this.getServicename().compareTo(o.getServicename());
    }

    public abstract String getInfoToCSV();
}
