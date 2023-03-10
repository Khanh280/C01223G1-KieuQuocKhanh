package danh_sach_hoc_sinh;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);
        StudentManeger studentManeger = new StudentManeger();
        boolean flag;
       do {
           flag = true;
           System.out.println("Chon chuc nang" +
                   "\n1. Display" +
                   "\n2. Add" +
                   "\n3. Delete" +
                   "\n4. Exit");
           int choose = Integer.parseInt(sc.nextLine());
           switch (choose) {
               case 1:
                   System.out.println("CodeGymStudent\n---------------");
                   studentManeger.display();
                   break;
               case 2:
                   studentManeger.add();
                   break;
               case 3:
                   studentManeger.delete();
                   break;
               case 4:
                   flag = false;
                   break;
           }
       } while(flag);
    }
}
