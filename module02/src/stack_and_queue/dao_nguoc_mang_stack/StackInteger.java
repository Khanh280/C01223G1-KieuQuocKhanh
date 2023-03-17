package stack_and_queue.dao_nguoc_mang_stack;

import java.util.Stack;

public class StackInteger {
    public static void main(String[] args) {
        stackInteger();
        stackCharacter();
    }
    public static void stackInteger() {
        Stack<Integer> integers = new Stack<>();
        Stack<Integer> arr = new Stack<>();
        {
            arr.add(1);
            arr.add(2);
            arr.add(3);
            arr.add(4);
            arr.add(5);
        }
        int sizeArr = arr.size();
        for (int i = 0; i < sizeArr; i++) {
            integers.push(arr.pop());
        }
        System.out.println("Sau khi push n phần tử vào Stack: ");
        for (int i = 0; i < sizeArr; i++) {
            arr.push(integers.peek());
            System.out.print(integers.pop());
        }

        System.out.println("\nSau khi push n phần tử từ Stack trở lại mảng n: ");
        for (int i = 0; i < sizeArr; i++) {
            System.out.print(arr.pop());
        }
    }

    public static void stackCharacter() {
        Stack<String> wStack = new Stack<>();
        Stack<String> mWord = new Stack<>();
        {
            mWord.add(" Hello ");
            mWord.add(" My ");
            mWord.add(" Friend ");
        }

        int sizeWord = mWord.size();
        for (int i = 0; i < sizeWord; i++) {
            wStack.push(mWord.pop());
        }

        System.out.println("\nSau khi push từ mWord vào wStack: ");
        for (int i = 0; i < sizeWord; i++) {
            mWord.push(wStack.peek());
            System.out.println(wStack.pop());
        }

        System.out.println("Sau khi push từ wStack vào wmWord: ");
        for (int i = 0; i < sizeWord; i++) {
            System.out.println(mWord.pop());
        }
    }
}
