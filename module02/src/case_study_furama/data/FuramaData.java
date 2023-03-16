package case_study_furama.data;

public class FuramaData {
    public static String[] degreeList = new String[4];
    static {
        degreeList[0] = "Trung cap";
        degreeList[1] = "Cao dang";
        degreeList[2] = "Dai hoc";
        degreeList[3] = "Sau dai hoc";
    }
    public static String[] locationList = new String[6];
    static {
        locationList[0] = "Le Tan";
        locationList[1] = "Phuc Vu";
        locationList[2] = "Chuyen Vien";
        locationList[3] = "Giam Sat";
        locationList[4] = "Quan Ly";
        locationList[5] = "Giam Doc";
    }

    public static String[] guestTypeList = new String[5];
    static {
        guestTypeList[0] = "Diamond";
        guestTypeList[1] = "Platinium";
        guestTypeList[2] = "Gold";
        guestTypeList[3] = "Silver";
        guestTypeList[4] = "Member";
    }
}
