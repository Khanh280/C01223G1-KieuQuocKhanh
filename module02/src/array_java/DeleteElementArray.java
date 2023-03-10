package array_java;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElementArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài của mảng: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        System.out.print("Nhập phần tử có index ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng bạn nhập = " + Arrays.toString(arr));

        String choose;
        do {
            System.out.print("Nhập phần tử bạn muốn xóa: ");
            int delete = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < arr.length; i++) {
                if (delete == arr[i]) {
                    for (int j = i; j < arr.length - 1; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[arr.length - 1] = 0;
                }
            }
            System.out.println("Mảng sau khi xóa = " + Arrays.toString(arr));
            System.out.print("Nhập C để tiếp tục xóa, E để thoát chương trình: ");
            choose = sc.nextLine();
        } while (choose.equals("C"));
        System.out.println("Exit...");
    }
}
