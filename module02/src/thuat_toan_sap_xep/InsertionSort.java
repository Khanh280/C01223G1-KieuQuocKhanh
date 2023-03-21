package thuat_toan_sap_xep;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1,4,9,2,0,34,2,66,3};
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && array[pos-1] > x){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
        System.out.println(Arrays.toString(array));
    }
}
