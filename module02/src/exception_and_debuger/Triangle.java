package exception_and_debuger;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        do {
            flag = true;
            System.out.println("Nhập 3 cạnh của tam giác.");
            try {
                System.out.print("Canh a: ");
                int a = Integer.parseInt(scanner.nextLine());
                System.out.print("Canh b: ");
                int b = Integer.parseInt(scanner.nextLine());
                System.out.print("Cạnh c: ");
                int c = Integer.parseInt(scanner.nextLine());
                checkTriangle(a, b, c);
            } catch (IllegalTriangleException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Cạnh của tam giác phải là một số nguyên dương.");
            }
        } while (flag);
    }

    public static void checkTriangle(float a, float b, float c) throws IllegalTriangleException {
        if ((a < 0 || b < 0 || c < 0) || ((a + b) < c || (b + c) < a || (a + c) < b)) {
            throw new IllegalTriangleException(a + ", " + b + ", " + c + " không phải là 3 cạnh của 1 tam giác.");
        } else {
            System.out.println("Tam giác có 3 cạnh: " +
                    "\na = " + a +
                    "\nb = " + b +
                    "\nc = " + c);
        }
    }
}
