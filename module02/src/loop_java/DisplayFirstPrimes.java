package loop_java;

import java.util.Scanner;

public class DisplayFirstPrimes {
    public static void main(String[] args) {
        System.out.print("Nhập số lượng số nguyên tố muốn in ra: ");
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        int count;
        int n = 0;
        System.out.println(numbers + " số nguyên tố đầu tiên là: ");
        while (n < numbers) {
            for (int i = 1; i > 0; i++) {
                count = 0;
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                }
                if (count == 2) {
                    System.out.println(i);
                    n++;
                }
                if (n == numbers) {
                    break;
                }
            }
        }
    }
}
