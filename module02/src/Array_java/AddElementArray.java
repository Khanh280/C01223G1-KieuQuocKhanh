package Array_java;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài của mảng: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số phần tử muốn để trống trong mảng: ");
        int m = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        System.out.print("Nhập phần tử có index ");
        for (int i = 0; i < n - m; i++) {
            System.out.print(i + ": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng bạn nhập = " + Arrays.toString(arr));

        String choose;
        do {
            System.out.print("Nhập phần tử bạn muốn chèn: ");
            int add = Integer.parseInt(sc.nextLine());
            System.out.print("Bạn muốn chèn vào index: ");
            int addIndex = Integer.parseInt(sc.nextLine());
            if (addIndex <= -1 || addIndex >= arr.length - 1) {
                System.out.println("Không chèn được phần tử.");
            } else {
                for (int i = 1; i <= arr.length; i++) {
                    if (addIndex == i - 1) {
                        for (int j = arr.length - 1; j >= i; j--) {
                            arr[j] = arr[j - 1];
                        }
                        arr[i - 1] = add;
                    }
                }
                System.out.println("Mảng sau khi thêm = " + Arrays.toString(arr));
            }
            System.out.print("Nhập C để tiếp tục, E để thoát chương trình: ");
            choose = sc.nextLine();
        } while (choose.equals("C"));
        System.out.println("Exit...");
    }
}
