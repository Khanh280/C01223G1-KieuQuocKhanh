package test_lap;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Bai1
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap so luong so nguyen to can tinh: ");
//        int n = Integer.parseInt(scanner.nextLine());
//        int sum = 0;
//        int count;
//        int counter = 0;
//        for (int i = 2; i > 0; i++) {
//            if (counter < n) {
//                count = 0;
//                for (int j = 1; j <=i; j++) {
//                    if (i % j == 0) {
//                        count++;
//                    }
//                }
//                if (count == 2) {
//                    sum += i;
//                    counter++;
//                }
//            } else{
//                break;
//            }
//        }
//        System.out.println(sum);
        //Bai2
//        System.out.println("Nhap chuoi de dem so lan xuat hien cua cac ky tu: ");
//        String str = scanner.nextLine();
//        String[] arr = str.split("");
//        Arrays.sort(arr);
//
//        for (int i = 0; i < arr.length; i++) {
//            String chars = arr[i];
//            int count=0;
//            for (int j = 0; j < arr.length; j++) {
//                if(chars.equals(arr[j])){
//                    count++;
//                    i++;
//                }
//            }
//            System.out.print(chars+""+count+",");
//        }
        //Bai3
//        int f0;
//        int f1=0;
//        int f2=1;
//        for (int i = 0; i < 100 ; i++) {
//            f0=f1;
//            f1=f2;
//            f2=f1+f0;
//            if(f2<100){
//                System.out.print(f2+",");
//            }else{
//                break;
//            }
//        }
        //Bai4
//        System.out.print("Nhap so de kiem tra: ");
//        int integer= Integer.parseInt(scanner.nextLine());
//        int count=0;
//        for (int i = 1; i <=integer ; i++) {
//            if(integer%i==0){
//                count++;
//            }
//        }
//        if(count == 2){
//            System.out.println(integer + " la so nguyen to");
//        }
        //Bai5
//        int[] arr ={1,4,5,3,99,7,0};
//        System.out.print("Nhap so N de kiem tra: ");
//        int n = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if((arr[i]+arr[j] == n)){
//                    System.out.println(arr[i] + " index = "+ i +" "+arr[j] +" index = " +j);
//                    System.out.println("-----------------------------");
//                    break;
//                }
//            }
//        }
        //Bai6
//        System.out.print("Nhap chuoi string bat ky: ");
//        String str = scanner.nextLine();
//        System.out.println("Chuoi ban nhap la: " + str);
//        System.out.print("Nhap ky tu muon tim: ");
//        String strIn = scanner.nextLine();
//        String[] arr = str.split("");
//        int count=0;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i].equals(strIn)){
//                count++;
//            }
//        }
//        System.out.println(strIn + " xuat hien " + count+" lan.");
        //Bai7
//        String srt = "abcbcababacabbaa";
//        char[] chars = srt.toCharArray();
//        int min = 0;
//        int id = 0;
//        for (int i = 0; i < chars.length; i++) {
//            min = chars[i];
//            id = i;
//            for (int j = i + 1; j < chars.length; j++) {
//                if(min>chars[j]){
//                    min=chars[j];
//                    id=j;
//                }
//            }
//            chars[id] = chars[i];
//            chars[i] = (char) min;
//        }
//        System.out.println(chars);
        //Bai8
//        System.out.println("Nhap so bat ky de dao nguoc: ");
//        int integer = Integer.parseInt(scanner.nextLine());
//        int i ;
//        int j;
//        Stack<Integer> stack = new Stack<>();
//        while (integer != 0) {
//            i=integer/10;
//            j= integer%10;
//            stack.push(j);
//            integer = i;
//        }
//        for (int k = 0; k < stack.size(); k++) {
//            System.out.print(stack.elementAt(k));
//        }
        //Bai9
//        int[] arr = {1,4,255,6,2,8,723,54,1111,0,2,233,244};
//        int max=0;
//        int maxFirst=0;
//        for (int i = 0; i < arr.length; i++) {
//            if(max<arr[i]){
//                maxFirst = max;
//                max = arr[i];
//            }else if(arr[i] > maxFirst && arr[i]!=max){
//                maxFirst = arr[i];
//            }
//        }
//        System.out.println(max);
//        System.out.println(maxFirst);
        //300 bai code
        //bai1 Viết chương trình liệt kê, đếm và tính tổng các ước số của số nguyên dương
        //n (n nhập từ bàn phím).
//        System.out.print("Nhap so nguyen duong: ");
//        int integer = Integer.parseInt(scanner.nextLine());
//        int count=0;
//        int sum=0;
//        for (int i = 1; i <= integer; i++) {
//            if(integer%i==0){
//                System.out.println(i + " ");
//                sum+=i;
//                count++;
//            }
//        }
//        System.out.println("Co " + count + " uoc so, tong la: " + sum);
        //bai2 Viết chương trình tìm các số hoàn hảo (perfect number) nhỏ hơn một số
        //nguyên dương n cho trước. Biết số hoàn hảo là số nguyên dương, bằng tổng các ước
        //số thực sự của nó (ví dụ: 28 = 14 + 7 + 4 + 2 + 1).
//        int count;
//        for (int i = 1; i < 10000; i++) {
//            count=0;
//            for (int j = 1; j < i; j++) {
//                if (i % j == 0) {
//                    count += j;
//                }
//            }
//            if (i == count) {
//                System.out.println(i);
//            }
//        }
        //bai3 Nhập vào một số tự nhiên n (n khai báo kiểu unsigned long)
        //a. Số tự nhiên n có bao nhiêu chữ số.
        //
        //© Dương Thiên Tứ www.codeschool.vn
        //
        //9
        //
        //b. Hãy tìm chữ số cuối cùng của n.
        //c. Hãy tìm chữ số đầu tiên của n.
        //d. Tính tổng các chữ số của n.
        //e. Hãy tìm số đảo ngược của n.
//        System.out.print("Nhap so nguyen n (long):");
//        long number = Long.parseLong(scanner.nextLine());
//        String str = Long.toString(number);
//        String[] arr = new String[str.length()];
//        int count = 0;
//        int sum = 0;
//        for (int i = 0; i < str.length(); i++) {
//            arr[i] = String.valueOf(str.charAt(i));
//        }
//
//        int[] arrStr = new int[arr.length];
//        Stack<String> stringStack = new Stack<>();
//        for (int i = 0; i < arr.length; i++) {
//            arrStr[i] = Integer.parseInt(arr[i]);
//            count++;
//            sum +=Integer.parseInt(arr[i]);
//            stringStack.push(String.valueOf(str.charAt(i)));
//        }
//        System.out.println("Co " + count + " chu so.");
//        System.out.println("Chu so dau tien la: " + str.charAt(0) + "\nChu so cuoi cung la: " + str.charAt(str.length() - 1));
//        System.out.println("Tong cac so la: " + sum);
//        int n = stringStack.size();
//        System.out.print("So dao nguoc la: ");
//        for (int i = 0; i < n; i++) {
//            System.out.print(stringStack.pop());
//        }
        //Bai4


    }
}
