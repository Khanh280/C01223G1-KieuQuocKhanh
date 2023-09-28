package resentation;

public class Cars {
    private String color;
    private String weight;
    private String engine;

    public Cars() {
    }
    public Cars(String color, String weight, String engine) {
        this.color = color;
        this.weight = weight;
        this.engine = engine;
    }
    public void carHorn() {
        System.out.println("Bíp bíp bíp");
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
