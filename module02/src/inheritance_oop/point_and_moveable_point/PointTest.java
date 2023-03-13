package inheritance_oop.point_and_moveable_point;

import java.util.Scanner;

public class PointTest {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tọa độ x: ");
        float x = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập tọa độ y: ");
        float y = Float.parseFloat(sc.nextLine());
        point.setX(x);
        point.setY(y);
        System.out.println(point);
    }
}
