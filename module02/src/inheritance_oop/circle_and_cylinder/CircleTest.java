package inheritance_oop.circle_and_cylinder;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Gía trị mặc định: ");
        System.out.println(circle);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập radius: ");
        double radius = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập color: ");
        String color = sc.nextLine();
        circle.setRadius(radius);
        circle.setColor(color);
        System.out.println(circle);
    }
}
