package class_and_oop_java;

import java.util.Scanner;

public class Rectangle {
    double width, height;
    public Rectangle(){
    }

    public Rectangle( double width, double height){
        this.width= width;
        this.height = height;
    }

    public double getArea(){
        return this.width * this.height;
    }

    public double getPerimeter(){
        return (this.width + this.height) * 2;
    }

    public String display(){
        return " = {" + "Width=" + width + ", Height=" + height + "}";
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều rộng:");
        double width = scanner.nextDouble();
        System.out.print("Nhập chiều rộng:");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Hình chữ nhật"+ rectangle.display());
        System.out.println("Chu vi hình chữ nhật: "+ rectangle.getPerimeter());
        System.out.println("Diện tích hình chữ nhật: "+ rectangle.getArea());
    }
}
