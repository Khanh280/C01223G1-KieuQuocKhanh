package abtract_class_and_interface.demo;

public class Student extends Person{
    private String classe;

    public Student() {
    }

    public Student(int id, String name, String gender, String classe) {
        super(id, name, gender);
        this.classe = classe;
    }

    @Override
    public void howToGo() {
        System.out.println("Xe may");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", gender='" + this.getGender() + '\''+
                "classe='" + classe + '\'' +
                '}';
    }
}
