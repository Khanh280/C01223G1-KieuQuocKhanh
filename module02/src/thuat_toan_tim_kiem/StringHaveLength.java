package thuat_toan_tim_kiem;

import java.util.ArrayList;
import java.util.Scanner;

public class StringHaveLength {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Tìm chuỗi tăng dần có độ dài lớn nhất: ");
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            String result = "";
            int max = 0;
            int index = 0;
            for (int j = i; j < chars.length; j++) {
                if (max <= chars[j]) {
                    max = chars[j];
                    result += chars[j];
                }
            }
            list.add(result);
        }
        String maxString = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (maxString.length() < list.get(i).length()) {
                maxString = list.get(i);
            }
        }
        System.out.println(maxString);
    }
}
