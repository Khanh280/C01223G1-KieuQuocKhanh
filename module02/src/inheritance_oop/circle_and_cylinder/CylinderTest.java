package inheritance_oop.circle_and_cylinder;

import java.util.Scanner;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println("Gía trị mặc định: ");
        System.out.println(cylinder);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập radius: ");
        double radius = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập height: ");
        double height = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập color: ");
        String color = sc.nextLine();
        cylinder.setRadius(radius);
        cylinder.setHeight(height);
        cylinder.setColor(color);
        System.out.println(cylinder);
    }
}
