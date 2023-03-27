package case_study_furama.models.person;


public class Employee extends Person {
    private String degree; // trinh do chuyen mon
    private String location; // vi tri
    private long salary; // luong

    public Employee() {
    }

    public Employee(int horse, String name, String birthDay, String gender, int id, String phoneNumber, String email, String degree, String location, long salary) {
        super(horse, name, birthDay, gender, id, phoneNumber, email);
        this.degree = degree;
        this.location = location;
        this.salary = salary;
    }


    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "|Horse=" + this.getHorse() +
                "|Name='" + this.getName() + '\'' +
                "|BirthDay='" + this.getBirthDay() + '\'' +
                "|Gender='" + this.getGender() + '\'' +
                "|Id=" + this.getId() +
                "|PhoneNumber='" + this.getPhoneNumber() + '\'' +
                "|Email='" + this.getEmail() + '\'' +
                "|Egree='" + this.getDegree() + '\'' +
                "|Location='" + this.getLocation() + '\'' +
                "|Salary=" + this.getSalary() + " |";
    }

    public String getInfoToCsv() {
        return this.getHorse() + "," + this.getName() + "," + this.getBirthDay() + "," + this.getGender() + "," + this.getId() + "," +
                this.getPhoneNumber() + "," + this.getEmail() + "," + this.getDegree() + "," + this.getLocation() + "," + this.getSalary();
    }
}
