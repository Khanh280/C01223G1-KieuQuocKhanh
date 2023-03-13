package inheritance_oop.triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.setColor("blue");
        triangle.setSide1(5);
        triangle.setSide2(4);
        triangle.setSide3(3);
        System.out.println(triangle);
    }
}
