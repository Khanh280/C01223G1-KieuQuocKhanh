package test_lap.shape;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("Red",false);
        System.out.println(shape);
    }
}
