package array_java;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng A: ");
        int lengthA = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập độ dài mảng B: ");
        int lengthB = Integer.parseInt(sc.nextLine());

        int[] arrA = new int[lengthA];
        int[] arrB = new int[lengthB];
        int[] newArr = new int[lengthA + lengthB];
        System.out.print("Nhập mảng A, phần tử thứ ");
        for (int i = 0; i < lengthA; i++) {
            System.out.print(i + ":");
            arrA[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Nhập mảng B, phần tử thứ ");
        for (int i = 0; i < lengthB; i++) {
            System.out.print(i + ":");
            arrB[i] = Integer.parseInt(sc.nextLine());
        }

        for (int j = 0; j < arrA.length; j++) {
            newArr[j] = arrA[j];
        }
        for (int k = 0; k < arrB.length; k++) {
            newArr[arrA.length + k] = arrB[k];
        }
        System.out.println("Mảng mới = " + Arrays.toString(newArr));
    }
}
