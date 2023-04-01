package case_study_furama.services.facility_service.impl_service;

import case_study_furama.models.facility.Villa;
import case_study_furama.repository.IVillaRepository;
import case_study_furama.repository.impl_repository.VillaRepositoryImpl;
import case_study_furama.services.facility_service.IVillaService;
import case_study_furama.services.CheckRegexService;
import case_study_furama.utils.ReadAndWriteDataVilla;

import java.util.*;

public class VillaServiceImpl extends Villa implements IVillaService {
    static List<Villa> villas = new ArrayList<>();
    static Villa villa = new Villa();
    static IVillaRepository villaReppository = new VillaRepositoryImpl();


    @Override
    public Villa addVilla() {
        villas = ReadAndWriteDataVilla.readFileToList();
        String serviceName = CheckRegexService.checkVillaName();
        String areaUsed = CheckRegexService.checkAreaUser();
        String rentalCost = CheckRegexService.checkRentalCost();
        String maximunPeople = CheckRegexService.checkMaximunPeople();
        String rentalType = CheckRegexService.checkRentalType();
        String roomStandards = CheckRegexService.checkRoomStandards();
        String poolArea = CheckRegexService.checkAreaPool();
        String numberFloors = CheckRegexService.checkNumberFloors();
        villa = new Villa(serviceName, areaUsed, rentalCost, maximunPeople, rentalType, roomStandards, poolArea, numberFloors);
        villas.add(villa);
        villaReppository.addVilla(villas);
        return villa;
    }

    @Override
    public void editVillaList() {

    }

    @Override
    public void deleteVilla() {
//        villas = ReadAndWriteDataVilla.readFileToList();
//        int count = 0;
//        System.out.print("Nhap ten Villa: ");
//        String serviceName = scanner.nextLine();
//        for (int i = 0; i < villas.size(); i++) {
//            if (serviceName.equals(villas.get(i).getServicename())) {
//                System.out.println("Ban co xac nhan xoa " + villas.get(i).getServicename() +
//                        "\n1. Yes" + "\n2. No");
//                String choose = scanner.nextLine();
//                switch (choose) {
//                    case "1":
//                        villas.remove(i);
//                        if (villas.size() == 0) {
//                            ReadAndWriteDataVilla.writeVillaToFile(null, false);
//                        } else {
//                            ReadAndWriteDataVilla.writeVillaToFile(villas, false);
//                        }
//                        return;
//                    case "2":
//                        System.out.println("Ban da khong xoa.");
//                        break;
//                    default:
//                        System.out.println("Vui long chon lai.");
//                }
//                return;
//            } else {
//                count++;
//            }
//            if (count == villas.size()) {
//                System.out.println("Ten Villa khong ton tai.");
//            }
//        }
    }

    @Override
    public void displayVillaList() {
        villas = villaReppository.displayVillaList();
        for (int i = 0; i < villas.size(); i++) {
            System.out.println(villas.get(i));
        }
    }
}
