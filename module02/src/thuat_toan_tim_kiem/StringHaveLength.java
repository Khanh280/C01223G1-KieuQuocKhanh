package thuat_toan_tim_kiem;

import java.util.Scanner;

public class StringHaveLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Tìm chuỗi tăng dần có độ dài lớn nhất: ");
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (max < chars[i]) {
                max = chars[i];
                System.out.print(chars[i]);
            }
        }
    }
}
