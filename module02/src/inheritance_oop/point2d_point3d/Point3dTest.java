package inheritance_oop.point2d_point3d;

import java.util.Scanner;

public class Point3dTest {
    public static void main(String[] args) {
        Point3d point3d = new Point3d();
        System.out.println(point3d);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tọa độ x: ");
        float x = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập tọa độ y: ");
        float y = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập tọa độ z: ");
        float z = Float.parseFloat(sc.nextLine());
        point3d.setX(x);
        point3d.setY(y);
        point3d.setZ(z);
        System.out.print(point3d);
    }
}
