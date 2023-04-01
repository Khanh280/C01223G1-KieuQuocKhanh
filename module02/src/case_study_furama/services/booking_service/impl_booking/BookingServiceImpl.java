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
import case_study_furama.services.CheckRegexService;
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
        System.out.println("--------DANH SÁCH KHÁCH HÀNG--------");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getName() + " | Mã khách hàng = " + customers.get(i).getHorse());
        }
        System.out.print("Chọn mã khách hàng: ");
        String guestHorse = CheckRegexService.checkGuestHorse();
        String choose = CheckRegexService.checkServiceType();
        FacilityServiceImpl.display(chooseSeerviceType(choose));
        String serviceType = FuramaData.typeService.get(Integer.parseInt(choose) - 1);
        String serviceHorse = checkServiceType(serviceType);
        System.out.print("Nhập mã booking: ");
        String bookingHorse = CheckRegexService.checkHorseBooking();
        System.out.print("Ngày bắt đầu: ");
        String startDate = CheckRegexService.checkDate();
        System.out.print("Ngày kết thúc: ");
        String endDate = CheckRegexService.checkDate();
        booking = new Booking(guestHorse, serviceHorse, serviceType, bookingHorse, startDate, endDate);
        bookingList.add(booking);
        bookingRepository.addBookingRepository(bookingList, booking);
    }



    public String checkServiceType(String serviceType) {
        String serviceHorse = null;
        switch (serviceType) {
            case "Villa":
                serviceHorse = CheckRegexService.checkVillaHorse();
                break;
            case "Room":
                serviceHorse = CheckRegexService.checkRoomHorse();
                break;
            case "House":
                serviceHorse = CheckRegexService.checkHouseHorse();
                break;
        }
        return serviceHorse;
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
