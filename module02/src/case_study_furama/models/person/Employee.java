package case_study_furama.models.person;


public class Employee extends Person {
    private String degree; // trinh do chuyen mon
    private String location; // vi tri
    private long salary; // luong

//    protected String degree(String chooseDegree){
//        String degree = null;
//        switch (chooseDegree) {
//            case 1:
//                degree = " Trung cap ";
//                break;
//            case 2:
//                degree = " Cao dang ";
//                break;
//            case 3:
//                degree = " Dai hoc ";
//                break;
//            case 4:
//                degree = " Sau dai hoc ";
//                break;
//        }
//        return degree;
//    }
//
//    protected String location(String location){
//        return null;
//    }
//
//    protected long salary(long salary){
//        return 0;
//    }
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
        return  "|Horse=" + this.getHorse() +
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
}
