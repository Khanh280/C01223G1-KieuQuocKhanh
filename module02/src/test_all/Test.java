package test_all;

import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(5);
//        list.add(4);
//        list.add(6);
//        list.add(2);
//        System.out.println(solve("MCMXCIV"));
        System.out.println(solve(0, 3));
//        System.out.println(solve(2, list));
    }

    //cau 2
//    public static int getCluster(int fileSize) {
//        int bytes = 4096;
//        int kb = fileSize/bytes;
//        int kbs = fileSize%bytes;
//        int result = kb*4;
//        if(kbs>0){
//            return result+4;
//        }
//        return kb;
//    }
    //cau 3
//    public static String solve(String s) {
//        String[] str = s.split("");
//        String result = "True";
//        for (int i = 0; i < str.length; i += 2) {
//            if ((i+1)>=str.length) {
//                result = "False";
//            } else {
//                if (str[i].equals("(") && str[i + 1].equals(")")) {
//
//                } else if (str[i].equals("[") && str[i + 1].equals("]")) {
//
//                } else if (str[i].equals("{") && str[i + 1].equals("}")) {
//
//                } else {
//                    result = "False";
//                }
//            }
//        }
//        return result;
//    }
    //cau 4
//    public static int solve(int n, List<Integer> numbers) {
//        if (n <= 1) {
//            return 0;
//        }
//        if (numbers.size() < 2) {
//            return 0;
//        }
//        int jump = numbers.get(1) - numbers.get(0);
//        for (int i = 2; i < numbers.size(); i++) {
//            if (numbers.get(i) - numbers.get(i - 1) != jump) {
//                return 0;
//            }
//        }
//        return 1;
//    }

    //cau 6 Sửa chuỗi nối liền
//    public static String solve(String s) {
//        String[] str = s.split("");
//        StringBuilder newStr = new StringBuilder();
//        for (int i = 0; i < str.length; i++) {
//            if (str[i].equals(str[i].toUpperCase()) && !str[i].equals(" ")) {
//                newStr.append(" " + str[i].toLowerCase());
//            } else {
//                newStr.append(str[i]);
//            }
//        }
//        return newStr.toString().trim();
//    }

    //cau  Tìm số cuối cùng của n!
//    public static int solve(int a) {
//        int num = 1;
//        for (int i = 1; i <= a; i++) {
//            num *= i;
//        }
//        String str = String.valueOf(num);
//        String[] numArr = str.split("");
//        for (int i = numArr.length-1; i >=0; i--) {
//            if(!numArr[i].equals("0")){
//                return Integer.parseInt(numArr[i]);
//            }
//        }
//        return -1;
//    }
    //cau 7 Chữ Số La Mã
    //    public static int solve(String s) {
    ////        MCMXCIV
    //        Map<Character, Integer> lama = new HashMap<>();
    //        lama.put('I', 1);
    //        lama.put('V', 5);
    //        lama.put('X', 10);
    //        lama.put('L', 50);
    //        lama.put('C', 100);
    //        lama.put('D', 500);
    //        lama.put('M', 1000);
    //        int result = 0;
    //        int n = s.length();
    //        for (int i = 0; i < s.length(); i++) {
    //            int currentNum = lama.get(s.charAt(i));
    //            if (i < n - 1 && currentNum < lama.get(s.charAt(i+1))) {
    //                result -= currentNum;
    //            }else {
    //                result += currentNum;
    //            }
    //        }
    //        return result;
    //    }

    //cau 9 Tìm kí tự chung giữa 2 chuỗi
//    public static int solve(String s1, String s2) {
//        String[] str1 = s1.split("");
//        String[] str2 = s2.split("");
//        Arrays.sort(str2);
//        Map<String, Integer> map = new HashMap<>();
//        int count = 0;
//        for (int i = 0; i < str1.length; i++) {
//            for (int j = 0; j < str2.length; j++) {
//                if (str1[i].equals(str2[j])) {
//                    if (!map.containsKey(str2[j])) {
//                        map.put(str2[j], 1);
//                        str2[j] = null;
//                    } else {
//                        map.put(str2[j], map.get(str2[j]) + 1);
//                        str2[j] = null;
//                    }
//                    count++;
//                    break;
//                }
//            }
//        }
//        return count;
//    }
    // cau 10 Tìm số lớn thứ nhì
//    public static int solve(int n, List<Integer> numbers) {
//        int max1 = numbers.get(0);
//        for (int i = 1; i < numbers.size(); i++) {
//            if (max1 < numbers.get(i)) {
//                max1 = numbers.get(i);
//            }
//        }
//        int max2 = 0;
//        for (int i = 0; i < numbers.size(); i++) {
//            if (numbers.get(i) == max1) {
//                continue;
//            }
//            if (max2 < numbers.get(i)) {
//                max2 = numbers.get(i);
//            }
//        }
//        for (int i = 0; i < numbers.size(); i++) {
//            if (numbers.get(i) == max2) {
//                return i;
//            }
//        }
//        return -1;
//    }
    // cau xx dem so tu khac nhau xuat hien
//    public static int solve(String s) {
//        Map<Character,Integer> map = new HashMap<>();
//        int count=0;
//        for (int i = 0; i < s.length(); i++) {
//            if(!map.containsKey(s.charAt(i))){
//                count++;
//                map.put(s.charAt(i),1);
//            }
//        }
//    return count;
//    }
//Liệt kê phần tử bắt đầu là số lẻ
//    public static List<Integer> getOddHeadNumbers(String s) {
//        List<Integer> list = new ArrayList<>();
//        String[] str = s.split(" ");
//        for (int i = 0; i < str.length; i++) {
//            if (str[i].charAt(0) % 2 != 0) {
//                list.add(Integer.valueOf(str[i]));
//            }
//        }
//        if (list.size() > 0) {
//            return list;
//        }else {
//            list.add(-1);
//            return list;
//        }
//    }

//    public static String solve(String parentString, String childString) {
//        // Write your code here
//        int count = 0;
//        for (int i = 0; i < childString.length(); i++) {
//            for (int j = i; j < parentString.length(); j++) {
//                if (childString.charAt(i) == parentString.charAt(j)) {
//                    count++;
//                    break;
//                }
//            }
//        }
//        if (count == childString.length()) {
//            return "1";
//        }
//        return "0";
//    }

    //    public static int solve(int n, List<Integer> a) {
//        int result = 0;
//        List<String> newStr = new ArrayList<>();
//        for (int i = 0; i < a.size(); i++) {
//            String str = "";
//            for (int j = 0; j <a.size(); j++) {
//                if(a.get(j)<a.get(j+1)){
//                    str+=a.get(j);
//                }else {
//                    str+=a.get(i);
//                    break;
//                }
//            }
//            newStr.add(str);
//        }
//        System.out.println(newStr);
//        return result;
//    }
    public static int solve(int k, int n) {
        List<Integer> list = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            list.add(j);
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < list.size(); j++) {
                list.set(j, list.get(j) * list.get(j));
            }
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        String as = String.valueOf(String.valueOf(result).charAt(String.valueOf(result).length() - 1));
        return Integer.parseInt(as);
    }
}

