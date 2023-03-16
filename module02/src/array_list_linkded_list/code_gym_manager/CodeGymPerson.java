package array_list_linkded_list.code_gym_manager;

public class CodeGymPerson {
    private int id;
    private String name;
    private String birtDay;
    private String gender;

    protected CodeGymPerson(){

    }

    protected CodeGymPerson(int id, String name, String birtDay, String gender) {
        this.id = id;
        this.name = name;
        this.birtDay = birtDay;
        this.gender = gender;
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

    public String getBirtDay() {
        return birtDay;
    }

    public void setBirtDay(String birtDay) {
        this.birtDay = birtDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "CodeGymPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birtDay='" + birtDay + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
