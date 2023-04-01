package case_study_furama.models;

import java.util.Objects;

public class Booking implements Comparable<Booking> {
    private String bookingHorse; // ma booking
    private String startDate;// ngay b bat dau
    private String endtDate; //ngay ket thuc
    private String guestHorse;// ma~ khach hang
    private String serviceHorse; // ma~ dich vu
    private String serviceType; // loai dich vu

    public Booking() {
    }

    public Booking(String guestHorse, String serviceName, String serviceType, String bookingHorse, String startDate, String endtDate) {
        this.guestHorse = guestHorse;
        this.serviceHorse = serviceName;
        this.serviceType = serviceType;
        this.bookingHorse = bookingHorse;
        this.startDate = startDate;
        this.endtDate = endtDate;
    }


    public String getBookingHorse() {
        return bookingHorse;
    }

    public void setBookingHorse(String bookingHorse) {
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

    public String getServiceHorse() {
        return serviceHorse;
    }

    public void setServiceHorse(String serviceHorse) {
        this.serviceHorse = serviceHorse;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "|guestHorse = " + guestHorse +
                "|ServiceHorse = " + serviceHorse +
                "|ServiceType = " + serviceType +
                "|bookingHorse = " + bookingHorse +
                "|StartDate = " + startDate +
                "|EndtDate = " + endtDate + "|";
    }

    public String getInfoToCsv() {
        return guestHorse + "," + serviceType + "," + serviceHorse + "," + bookingHorse + "," + startDate + "," + endtDate;
    }

    @Override
    public int compareTo(Booking o) {
        int result = o.startDate.compareTo(this.startDate);
        if (result == 0) {
            result = o.endtDate.compareTo(this.endtDate);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingHorse, booking.bookingHorse) && Objects.equals(startDate, booking.startDate) && Objects.equals(endtDate, booking.endtDate) && Objects.equals(guestHorse, booking.guestHorse) && Objects.equals(serviceHorse, booking.serviceHorse) && Objects.equals(serviceType, booking.serviceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingHorse, startDate, endtDate, guestHorse, serviceHorse, serviceType);
    }
}