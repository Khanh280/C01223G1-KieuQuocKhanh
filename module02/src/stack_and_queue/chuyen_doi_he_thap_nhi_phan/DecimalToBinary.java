package stack_and_queue.chuyen_doi_he_thap_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số hệ thập phân: ");
        int decimal = Integer.parseInt(scanner.nextLine());
        toBinary(decimal);
    }

    public static void toBinary(int decimal) {
        Stack<Integer> binary = new Stack<>();
        for (int i = decimal; i > 0; i = i / 2) {
            if (i % 2 == 0) {
                binary.add(0);
            } else {
                binary.add(1);
            }
        }
        int size = binary.size();
        System.out.print(decimal + " sau khi chuyển sang hệ nhị phân: ");
        for (int i = 0; i < size; i++) {
            System.out.print(binary.pop());
        }
    }
}
