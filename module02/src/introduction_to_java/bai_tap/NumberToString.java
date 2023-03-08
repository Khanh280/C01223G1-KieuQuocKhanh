package introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static String result;
    public static void main(String[] args) {
        String reset;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập số để đọc ");
            int a = Integer.parseInt(sc.nextLine());
            int m, n, i, j;
            m = a / 10;
            n = a % 10;
            i = m / 10;
            j = m % 10;
            if (a >= 0 && a < 10) {
                motDenChin(a);
            } else if (a < 20) {
                motDenChin(a);
            } else if (a < 100) {
                chuc(m);
                motDenChin(n);
            } else if (a < 1000) {
                motDenChin(i);
                System.out.print(" " + " Hundred ");
                if ( m < 20){
                    haiMuoi(n);
                } else {
                    chuc(j);
                    motDenChin(n);
                }
            } else {
                System.out.println("Số lớn quá, 3 số thôi");
            }
            System.out.println("\nC để nhập lại.\nE để thoát.");
            reset = sc.nextLine();
        } while (reset.equals("C"));
    }
    public static void motDenChin(int a){
        switch (a) {
            case 0:
                result = " ";
                break;
            case 1:
                result = "One ";
                break;
            case 2:
                result = "Two ";
                break;
            case 3:
                result = "Three ";
                break;
            case 4:
                result = "Four ";
                break;
            case 5:
                result = "Five ";
                break;
            case 6:
                result = "Six ";
                break;
            case 7:
                result = "Seven ";
                break;
            case 8:
                result = "Eight ";
                break;
            case 9:
                result = "Nine ";
        }
        System.out.print(result);
    }
    public  static void haiMuoi(int j){
        switch (j) {
            case 1:
                result = "Eleven ";
                break;
            case 2:
                result = "Twelve ";
                break;
            case 3:
                result = "Thirteen ";
                break;
            case 4:
                result = "fourteen ";
                break;
            case 5:
                result = "Firteen ";
                break;
            case 6:
                result = "sixteen ";
                break;
            case 7:
                result = "seventeen ";
                break;
            case 8:
                result = "eightteen ";
                break;
            case 9:
                result = "nineteen ";
        }
        System.out.print(result);
    }
    public static void chuc(int m){
        switch (m) {
            case 1:
                result = "Ten ";
                break;
            case 2:
                result = "Twenty ";
                break;
            case 3:
                result = "Thirty ";
                break;
            case 4:
                result = "Forty ";
                break;
            case 5:
                result = "Fifty ";
                break;
            case 6:
                result = "Sixty ";
                break;
            case 7:
                result = "Seventy ";
                break;
            case 8:
                result = "Eighty ";
                break;
            case 9:
                result = "Ninety ";
        }
        System.out.print(result);
    }
}
