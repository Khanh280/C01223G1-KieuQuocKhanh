package case_study_furama.models;

public class Employee extends Person {
    private String degree; // trinh do chuyen mon
    private String location; // vi tri
    private long salary; // luong

    protected String degree(String degree){
        return null;
    }

    protected String location(String location){
        return null;
    }

    protected long salary(long salary){
        return 0;
    }
//    protected Employee() {
//    }
//
//    protected Employee(String degree, String location, long salary) {
//        this.degree = degree;
//        this.location = location;
//        this.salary = salary;
//    }
//
//    protected Employee(int horse, String name, String birthDay, String gender, int id, String phoneNumber, String email, String degree, String location, long salary) {
//        super(horse, name, birthDay, gender, id, phoneNumber, email);
//        this.degree = degree;
//        this.location = location;
//        this.salary = salary;
//    }
//
//    public String getDegree() {
//        return degree;
//    }
//
//    public void setDegree(String degree) {
//        this.degree = degree;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public long getSalary() {
//        return salary;
//    }
//
//    public void setSalary(long salary) {
//        this.salary = salary;
//    }

//    @Override
//    public String toString() {
//        return "Person: " +
//                "\nHorse=" + this.getHorse() +
//                "\nName='" + this.getName() + '\'' +
//                "\nBirthDay='" + this.getBirthDay() + '\'' +
//                "\nGender='" + this.getGender() + '\'' +
//                "\nId=" + this.getId() +
//                "\nPhoneNumber='" + this.getPhoneNumber() + '\'' +
//                "\nEmail='" + this.getEmail() + '\'' +
//                "\nEgree='" + this.getDegree() + '\'' +
//                "\nLocation='" + this.getLocation() + '\'' +
//                "\nSalary=" + this.getSalary();
//    }
}
