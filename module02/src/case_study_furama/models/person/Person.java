package case_study_furama.models.person;

public abstract class Person {
    private String horse;// ma~
    private String name; // ho ten
    private String birthDay;// ngay sinh
    private String gender;// gioi tinh
    private String id; // so cmnd
    private String phoneNumber;
    private String email;

    protected Person(){
    }

    protected Person(String horse, String name, String birthDay, String gender, String id, String phoneNumber, String email) {
        this.horse = horse;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getHorse() {
        return horse;
    }

    public void setHorse(String horse) {
        this.horse = horse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
