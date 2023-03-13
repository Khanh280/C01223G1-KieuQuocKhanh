package inheritance_oop.point_and_moveable_point;

import java.util.Scanner;

public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tọa độ x: ");
        float x = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập tọa độ y: ");
        float y = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập  xSpeed: ");
        float xSpeed = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập ySpeed: ");
        float ySpeed = Float.parseFloat(sc.nextLine());
        moveablePoint.setX(x);
        moveablePoint.setY(y);
        moveablePoint.setxSpeed(xSpeed);
        moveablePoint.setySpeed(ySpeed);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
