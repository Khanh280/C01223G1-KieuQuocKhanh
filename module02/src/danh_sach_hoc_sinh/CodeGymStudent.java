package danh_sach_hoc_sinh;

public class CodeGymStudent {
    public int id;
    private String name;
    private String classes;


    public CodeGymStudent(int id, String name, String classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "CodeGymStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
