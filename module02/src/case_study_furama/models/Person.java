package case_study_furama.models;

abstract class Person {
    private int horse;// ma~
    private String name; // ho ten
    private String birthDay;// ngay sinh
    private String gender;// gioi tinh
    private int id; // so cmnd
    private String phoneNumber;
    private String email;

    protected Person(){
    }

    protected Person(int horse, String name, String birthDay, String gender, int id, String phoneNumber, String email) {
        this.horse = horse;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    protected int getHorse() {
        return horse;
    }

    protected void setHorse(int horse) {
        this.horse = horse;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getBirthDay() {
        return birthDay;
    }

    protected void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    protected String getGender() {
        return gender;
    }

    protected void setGender(String gender) {
        this.gender = gender;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "horse=" + horse +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
