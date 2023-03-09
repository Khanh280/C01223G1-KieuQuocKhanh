package Class_and_oop_java;

public class VeHinhThoi {
    public static void main(String[] args) {
        int n = 10;
        int a = n / 2;
        int b = n / 2;
        int x = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i < 5) {
                a--;
                b++;
                x++;
            } else {
                a++;
                b--;
                x--;
            }
            for (int j = 0; j < n + 1; j++) {
                if (j == a || j == b) {
                    System.out.print(x);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
