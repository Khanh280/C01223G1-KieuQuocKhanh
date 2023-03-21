package thuat_toan_tim_kiem;

import java.util.Arrays;
import java.util.Scanner;

public class SettingBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đọo dài mảng: ");
        int length = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[length];
        System.out.println("Nhập phần tử thứ: ");
        for (int i = 0; i < length; i++) {
            System.out.print(i + " : ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.print("Nhập số cần tìm: ");
        int valueSearch = Integer.parseInt(scanner.nextLine());
        int left = 0;
        int right = arr.length - 1;
        System.out.println(valueSearch + " có index là: " + binarySearch(arr, left, right, valueSearch));
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] < value) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
        if (left <= right) {
            return binarySearch(array, left, right, value);
        }
        return -1;
    }
}
