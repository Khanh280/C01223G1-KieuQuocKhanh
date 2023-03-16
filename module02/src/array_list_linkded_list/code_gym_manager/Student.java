package array_list_linkded_list.code_gym_manager;

public class Student extends CodeGymPerson {
    private String classes;
    private int point;

    public Student() {
    }

    public Student(int id, String name, String birtDay, String gender, String classes, int point) {
        super(id, name, birtDay, gender);
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
        return " CodeGymPerson { " +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", birtDay='" + this.getBirtDay() + '\'' +
                ", gender='" + this.getGender() + '\'' +
                "classes='" + classes + '\'' +
                ", point=" + point +
                '}';
    }
}
