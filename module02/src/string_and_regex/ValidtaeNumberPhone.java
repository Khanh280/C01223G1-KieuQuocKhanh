package string_and_regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidtaeNumberPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean checkNumberPhone;
        do {
            System.out.print("Nhập số điện thoại [ (+84 /0)xxxxxxxxx ]:");
            String numberPhone = scanner.nextLine();
            final String NUMBER_PHONE_REGEX = "^((\\+84\\s)|0)[0-9]{9}$";
            checkNumberPhone = Pattern.matches(NUMBER_PHONE_REGEX, numberPhone);
            System.out.println(checkNumberPhone ? "Số điện thoại hợp lệ." : "Số điện thoại không hợp lệ. Nhập lại.");
        } while (!checkNumberPhone);
    }
}