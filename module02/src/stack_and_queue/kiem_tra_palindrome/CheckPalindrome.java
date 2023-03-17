package stack_and_queue.kiem_tra_palindrome;

import java.util.*;

public class CheckPalindrome {
    public static void main(String[] args) {

        Stack<Character> check = new Stack<>();
        ArrayDeque<Character> check2 = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi để kiểm tra: ");
        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); i++) {
            check.add(str.charAt(i));
            check2.addLast(str.charAt(i));
        }

        int size = check.size();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (check2.pop() != check.pop()) {
                System.out.println(str + " không phải chuỗi Palindrome.");
                break;
            } else {
                count++;
            }
            if (count == size / 2) {
                System.out.println(str + " là một chuỗi Palindrome.");
            }
        }
    }
}
