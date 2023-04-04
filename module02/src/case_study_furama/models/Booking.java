package case_study_furama.models;

import java.util.Objects;

public class Booking implements Comparable<Booking> {
    private String bookingHorse; // ma booking
    private String startDate;// ngay b bat dau
    private String endDate; //ngay ket thuc
    private String guestHorse;// ma~ khach hang
    private String serviceHorse; // ma~ dich vu
    private String serviceType; // loai dich vu

    public Booking() {
    }

    public Booking(String guestHorse, String serviceType, String serviceHorse, String bookingHorse, String startDate, String endtDate) {
        this.guestHorse = guestHorse;
        this.serviceHorse = serviceHorse;
        this.serviceType = serviceType;
        this.bookingHorse = bookingHorse;
        this.startDate = startDate;
        this.endDate = endtDate;
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
        return endDate;
    }

    public void setEndtDate(String endtDate) {
        this.endDate = endtDate;
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
        return "|GuestHorse = " + guestHorse +
                "|ServiceType = " + serviceType +
                "|ServiceHorse = " + serviceHorse +
                "|BookingHorse = " + bookingHorse +
                "|StartDate = " + startDate +
                "|EndtDate = " + endDate + "|";
    }

    public String getInfoToCsv() {
        return guestHorse + "," + serviceType + "," + serviceHorse + "," + bookingHorse + "," + startDate + "," + endDate;
    }

    @Override
    public int compareTo(Booking o) {
        String[] elementStartDateO = o.startDate.split("/");
        String[] elementStartDateThis = this.startDate.split("/");
        String[] elementEndDateO = o.endDate.split("/");
        String[] elementEndDateThis = this.endDate.split("/");

        int result = elementStartDateO[2].compareTo(elementStartDateThis[2]);
        if (result == 0) {
            result = elementStartDateO[1].compareTo(elementStartDateThis[1]);
            if (result == 0) {
                result = elementStartDateO[0].compareTo(elementStartDateThis[0]);
            }
            if (result == 0) {
                result = elementEndDateO[2].compareTo(elementEndDateThis[2]);
                if (result == 0) {
                    result = elementEndDateO[1].compareTo(elementEndDateThis[1]);
                    if (result == 0) {
                        result = elementEndDateO[0].compareTo(elementEndDateThis[0]);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingHorse, booking.bookingHorse) && Objects.equals(startDate, booking.startDate)
                && Objects.equals(endDate, booking.endDate) && Objects.equals(guestHorse, booking.guestHorse)
                && Objects.equals(serviceHorse, booking.serviceHorse) && Objects.equals(serviceType, booking.serviceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingHorse, startDate, endDate, guestHorse, serviceHorse, serviceType);
    }
}