package thuat_toan_tim_kiem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SearchStringLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi để kiểm tra: ");
        String stringInput = scanner.nextLine();
        char[] chars = stringInput.toCharArray();
        ArrayList<String> stringArr = new ArrayList<>();
        System.out.println("Các phần tử bạn nhập vào: " + Arrays.toString(chars));
        int maxAscii = 0;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (maxAscii < chars[i]) {
                maxAscii = chars[i];
                result += chars[i];
            } else {
                maxAscii = chars[i];
                stringArr.add(result);
                result = "";
                result += chars[i];
            }
        }
        stringArr.add(result);
        System.out.println("Các chuỗi tăng dần liên tiếp gồm: " + stringArr);

        String stringLengthMax = stringArr.get(0);
        for (int i = 1; i < stringArr.size(); i++) {
            if (stringLengthMax.length() < stringArr.get(i).length()) {
                stringLengthMax = stringArr.get(i);
            }
        }
        System.out.println("Chuỗi tăng dần liên tiếp dài nhất là: " + stringLengthMax);
    }
}
