package case_study_furama.services.contact_service.impl_contracts;

import case_study_furama.models.Booking;
import case_study_furama.models.Contract;
import case_study_furama.repository.IContractsRepository;
import case_study_furama.repository.impl_repository.ContrcatsRepositoryImpl;
import case_study_furama.services.contact_service.IContractsService;
import case_study_furama.utils.CheckRegexService;
import case_study_furama.utils.ReadAndWriteDataBooking;
import case_study_furama.utils.ReadAndWriteDataContracts;

import java.util.*;

public class ContractsServiceImpl implements IContractsService {
    static IContractsRepository contractsRepository = new ContrcatsRepositoryImpl();
    static Set<Booking> bookingSet = ReadAndWriteDataBooking.readFileToSet();
    static List<Booking> bookingList = new LinkedList<>();
    static Queue<Booking> bookingQueue = new LinkedList<>();
    static List<Contract> contractList;
    static Contract contract = new Contract();


    static Scanner scanner = new Scanner(System.in);

    static {
        contractList = ReadAndWriteDataContracts.readFileToList();
        bookingList.addAll(bookingSet);
        Collections.reverse(bookingList);
        bookingQueue = returnBookingQueue();
    }

    public static Queue<Booking> returnBookingQueue() {
        Queue<Booking> bookingQueue1 = new LinkedList<>();
        int count;
        for (int i = 0; i < bookingList.size(); i++) {
            count = 0;
            for (int j = 0; j < contractList.size(); j++) {
                if (!contractList.get(j).getBookingHorse().equals(bookingList.get(i).getBookingHorse())) {
                    count++;
                }
            }
            if (count == contractList.size()) {
                bookingQueue1.add(bookingList.get(i));
            }
        }
        return bookingQueue1;
    }

    @Override
    public void createNewContract() {
        System.out.print("Nhập mã hợp đồng: ");
        String contractNumber = CheckRegexService.checkHorseBooking();
        System.out.print("Nhập mã Booking: ");
        String bookingHorse = CheckRegexService.checkHorseBookingByContracts(bookingQueue, contractList);
        System.out.print("Số tiền cọc trước: ");
        String predepositAmount = scanner.nextLine();
        System.out.print("Tổng số tiền thanh toán: ");
        String sumMoneyPay = scanner.nextLine();
        System.out.print("Mã khách hàng: ");
        String guestHorse = CheckRegexService.checkGuestHorse(bookingHorse);
        contract = new Contract(contractNumber, bookingHorse, predepositAmount, sumMoneyPay, guestHorse);
        contractList.add(contract);
        Collections.sort(contractList);
        contractsRepository.createNewContractRepository(contractList);
    }

    @Override
    public void displayListContract() {
        contractList = contractsRepository.displayListContractRepository();
        System.out.println("---------------------------CONTRACTS LIST---------------------------");
        for (int i = 0; i < contractList.size(); i++) {
            System.out.println(contractList.get(i));
        }
    }

    @Override
    public void editContract() {
        contractList = contractsRepository.displayListContractRepository();
        System.out.println("Nhập mã hợp đồng: ");
        String contractNumber = scanner.nextLine();
        int count=0;
        for (int i = 0; i < contractList.size(); i++) {
            if (contractNumber.equals(contractList.get(i).getContractNumber())) {
                System.out.print("Nhập mã Booking: ");
                String bookingHorse = CheckRegexService.checkHorseBookingEditContracts();
                System.out.print("Số tiền cọc trước: ");
                String predepositAmount = scanner.nextLine();
                System.out.print("Tổng số tiền thanh toán: ");
                String sumMoneyPay = scanner.nextLine();
                System.out.print("Mã khách hàng: ");
                String guestHorse = CheckRegexService.checkGuestHorse(bookingHorse);
                contract = new Contract(contractNumber, bookingHorse, predepositAmount, sumMoneyPay, guestHorse);
                contractList.set(i, contract);
                contractsRepository.editContractRepository(contractList);
            }else{
                count++;
            }
            if(count == contractList.size()){
                System.out.println("Mã hợp đồng không tồn tại.");
            }
        }
    }
}
