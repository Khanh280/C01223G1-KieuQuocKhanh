package array_java;

import java.util.Arrays;
import java.util.Scanner;

public class MinValueInArray {
    public static void main(String[] args) {
        System.out.println("[Bài tập] Tìm giá trị nhỏ nhất trong mảng");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập SIZE cho mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Nhập phần tử thứ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + " : ");
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (min > arr[j]) {
                min = arr[j];
            }
        }
        System.out.println("Giá trị nhỏ nhất trong mảng =" + Arrays.toString(arr) + " là: " + min);
    }
}
