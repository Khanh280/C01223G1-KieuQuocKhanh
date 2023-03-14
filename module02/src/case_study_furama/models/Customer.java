package case_study_furama.models;

public class Customer extends Person{
    private String guestType; // loai khach hang
    private String address; // dia chi de ap dung chinh sach phuc vu

    private Customer(){
    }

    protected Customer(String guestType, String address) {
        this.guestType = guestType;
        this.address = address;
    }

    protected Customer(int horse, String name, String birthDay, String gender, int id, String phoneNumber, String email, String guestType, String address) {
        super(horse, name, birthDay, gender, id, phoneNumber, email);
        this.guestType = guestType;
        this.address = address;
    }
}
