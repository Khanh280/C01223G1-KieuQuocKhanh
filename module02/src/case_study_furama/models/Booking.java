package case_study_furama.models;

public class Booking {
    private String bookingHorse; // ma booking
    private String startDate;// ngay b bat dau
    private String endtDate; //ngay ket thuc
    private String guestHorse;// ma~ khach hang
    private String serviceName; // ten dich vu
    private String serviceType; // loai dich vu

    protected Booking(){
    }

    public Booking(String bookingHorse, String startDate, String endtDate, String guestHorse, String serviceName, String serviceType) {
        this.bookingHorse = bookingHorse;
        this.startDate = startDate;
        this.endtDate = endtDate;
        this.guestHorse = guestHorse;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getHorseBooking() {
        return bookingHorse;
    }

    public void setHorseBooking(String bookingHorse) {
        this.bookingHorse = bookingHorse;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndtDate() {
        return endtDate;
    }

    public void setEndtDate(String endtDate) {
        this.endtDate = endtDate;
    }

    public String getGuestHorse() {
        return guestHorse;
    }

    public void setGuestHorse(String guestHorse) {
        this.guestHorse = guestHorse;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}