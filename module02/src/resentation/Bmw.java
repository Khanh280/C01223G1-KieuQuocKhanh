package resentation;

public class Bmw extends Cars {
    private String drivingMode;

    public Bmw() {
    }

    public Bmw(String color, String weight, String engine, String drivingMode) {
        super(color, weight, engine);
        this.drivingMode = drivingMode;
    }
    public void accelerate(){
        System.out.println("0-100 km/h trong 5s");
    }

    public String getDrivingMode() {
        return drivingMode;
    }

    public void setDrivingMode(String drivingMode) {
        this.drivingMode = drivingMode;
    }
}
