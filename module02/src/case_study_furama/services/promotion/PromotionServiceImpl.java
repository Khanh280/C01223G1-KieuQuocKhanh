package case_study_furama.services.promotion;

import case_study_furama.models.Booking;
import case_study_furama.models.person.Customer;
import case_study_furama.utils.ReadAndWriteDataBooking;
import case_study_furama.utils.ReadAndWriteDataCustomer;

import java.util.*;

public class PromotionServiceImpl implements IPromotionService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet;

    static {
        bookingSet = ReadAndWriteDataBooking.readFileToSet();
    }

    @Override
    public void displayCustomerListUserService() {
        List<Customer> customerList = ReadAndWriteDataCustomer.readFileToList();
        List<Customer> customersNewList = new ArrayList<>();
        System.out.print("Nhập năm muốn tìm: ");
        String yearUser = scanner.nextLine();
        for (Booking b : bookingSet) {
            String[] elementBooking = b.getStartDate().split("/");
            if (elementBooking[2].equals(yearUser)) {
                for (int i = 0; i < customerList.size(); i++) {
                    if (customerList.get(i).getHorse().equals(b.getGuestHorse())) {
                        customersNewList.add(customerList.get(i));
                    }
                }
            }
        }
        Set<Customer> promotionServiceSet = new TreeSet<>(customersNewList);
        for (Customer p : promotionServiceSet) {
            System.out.println(p);
        }
    }

    @Override
    public void displayCustomerListGetVoucher() {

    }
}
