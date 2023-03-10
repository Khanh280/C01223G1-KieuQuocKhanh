package array_java;

import java.util.Scanner;

public class CounterCharacters {
    public static String[] str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài chuỗi ký tự: ");
        int n = Integer.parseInt(sc.nextLine());
        nhapChuoiKyTu(n);
        System.out.print("Nhập ký tự để kiểm tra số lần xuất hiện: ");
        String characters = sc.nextLine();
        kiemTraXuathien(characters);
    }

    public static void nhapChuoiKyTu(int n) {
        Scanner sc = new Scanner(System.in);
        str = new String[n];
        System.out.println("Nhập ký tự thứ ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            str[i] = sc.nextLine();
        }
    }

    public static void kiemTraXuathien(String characters) {
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (characters.equals(str[i])) {
                count++;
            }
        }
        System.out.print("Số lần xuất hiện của " + characters + " là: " + count);
    }
}
