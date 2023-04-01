package case_study_furama.models.person;

public class Customer extends Person {
    private String guestType; // loai khach hang
    private String address; // dia chi de ap dung chinh sach phuc vu

    protected String guestType(String guestType) {
        return null;
    }

    protected String address(String address) {
        return null;
    }

    public Customer() {
    }

    public Customer(String horse, String name, String birthDay, String gender, String id, String phoneNumber, String email, String guestType, String address) {
        super(horse, name, birthDay, gender, id, phoneNumber, email);
        this.guestType = guestType;
        this.address = address;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "|Horse = " + this.getHorse() +
                "|Name = " + this.getName() +
                "|BirthDay = " + this.getBirthDay() +
                "|Gender = " + this.getGender() +
                "|Id = " + this.getId() +
                "|PhoneNumber = " + this.getPhoneNumber() +
                "|Email = " + this.getEmail() +
                "|Guest Type = " + this.getGuestType() +
                "|Address = " + this.getAddress() + "|";
    }

    public String getInfoToCsv() {
        return this.getHorse() + "," + this.getName() + "," + this.getBirthDay() + "," + this.getGender() + "," + this.getId() + "," +
                this.getPhoneNumber() + "," + this.getEmail() + "," + this.getGuestType() + "," + this.getAddress();
    }
}
