package case_study_furama.services.facility_service.impl_service;

import case_study_furama.data.FuramaData;
import case_study_furama.models.facility.Villa;
import case_study_furama.services.facility_service.IVillaService;
import case_study_furama.utils.ReadAndWriteDataVilla;

import java.util.*;

public class VillaServiceImpl extends Villa implements IVillaService {
    static List<Villa> villas = new ArrayList<>();
    static Villa villa = new Villa();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addVilla() {
        villas = ReadAndWriteDataVilla.readFileToList();
        System.out.print("Nhap ten Villa: ");
        String serviceName = scanner.nextLine();
        System.out.print("Nhap dien tich su dung: ");
        double areaUsed = Double.parseDouble(scanner.nextLine());
        System.out.print("Chi phi thue: ");
        int rentalCost = Integer.parseInt(scanner.nextLine());
        System.out.print("So luong khach toi da: ");
        int maximunPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("Kieu thue: " +
                "\n1. Nam." +
                "\n2. Thang." +
                "\n3. Ngay.");
        int choose = Integer.parseInt(scanner.nextLine());
        String rentalType = FuramaData.rentalType.get(choose - 1);
        System.out.print("Tieu chuan phong: ");
        String roomStandards = scanner.nextLine();
        System.out.print("Dien tich ho boi: ");
        double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.print("So tang: ");
        int numberFloors = Integer.parseInt(scanner.nextLine());
        villa = new Villa(serviceName, areaUsed, rentalCost, maximunPeople, rentalType, roomStandards, poolArea, numberFloors);
        villas.add(villa);
        ReadAndWriteDataVilla.writeVillaToFile(villas, false);
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
        villas = ReadAndWriteDataVilla.readFileToList();
        for (int i = 0; i < villas.size(); i++) {
            System.out.println(villas.get(i));
        }
    }
}
