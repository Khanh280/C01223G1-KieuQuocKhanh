package inheritance_oop.point2d_point3d;

import java.util.Scanner;

public class Point2dTest {
    public static void main(String[] args) {
        Point2d point2d = new Point2d();
        System.out.println(point2d);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tọa độ x: ");
        float x = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập tọa độ y: ");
        float y = Float.parseFloat(sc.nextLine());
        point2d.setX(x);
        point2d.setY(y);
        System.out.print(point2d);
    }
}
