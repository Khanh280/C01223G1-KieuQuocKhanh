package hacker_rank;

import java.util.*;

public class HackerRank {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> listSub = new ArrayList<>();
        listSub.add(20);
        listSub.add(25);
//        listSub.add(2);
//        listSub.add(5);
//        listSub.add(10);
        list.add(listSub);
        System.out.println(solve(5, list));
//        System.out.println(solve(12, 2, listSub));
    }

    public static List<String> solve(List<String> crossword, String words) {
        // Write your code here
        List<String> str = new ArrayList<>();
        str.add("++++++++++");
        str.add("+POLAND+++");
        str.add("+++H++++++");
        str.add("+++A++++++");
        str.add("+++SPAIN++");
        str.add("+++A++N+++");
        str.add("++++++D+++");
        str.add("++++++I+++");
        str.add("++++++A+++");
        str.add("++++++++++");
        return str;
    }


    public static int solve(int n, int m, List<Integer> coins) {
        // Write your code here
        int count = 0;
        Collections.sort(coins);
        for (int i = coins.size() - 1; i >= 0; i--) {

            for (int j = 0; j < coins.size(); j++) {
                if (i == 0 && j == coins.size() - 1) {
                    break;
                } else {
                    int result = coins.get(i);
                    while (result <= n) {

                        result += coins.get(j);
                        if (result == n) {
                            count++;
                            break;
                        } else if (result > n) {
                            break;
                        }
                    }
                }
            }
            System.out.println(count);
        }
        return count;
    }

    public static int solve(int T, List<List<Integer>> numbers) {
        // Write your code here
        Integer numT = 10 * 10 * 10 * 10;
        if (T >= 1 && T <= numT) {
            int count = 0;
            for (int i = 0; i < numbers.size(); i++) {
                Integer numa = numbers.get(i).get(0);
                Integer numb = numbers.get(i).get(1);
                for (int k = numa; k <= numb; k++) {
                    String str = String.valueOf(k);
                    String[] newStr = str.split("");
                    Integer numSum = 0;
                    Integer numX2 = 0;
                    for (int h = 0; h < newStr.length; h++) {
                        numSum += Integer.parseInt(newStr[h]);
                        numX2 += Integer.parseInt(newStr[h]) * Integer.parseInt(newStr[h]);
                    }
                    boolean check = checkNum(numSum, numX2);
                    if (check) {
                        count++;
                    }
                }
            }
            return count;
        }
        return 0;
    }

    public static boolean checkNum(Integer num, Integer numX2) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count1++;
            }
        }
        for (int i = 1; i <= numX2; i++) {
            if (numX2 % i == 0) {
                count2++;
            }
        }
        if (count1 == 2 && count2 == 2) {
            return true;
        }
        return false;
    }

//    public static int solve(String S) {
//        // Write your code here
//        String[] str = S.split("");
//        int count = 0;
//        for (int i = 0; i < str.length; i++) {
//            switch (str[i]) {
//                case "<":
//                    if (i != 0) {
//                        if (!str[i - 1].equals(">")) {
//                            count++;
//                        }
//                    } else {
//                        count++;
//                    }
//                    break;
//                case ">":
//                    if (i + 1 != str.length) {
//                        if (!str[i + 1].equals("<") && !str[i+1].equals(">")) {
//                            count++;
//                        }
//                    } else {
//                        count++;
//                    }
//                    break;
//                case "^":
//                    count++;
//                    break;
//                case "V":
//                    count++;
//                    break;
//            }
//        }
//        return count;
//    }
}
