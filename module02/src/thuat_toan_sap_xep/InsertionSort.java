package thuat_toan_sap_xep;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 4, 9, 2, 0, 34, 2, 66, 3};
        insertionSort(array);
    }

    public static void insertionSort(int[] list) {
        int pos, x;
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            pos = i;
            while (pos > 0 && list[pos - 1] > x) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
        }
        System.out.println(Arrays.toString(list));
    }
}
