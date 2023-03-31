package case_study_furama.services.booking_service.impl_booking;

import case_study_furama.data.FuramaData;
import case_study_furama.data.TypeService;
import case_study_furama.models.Booking;
import case_study_furama.models.person.Customer;
import case_study_furama.repository.IBookingRepository;
import case_study_furama.repository.impl_repository.BookingRepositoryImpl;
import case_study_furama.services.booking_service.IBookingService;
import case_study_furama.services.facility_service.IFacilityService;
import case_study_furama.services.facility_service.IVillaService;
import case_study_furama.services.facility_service.impl_service.FacilityServiceImpl;
import case_study_furama.services.facility_service.impl_service.VillaServiceImpl;
import case_study_furama.services.person_service.CheckRegexService;
import case_study_furama.utils.ReadAndWriteDataBooking;
import case_study_furama.utils.ReadAndWriteDataCustomer;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    static Set<Booking> bookingList = new TreeSet<>();
    static List<Customer> customers = new ArrayList<>();
    static Booking booking = new Booking();
    static IBookingRepository bookingRepository = new BookingRepositoryImpl();
    static IFacilityService facilityService = new FacilityServiceImpl();
    static IVillaService villaService = new VillaServiceImpl();
    Scanner scanner = new Scanner(System.in);


    @Override
    public void addBooking() {
        bookingList = ReadAndWriteDataBooking.readFileToSet();
        customers = ReadAndWriteDataCustomer.readFileToList();
        System.out.println("--------DANH SACH KHACH HANG--------");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getName() + " | Ma khach hang = " + customers.get(i).getHorse());
        }
        System.out.print("Chon ma khach hang: ");
        String guestHorse = scanner.nextLine();
        String choose = CheckRegexService.checkServiceType();
        FacilityServiceImpl.display(chooseSeerviceType(choose));
        String serviceType = FuramaData.typeService.get(Integer.parseInt(choose) - 1);
        String serviceHorse = checkServiceType(serviceType);
        System.out.print("Nhap ma booking: ");
        String bookingHorse = scanner.nextLine();
        System.out.print("Nhap ngay bat dau: ");
        String startDate = scanner.nextLine();
        System.out.print("Nhap ngay ket thuc: ");
        String endDate = scanner.nextLine();
        booking = new Booking(guestHorse, serviceHorse, serviceType, bookingHorse, startDate, endDate);
        bookingList.add(booking);
        bookingRepository.addBookingRepository(bookingList);
    }

    public String checkServiceType(String serviceType){
        String serviceHorse = null;
        switch (serviceType){
            case "Villa":
                serviceHorse = CheckRegexService.checkVillaName();
                break;
            case "Room":
                serviceHorse = CheckRegexService.checkRoomName();
                break;
            case "House":
                serviceHorse = CheckRegexService.checkHouseName();
                break;
        }
        return  serviceHorse;
    }

    public TypeService chooseSeerviceType(String choose) {
        boolean flag;
        do {
            switch (choose) {
                case "1":
                    return TypeService.VILLA;
                case "2":
                    return TypeService.ROOM;
                case "3":
                    return TypeService.HOUSE;
                default:
                    System.out.print("Hãy chọn loại dịch vụ.");
                    flag = false;
            }
        } while (!flag);
        return null;
    }

    @Override
    public void displayBookingList() {
        bookingList = bookingRepository.displayBookingListRepository();
        for (Booking b : bookingList) {
            System.out.println(b);
        }
    }
}
