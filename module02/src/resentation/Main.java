package resentation;

public class Main {
    public static void main(String[] args) {
        Bmw bmw = new Bmw("red","1500","v8","auto");
        bmw.carHorn();
        System.out.println(bmw.getDrivingMode());
        bmw.accelerate();
    }
}
