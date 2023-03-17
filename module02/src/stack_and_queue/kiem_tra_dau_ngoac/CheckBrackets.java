package stack_and_queue.kiem_tra_dau_ngoac;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi để kiểm tra: ");
        String str = scanner.nextLine();
        System.out.println(checkBrakets(str));

    }

    public static boolean checkBrakets(String str) {
        Stack<Character> bStack = new Stack<>();
        for (Character c : bStack) {
            if (c == '(' || c == '[' || c == '{') {
                bStack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (bStack.isEmpty()) {
                    return false;
                }
                char left = bStack.pop();
                if ((left == '(' && c != ')') || (left == '[' && c != ']') || (left == '{' && c != '}')) {
                    return false;
                }
            }
        }
        return true;
    }
}
