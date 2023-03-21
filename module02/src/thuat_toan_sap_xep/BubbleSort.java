package thuat_toan_sap_xep;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {2,4,1,7,0,43,10};
        boolean flag = true;
        for (int i = 1; i < a.length && flag; i++) {
            flag= false;
            for (int j = 0; j < a.length-i; j++) {
                if ( a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag= true;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
