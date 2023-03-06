package introduction_to_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        System.out.print("1.VND -> USD \n2.USD -> VND\n Hãy chọn đơn vị muốn chuyển đổi: ");
        Scanner sc = new Scanner(System.in);
        int rate = 23000;
        boolean flag;
        do {
            int loaiTien = sc.nextInt();
            flag = true;
            switch (loaiTien) {
                case 1:
                    System.out.print("Nhập số tiền VND: ");
                    float vnd = sc.nextFloat();
                    System.out.println(vnd + " VND = " + (vnd / rate) + " USD");
                    break;
                case 2:
                    System.out.print("Nhập số tiền USD: ");
                    float usd = sc.nextFloat();
                    System.out.println(usd + " USD = " + (usd * rate) + " VND");
                    break;
                default:
                    flag = false;
                    System.out.println("Vui lòng chọn đúng đơn vị muốn chuyển đổi: ");
            }
        } while (!flag);
    }
}
