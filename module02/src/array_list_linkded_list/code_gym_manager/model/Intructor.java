package array_list_linkded_list.code_gym_manager.model;

public class Intructor extends CodeGymPerson {
    private String knowledge;

    public Intructor(){
    }

    public Intructor(int id, String name, String birthDay, String gender, String knowledge) {
        super(id, name, birthDay, gender);
        this.knowledge = knowledge;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public String toString() {
        return "CodeGymPerson{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", birtDay='" + this.getBirthDay() + '\'' +
                ", gender='" + this.getGender() + '\'' + "Intructor{" +
                "knowledge='" + knowledge + '\'' +
                '}';
    }
}
