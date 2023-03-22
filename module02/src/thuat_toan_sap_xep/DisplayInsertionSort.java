package thuat_toan_sap_xep;

import java.util.Arrays;

public class DisplayInsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,3,0,332,556,4,20,9,38};
        int firstElement;
        int pos;
        for (int i = 0; i < arr.length; i++) {
            firstElement = arr[i];
            pos = i;
            while (pos > 0 && arr[pos-1] > firstElement){
                arr[pos] = arr[pos-1];
                pos--;
            }
            arr[pos] = firstElement;
        }
        System.out.println(Arrays.toString(arr));
    }
}
