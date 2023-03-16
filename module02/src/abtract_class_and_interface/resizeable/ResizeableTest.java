package abtract_class_and_interface.resizeable;

import java.util.Scanner;

public class ResizeableTest {
    public static void main(String[] args) {
        Circle circle = new Circle("blue", false, 5);
        Rectanle rectanle = new Rectanle("Yellow", true, 7, 5);
        Square square = new Square("Yellow", true, 5);

        Shape[] shapes = new Shape[3];
        shapes[0] = circle;
        shapes[1] = rectanle;
        shapes[2] = square;
        System.out.println("Chưa tăng kích thước: ");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i]);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập phần trăm kích thước muốn tăng: ");
        int a = Integer.parseInt(sc.nextLine());
        circle.resize(a);
        rectanle.resize(a);
        square.resize(a);
        System.out.println("Đã tăng: " + a + " phần trăm.");
        for (Shape s : shapes) {
            System.out.println(s);
        }
    }
}
