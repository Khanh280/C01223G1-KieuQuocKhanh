package introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {

        boolean flag = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập số để đọc ");
            int a = sc.nextInt();
            String zero = "Zero";
            String one = "One";
            String two = "Two";
            String three = "Three";
            String four = "Four";
            String five = "Five";
            String six = "Six";
            String seven = "Seven";
            String eight = "Eight";
            String nine = "Nine";
            String ten = "Ten";

            String twenty = "twenty ";
            String thirty = "Thirty ";
            String forty = "Forty ";
            String fifty = "Fifty ";
            String sixty = "Sixty ";
            String seventy = "Seventy ";
            String eighty = "Eighty ";
            String ninety = "Ninety ";
            String hundered = " Hundered ";
            String teen = "teen";
            String result = " ";

            int m, n, i, j;
            m = a / 10;
            i = m / 10;
            n = a % 10;
            j = m % 10;
            flag = true;
            if (a >= 0 && a < 10) {
                switch (a) {
                    case 0:
                        result = zero;
                        break;
                    case 1:
                        result = one;
                        break;
                    case 2:
                        result = two;
                        break;
                    case 3:
                        result = three;
                        break;
                    case 4:
                        result = four;
                        break;
                    case 5:
                        result = five;
                        break;
                    case 6:
                        result = six;
                        break;
                    case 7:
                        result = seven;
                        break;
                    case 8:
                        result = eight;
                        break;
                    case 9:
                        result = nine;
                }
                System.out.print(result);
            } else if (a < 20) {
                switch (a) {
                    case 10:
                        result = ten;
                        break;
                    case 11:
                        result = "Eleven";
                        break;
                    case 12:
                        result = "Twelve";
                        break;
                    case 13:
                        result = "Thir" + teen;
                        break;
                    case 14:
                        result = four + teen;
                        break;
                    case 15:
                        result = "Fir" + teen;
                        break;
                    case 16:
                        result = six + teen;
                        break;
                    case 17:
                        result = seven + teen;
                        break;
                    case 18:
                        result = eight + teen;
                        break;
                    case 19:
                        result = nine + teen;
                }
                System.out.print(result);
            } else if (a < 100) {
                switch (m) {
                    case 2:
                        result = twenty;
                        break;
                    case 3:
                        result = thirty;
                        break;
                    case 4:
                        result = forty;
                        break;
                    case 5:
                        result = fifty;
                        break;
                    case 6:
                        result = sixty;
                        break;
                    case 7:
                        result = seventy;
                        break;
                    case 8:
                        result = eighty;
                        break;
                    case 9:
                        result = ninety;
                }
                System.out.print(result);
                switch (n) {
                    case 1:
                        result = one;
                        break;
                    case 2:
                        result = two;
                        break;
                    case 3:
                        result = three;
                        break;
                    case 4:
                        result = four;
                        break;
                    case 5:
                        result = five;
                        break;
                    case 6:
                        result = six;
                        break;
                    case 7:
                        result = seven;
                        break;
                    case 8:
                        result = eight;
                        break;
                    case 9:
                        result = nine;
                }
                System.out.print(result);
            } else if (a < 1000) {
                switch (i) {
                    case 1:
                        result = one;
                        break;
                    case 2:
                        result = two;
                        break;
                    case 3:
                        result = three;
                        break;
                    case 4:
                        result = four;
                        break;
                    case 5:
                        result = five;
                        break;
                    case 6:
                        result = six;
                        break;
                    case 7:
                        result = seven;
                        break;
                    case 8:
                        result = eight;
                        break;
                    case 9:
                        result = nine;
                }
                System.out.print(result + " " + hundered);
                switch (j) {
                    case 2:
                        result = twenty;
                        break;
                    case 3:
                        result = thirty;
                        break;
                    case 4:
                        result = forty;
                        break;
                    case 5:
                        result = fifty;
                        break;
                    case 6:
                        result = sixty;
                        break;
                    case 7:
                        result = seventy;
                        break;
                    case 8:
                        result = eighty;
                        break;
                    case 9:
                        result = ninety;
                }
                System.out.print(result);
                switch (n) {
                    case 1:
                        result = one;
                        break;
                    case 2:
                        result = two;
                        break;
                    case 3:
                        result = three;
                        break;
                    case 4:
                        result = four;
                        break;
                    case 5:
                        result = five;
                        break;
                    case 6:
                        result = six;
                        break;
                    case 7:
                        result = seven;
                        break;
                    case 8:
                        result = eight;
                        break;
                    case 9:
                        result = nine;
                }
                System.out.println(result);
            } else {
                System.out.println("Số lớn quá, 3 số thôi");
            }
            System.out.println("\n false để nhập lại.\n true để thoát.");
            boolean reset = sc.nextBoolean();
            if (reset) {
                flag = true;
            } else {
                flag = false;
            }
        } while (!flag);
    }
}
