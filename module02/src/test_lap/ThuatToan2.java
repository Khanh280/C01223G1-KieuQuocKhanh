package test_lap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThuatToan2 {
    static Scanner scanner = new Scanner(System.in);

    //Bai1
//    public static void main(String[] args) {
//        System.out.print("Nhap so de kiem tra: ");
//        int integer = Integer.parseInt(scanner.nextLine());
//        System.out.println(isOdd(integer));;
//    }
//    public static boolean isOdd(int integer){
//        if(integer % 2 == 0){
//            return true;
//        }else{
//            return false;
//        }
//    }
    //Bai2
//    public static void main(String[] args) {
//        System.out.print("Nhap mot so nguyen bat ky: ");
//        int integer = Integer.parseInt(scanner.nextLine());
//        System.out.println(generalDivisor(integer));
//    }
//    public static ArrayList<Integer> generalDivisor(int integer){
//        ArrayList<Integer> arr = new ArrayList<>();
//        for (int i = 1; i <= integer; i++) {
//            if (integer % i == 0) {
//                arr.add(i);
//            }
//        }
//        return arr;
//    }
    //Bai3
//    public static void main(String[] args) {
//        System.out.println(checkYear(2100));
//    }
//
//    public static boolean checkYear(int year) {
//        if (year % 4 == 0 && year % 100 != 0) {
//            return true;
//        } else if (year % 400 == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    //Bai4
//    public static void main(String[] args) {
//        System.out.print("Nhap gioi han day so fibonaci: ");
//        int integer = Integer.parseInt(scanner.nextLine());
//        displayFibonaci(integer);
//    }
//    public static void displayFibonaci(int integer){
//        int f0;
//        int f1=0;
//        int f2=1;
//        for (int i = 0; i < integer; i++) {
//                f0=f1;
//                f1=f2;
//                f2 = f1+f0;
//            if(f0 < integer){
//                System.out.println(f0);
//            } else{
//                break;
//            }
//        }
//    }
    //Bai5
//    public static void main(String[] args) {
//        System.out.print("Nhap so nguyen duong de kiem tra: ");
//        int integer = Integer.parseInt(scanner.nextLine());
//        System.out.println(checkInteger(integer));;
//    }
//
//    public static boolean checkInteger(int integer) {
//        int count = 0;
//        for (int i = 1; i <= integer; i++) {
//            if (integer % i == 0) {
//                count++;
//            }
//        }
//        if (count == 2) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    //Bai6
//    public static void main(String[] args) {
//        System.out.print("Nhap chuoi so de kiem tra: ");
//        String str = scanner.nextLine();
//        System.out.println(check(str));
//    }
//    public static boolean check(String str){
//        String[] arr = str.split("");
//        int count=0;
//        for (int i = 0; i < arr.length/2; i++) {
//            if(!arr[i].equals(arr[arr.length-i-1])){
//                break;
//            }else{
//                count++;
//            }
//        }
//        if(count == (arr.length/2)){
//            return true;
//        }else {
//            return false;
//        }
//    }
    //Bai7
//    public static void main(String[] args) {
//        System.out.print("Nhap so nguyen: ");
//        int integer = Integer.parseInt(scanner.nextLine());
//        System.out.println(returnTotal(integer));
//    }
//
//    public static  int returnTotal(int integer){
//        int sum=0;
//        for (int i = 1; i <= integer; i++) {
//            if(integer%i==0){
//                sum+=i;
//            }
//        }
//        return sum;
//    }
    //Bai8
//    public static void main(String[] args) {
//        System.out.print("Nhap so a: ");
//        int a = Integer.parseInt(scanner.nextLine());
//        System.out.print("Nhap so b: ");
//        int b = Integer.parseInt(scanner.nextLine());
//        returnAvg(a,b);
//    }

    //    public static void returnAvg(int a, int b) {
//        List<Integer> arrA = new ArrayList<>();
//        List<Integer> arrB = new ArrayList<>();
//        int sum = 0;
//        for (int i = 1; i <= a; i++) {
//            if (a % i == 0) {
//                arrA.add(i);
//            }
//        }
//        for (int i = 1; i <= b; i++) {
//            if (b % i == 0) {
//                arrB.add(i);
//            }
//        }
//        for (int i = 0; i < arrA.size(); i++) {
//            for (int j = 0; j < arrB.size(); j++) {
//                if(arrA.get(i) == arrB.get(j)){
//                    sum = (arrA.get(i) + arrB.get(j)) /2;
//                }
//            }
//        }
//        System.out.println("Trung bình cộng ước chung lớn nhất cua " + a +" va " + b +" : " + sum);
//        for (int i = 1; i <= a; i++) {
//            for (int j = 1; j <= b; j++) {
//                if(((a*i) == (b*j))){
//                    System.out.println("Trung bình cộng bội chung nhỏ nhất cua " + a +" va " + b +" : "+ ((a*i) + (b*j))/2);
//                    return;
//                }
//            }
//        }
//    }

}
