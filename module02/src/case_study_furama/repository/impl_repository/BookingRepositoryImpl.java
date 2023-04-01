package case_study_furama.repository.impl_repository;

import case_study_furama.models.Booking;
import case_study_furama.models.facility.Facility;
import case_study_furama.models.facility.House;
import case_study_furama.models.facility.Room;
import case_study_furama.models.facility.Villa;
import case_study_furama.repository.IBookingRepository;
import case_study_furama.repository.IFacilityRepository;
import case_study_furama.utils.ReadAndWriteDataBooking;
import case_study_furama.utils.ReadAndWriteDataHouse;
import case_study_furama.utils.ReadAndWriteDataRoom;
import case_study_furama.utils.ReadAndWriteDataVilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookingRepositoryImpl implements IBookingRepository {
    static IFacilityRepository facilityRepository = new FacilityRepositoryImpl();
    static List<Villa> villas = new ArrayList<>();
    static List<Room> rooms = new ArrayList<>();
    static List<House> houses = new ArrayList<>();

    @Override
    public void addBookingRepository(Set<Booking> bookingList, Booking booking) {
        ReadAndWriteDataBooking.writeSetToFile(bookingList);
        addBookingFacility(booking);
    }

    @Override
    public Set<Booking> displayBookingListRepository() {
        Set<Booking> bookingList = ReadAndWriteDataBooking.readFileToSet();
        return bookingList;
    }

    public void addBookingFacility(Booking booking) {
        switch (booking.getServiceType()) {
            case "Villa":
                villas = ReadAndWriteDataVilla.readFileToList();
                for (int i = 0; i < villas.size(); i++) {
                    if (booking.getServiceHorse().equals(villas.get(i).getServicename())) {
                        facilityRepository.addNewFacility(villas.get(i));
                        break;
                    }
                }
                break;
            case "Room":
                rooms = ReadAndWriteDataRoom.readFileToList();
                for (int i = 0; i < rooms.size(); i++) {
                    if (booking.getServiceHorse().equals(rooms.get(i).getServicename())) {
                        facilityRepository.addNewFacility(rooms.get(i));
                        break;
                    }
                }
                break;
            case "House":
                houses = ReadAndWriteDataHouse.readFileToList();
                for (int i = 0; i < houses.size(); i++) {
                    if (booking.getServiceHorse().equals(houses.get(i).getServicename())) {
                        facilityRepository.addNewFacility(houses.get(i));
                        break;
                    }
                }
                break;
        }
    }
}
