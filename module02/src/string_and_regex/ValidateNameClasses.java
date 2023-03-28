package string_and_regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateNameClasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean checkNameClasses;
        do {
            System.out.print("Nhập tên : ");
            String nameClasses = scanner.nextLine();
            final String NAME_CLASSES_REGEX = "^[CAP][0-9]{4}[GHIK]$";
            checkNameClasses = Pattern.matches(NAME_CLASSES_REGEX, nameClasses);
            System.out.println(checkNameClasses ? "Tên lớp hợp lệ." : "Tên lớp không hợp lệ. Nhập lại.");
        } while (!checkNameClasses);
    }
}
