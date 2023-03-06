package introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        System.out.print("Nhap so can doc: ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        String result = " ";
        String teen = "teen";
        String ty = "ty";

        if (number > 0) {
            if (number <= 10) {
                switch (number) {
                    case 1:
                        result = "One";
                        break;
                    case 2:
                        result = "Two";
                        break;
                    case 3:
                        result = "Three";
                        break;
                    case 4:
                        result = "Four";
                        break;
                    case 5:
                        result = "Five";
                        break;
                    case 6:
                        result = "Six";
                        break;
                    case 7:
                        result = " Seven";
                        break;
                    case 8:
                        result = "Eight";
                        break;
                    case 9:
                        result = "Nine";
                        break;
                    case 10:
                        result = " Ten";
                        break;
                }
            } else if (number < 20) {
                switch (number) {

                    case 11:
                        result = " Eleven";
                        break;
                    case 12:
                        result = "Twelve";
                        break;
                    case 13:
                        result = " Three " + teen;
                        break;
                    case 14:
                        result = " Four " + teen;
                        break;
                    case 15:
                        result = " Five " + teen;
                        break;
                    case 16:
                        result = " Six " + teen;
                        break;
                    case 17:
                        result = " Seven " + teen;
                        break;
                    case 18:
                        result = " Eight " + teen;
                        break;
                    case 19:
                        result = " Nine " + teen;
                        break;
                }
            } else if (number < 100) {
                switch (number){

                }
            }
        }


        System.out.println(result);
    }
}
