package thuat_toan_sap_xep;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {2,4,1,7,0,43,10};
        for (int i = 0; i < a.length-1; i++) {
            int min = a[i];
            int index = i;
            for (int j = i+1; j <a.length ; j++) {
                if ( min > a[j]){
                    min = a[j];
                    index = j;
                }
            }
            if ( index != i){
                a[index] = a[i];
                a[i] = min;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
