package array_list_linkded_list.linked_list;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        LinkedList ll = new LinkedList(a);
        ll.printList();
    }
}
