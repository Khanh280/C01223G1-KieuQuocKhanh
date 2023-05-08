package equation;

public class Equation {
    public static void equation(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("Phương trình vô nghiệm!");
        } else if (delta == 0) {
            System.out.println("Phương trình có 1 nghiệm kép :" + (-b / 2 * a));
        } else {
            System.out.println("Phương trình có 2 nghiệm : " + ((-b + Math.sqrt(delta)) / 2 * a) + " và " + ((-b - Math.sqrt(delta)) / 2 * a));
        }
    }
}
