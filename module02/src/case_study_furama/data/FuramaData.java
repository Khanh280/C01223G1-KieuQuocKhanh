package case_study_furama.data;

import java.util.ArrayList;

public class FuramaData {
    public FuramaData(){}
    public static ArrayList<String> degreeList = new ArrayList<>();
    static {
        degreeList.add("Trung cap");
        degreeList.add("Cao dang");
        degreeList.add("Dai hoc");
        degreeList.add("Sau dai hoc");
    }
    public static ArrayList<String> locationList = new ArrayList<>();
    static {
        locationList.add("Le Tan");
        locationList.add("Phuc Vu");
        locationList.add("Chuyen Vien");
        locationList.add("Giam Sat");
        locationList.add("Quan Ly");
        locationList.add("Giam Doc");
    }

    public static ArrayList<String> guestTypeList = new ArrayList<>();
    static {
        guestTypeList.add("Diamond");
        guestTypeList.add("Platinium");
        guestTypeList.add("Gold");
        guestTypeList.add("Silver");
        guestTypeList.add("Member");
    }
    public static ArrayList<String> rentalType = new ArrayList<>();
    static {
        rentalType.add("Nam");
        rentalType.add("Thang");
        rentalType.add("Ngay");
    }
    public static ArrayList<String> typeService = new ArrayList<>();
    static {
        typeService.add("Villa");
        typeService.add("Room");
        typeService.add("House");
    }

}
