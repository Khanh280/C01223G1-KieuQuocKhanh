package array_java;

import java.util.Arrays;
import java.util.Scanner;

public class TotalColArray {
    public static float[][] arr;

    public static void main(String[] args) {
        System.out.println("[*Bài tập] Tính tổng các số ở một cột xác định ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng cha: ");
        int m = sc.nextInt();
        System.out.print("Nhập độ dài mảng con: ");
        int n = sc.nextInt();
        nhapPhanTuMang(m, n);
        tongCacSoOCot(m, n, arr);
    }

    public static void nhapPhanTuMang(int m, int n) {
        Scanner sc = new Scanner(System.in);
        arr = new float[m][n];
        System.out.println("Nhập phần tử thứ ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]");
                arr[i][j] = sc.nextFloat();
            }
        }
        System.out.println("Mảng bạn nhập: ");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void tongCacSoOCot(int m, int n, float[][] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập cột bạn muốn tính tổng: ");
        int index = sc.nextInt();
        float total = 0;
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
