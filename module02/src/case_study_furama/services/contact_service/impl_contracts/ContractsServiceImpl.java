package case_study_furama.services.contact_service.impl_contracts;

import case_study_furama.models.Booking;
import case_study_furama.models.Contract;
import case_study_furama.repository.IContractsRepository;
import case_study_furama.repository.impl_repository.ContrcatsRepositoryImpl;
import case_study_furama.services.contact_service.IContractsService;
import case_study_furama.services.CheckRegexService;
import case_study_furama.utils.ReadAndWriteDataBooking;

import java.util.*;

public class ContractsServiceImpl implements IContractsService {
    static IContractsRepository contractsRepository = new ContrcatsRepositoryImpl();
    static Set<Booking> bookingSet = ReadAndWriteDataBooking.readFileToSet();
    static List<Contract> contractList = new ArrayList<>();
    static Contract contract = new Contract();
    static List<Booking> bookingList = new LinkedList<>();
    static Queue<Booking> bookingQueue;

//    static {
//
//    }

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void createNewContract() {
        bookingList.addAll(bookingSet);
        bookingQueue = new LinkedList<>(bookingList);
        System.out.print("Nhập mã hợp đồng: ");
        String contractNumber = CheckRegexService.checkHorseBooking();
        System.out.print("Nhập mã Booking: ");
        String bookingHorse = CheckRegexService.checkHorseBooking();
        System.out.print("Số tiền cọc trước: ");
        String predepositAmount = scanner.nextLine();
        System.out.print("Tổng số tiền thanh toán: ");
        String sumMoneyPay = scanner.nextLine();
        System.out.print("Mã khách hàng: ");
        String guestHorse = CheckRegexService.checkGuestHorse();
        contract = new Contract(contractNumber, bookingHorse, predepositAmount, sumMoneyPay, guestHorse);
        contractList.add(contract);
        contractsRepository.createNewContractRepository(contractList);
    }

    @Override
    public void displayListContract() {
        contractList = contractsRepository.displayListContractRepository();
        for (int i = 0; i < contractList.size(); i++) {
            System.out.println(contractList.get(i));
        }
    }

    @Override
    public void editContract() {
        contractList = contractsRepository.displayListContractRepository();
        System.out.println("Nhập mã hợp đồng: ");
        String contractNumber = scanner.nextLine();
        for (int i = 0; i < contractList.size(); i++) {
            if (contractNumber.equals(contractList.get(i).getContractNumber())) {
                System.out.print("Nhập mã Booking: ");
                String bookingHorse = scanner.nextLine();
                System.out.print("Số tiền cọc trước: ");
                String predepositAmount = scanner.nextLine();
                System.out.print("Tổng số tiền thanh toán: ");
                String sumMoneyPay = scanner.nextLine();
                System.out.print("Mã khách hàng: ");
                String guestHorse = scanner.nextLine();
                contract = new Contract(contractNumber, bookingHorse, predepositAmount, sumMoneyPay, guestHorse);
                contractList.set(i, contract);
                contractsRepository.editContractRepository(contractList);
            }
        }
    }
}
