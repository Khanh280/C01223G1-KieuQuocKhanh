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
           System.out.println("Chọn chức năng." +
                   "\n1. Display" +
                   "\n2. Add" +
                   "\n3. Delete" +
                   "\n4. Edit" +
                   "\n5. Exit");
           String str = sc.nextLine();
           flag = true;
           if ( !str.equals("")){
               int choose = Integer.parseInt(str);
               switch (choose) {
                       case 1:
                           System.out.println("---------------CodeGymStudent---------------");
                           studentManeger.display();
                           break;
                       case 2:
                           studentManeger.add();
                           break;
                       case 3:
                           studentManeger.delete();
                           break;
                       case 4:
                           studentManeger.edit();
                           break;
                       case 5:
                           flag = false;
                           System.out.print("Exit.....");
                           break;
                   }
           } else{
               System.out.println("Vui lòng chọn đúng chức năng. ");
           }
       } while(flag);
    }
}
