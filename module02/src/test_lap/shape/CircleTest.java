package test_lap.shape;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle("Yellow", true, 5);
        System.out.println(circle);
    }
}
