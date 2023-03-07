package Array_java;

import java.util.Scanner;

public class PhanTuLonNhat {
    public static void main(String[] args) {
        System.out.println("[Bài tập] Tìm phần tử lớn nhất trong mảng hai chiều");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng cha: ");
        int m = sc.nextInt();
        System.out.print("Nhập độ dài mảng con ");
        int n = sc.nextInt();
        float[][] arr = new float[m][n];
        float max = arr[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Nhập phần tử thứ [" + i + "]" + "[" + j + "] ");
                arr[i][j] = sc.nextFloat();
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    System.out.println("Giá trị lớn nhất hiện tại là: " + max + " . Có tọa độ là[" + i + "][" + j + "]");
                }
            }
        }
    }
}
