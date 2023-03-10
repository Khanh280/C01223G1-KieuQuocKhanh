package access_modifier_static.circle;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle circle = new Circle();
        System.out.println(circle.toString());
        System.out.print("Nhập bán kính hình tròn: ");
        double r = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập màu sắc: ");
        String color = sc.nextLine();
        circle.setRadius(r);
        circle.setColor(color);
        System.out.println("Hình tròn có bán kính: " + circle.getRadius() +
                ". \nDiện tích: " + circle.getArea() +
                ". \nChu vi: " + circle.getPerimeter() +
                ". \nMàu sắc: " + circle.getColor());
    }
}
