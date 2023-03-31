package case_study_furama.repository.impl_repository;

import case_study_furama.models.Booking;
import case_study_furama.repository.IBookingRepository;
import case_study_furama.utils.ReadAndWriteDataBooking;

import java.util.Set;

public class BookingRepositoryImpl implements IBookingRepository {
    @Override
    public void addBookingRepository(Set<Booking> bookingList) {
        ReadAndWriteDataBooking.writeSetToFile(bookingList);
    }

    @Override
    public Set<Booking>  displayBookingListRepository() {
        Set<Booking> bookingList = ReadAndWriteDataBooking.readFileToSet();
        return bookingList;
    }
}
