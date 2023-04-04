package case_study_furama.services.promotion;

import case_study_furama.models.Booking;
import case_study_furama.models.person.Customer;
import case_study_furama.utils.ReadAndWriteDataBooking;
import case_study_furama.utils.ReadAndWriteDataCustomer;

import java.util.*;

public class PromotionServiceImpl implements IPromotionService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet;
    static List<Customer> promotionServiceSet = new ArrayList<>();
    static List<String> voucher = new ArrayList<>();


    static {
        bookingSet = ReadAndWriteDataBooking.readFileToSet();
        List<Customer> customerList = ReadAndWriteDataCustomer.readFileToList();
        for (Booking b : bookingSet) {
            for (int i = 0; i < customerList.size(); i++) {
                if (b.getGuestHorse().equals(customerList.get(i).getHorse())) {
                    promotionServiceSet.add(customerList.get(i));
                }
            }
        }
        Collections.reverse(promotionServiceSet);

    }

    @Override
    public void displayCustomerListUserService() {
        List<Customer> customerList = ReadAndWriteDataCustomer.readFileToList();
        List<Customer> customersNewList = new ArrayList<>();
        System.out.print("Search Year: ");
        String yearUser = scanner.nextLine();
        int count = 0;
        for (Booking b : bookingSet) {
            String[] elementBooking = b.getStartDate().split("/");
            if (elementBooking[2].equals(yearUser)) {
                for (int i = 0; i < customerList.size(); i++) {
                    if (customerList.get(i).getHorse().equals(b.getGuestHorse())) {
                        customersNewList.add(customerList.get(i));
                    }
                }
            } else {
                count++;
            }
            if (count == bookingSet.size()) {
                System.out.println(yearUser + " no exist...");
            }
        }
        Set<Customer> promotionServiceSet = new TreeSet<>(customersNewList);
        for (Customer p : promotionServiceSet) {
            System.out.println(p);
        }
    }

    @Override
    public void displayCustomerListGetVoucher() {
        Stack<Customer> bookingStack = new Stack<>();
        for (Customer p : promotionServiceSet) {
            bookingStack.push(p);
        }
        int sizeBookingStack = bookingStack.size();
        if(voucher.size() != 0){
            System.out.println("----------CUSTOMERS LIST GET VOUCHER----------");
            for (int i = 0; i < sizeBookingStack; i++) {
                System.out.println(bookingStack.peek().getName() + " | Code Guest = " + bookingStack.pop().getHorse() + " | Voucher = " +
                        voucher.get(i));
            }
        }else{
            System.out.println("No vouchers available yet.");
        }
    }

    public void addVoucher() {
        int voucherNumber = promotionServiceSet.size();
        System.out.println("Currently " + voucherNumber + " customers");
        System.out.println("Enter % voucher in order( 10% - 20% - 50% ): ");
        for (int i = 0; i < voucherNumber; i++) {
            System.out.print("Voucher " + (i + 1) + ": ");
            voucher.add(scanner.nextLine());
        }
        Collections.sort(voucher);
    }
}
