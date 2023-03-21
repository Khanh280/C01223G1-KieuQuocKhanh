package code_gym_manager.model;

public class Student extends CodeGymPerson {
    private String classes;
    private int point;

    public Student() {
    }

    public Student(int id, String name, String birthDay, String gender, String classes, int point) {
        super(id, name, birthDay, gender);
        this.classes = classes;
        this.point = point;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "| "+ this.getId() +"  |    "+ this.getName() +"   |  "+ this.getBirthDay() +"  | "+ this.getGender() +" |   "+ classes +"  | "+ point +" |";
    }
}
