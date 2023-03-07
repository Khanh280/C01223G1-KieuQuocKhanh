package Array_java;

import java.util.Arrays;
import java.util.Scanner;

public class TongDuongCheo {
    public static void main(String[] args) {
        System.out.println("[*Bài tập] Mảng hai chiều - tính tổng các số ở đường chéo chính của ma trận vuông");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài ma trận vuông: ");
        int m = sc.nextInt();
        int[][] arr = new int[m][m];
        System.out.println("Nhập phần tử thứ ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]");
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        int totali = 0;
        int totalj = 0;
        for (int i = 0; i < arr.length; i++) {
            totali += arr[i][i];
            totalj += arr[i][m - i - 1];
        }
        System.out.println("Tổng các số ở đường chéo chính là: " + totali +
                "\nTổng các số ở đường chéo phụ là: " + totalj);
    }
}
