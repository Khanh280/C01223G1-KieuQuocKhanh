package Array_java;

import java.util.Arrays;
import java.util.Scanner;

public class TotalColArray {
    public static void main(String[] args) {
        System.out.println("[*Bài tập] Tính tổng các số ở một cột xác định ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng cha: ");
        int m = sc.nextInt();
        System.out.print("Nhập độ dài mảng con: ");
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        System.out.println("Nhập phần tử thứ ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]");
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Mảng bạn nhập: ");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.print("Nhập cột bạn muốn tính tổng: ");
        int index = sc.nextInt();
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (index == j) {
                    total += arr[i][j];
                }
            }
        }
        System.out.print("Tổng của cột " + index + " là: " + total);
    }
}
