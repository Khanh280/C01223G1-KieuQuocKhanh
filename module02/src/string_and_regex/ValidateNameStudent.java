package string_and_regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateNameStudent {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho va ten: ");
        String nameStudent = scanner.nextLine();
        String NAME_STUDENT_REGEX = "^[A-Z][a-z]+\\s[A-Z][a-z]+(?:\\s[A-Z][a-z]+)*$";
        boolean checkNameStudent = Pattern.matches(NAME_STUDENT_REGEX,nameStudent);
        System.out.println(checkNameStudent);
    }
}
