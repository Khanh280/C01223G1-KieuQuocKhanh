package case_study_furama.repository;

import case_study_furama.models.Booking;

import java.util.Set;

public interface IBookingRepository {
    void addBookingRepository(Set<Booking> bookingList);
    Set<Booking> displayBookingListRepository();
}
