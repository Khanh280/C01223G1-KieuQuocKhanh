package case_study_furama.models;

abstract class Facility {
    private String serviceName;// ten dich vu
    private double areaUsed; // dien tich su dung
    private int rentalCost; //chi phi thue
    private int maximumPeople; // so luong khach toi da
    private String rentalType; // kieu thue(nam, thang hoac ngay)

    protected  Facility(){}
    protected Facility(String serviceName, double areaUsed, int rentalCost, int maximumPeople, String rentalType) {
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

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(int rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

}
