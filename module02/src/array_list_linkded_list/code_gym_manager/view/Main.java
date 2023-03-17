package array_list_linkded_list.code_gym_manager.view;

import array_list_linkded_list.code_gym_manager.service.IntructorService;
import array_list_linkded_list.code_gym_manager.service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        displayList();
    }

    public static  void displayList(){
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        IntructorService intructorService = new IntructorService();
        boolean flag;
        do {
            flag = true;
            System.out.print("Chọn chức năng: " +
                    "\n1. Thêm mới giảng viên hoặc học sinh." +
                    "\n2. Xóa giảng viên hoặc học sinh." +
                    "\n3. Xem danh sách giảng viên hoặc học sinh." +
                    "\n4. Thoát."+
                    "\n Chon chuc nang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    addIntructorOrStudent();
                    break;
                case 2:
                    break;
                case 3:
                    displayIntructorOrStrudent();
                    break;
                case 4:
                    flag = false;
            }
        } while (flag);
    }

    public static void addIntructorOrStudent(){
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        IntructorService intructorService = new IntructorService();
        System.out.print("Chọn chức năng: " +
                "\n1. Thêm mới giảng viên." +
                "\n2. Thêm mới học sinh." +
                "\n3. Thoat.");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose){
            case 1:
                break;
            case 2:
                studentService.addStudent();
                break;
            case 3:
        }
    }

    public static void displayIntructorOrStrudent(){
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        IntructorService intructorService = new IntructorService();
        System.out.print("Chọn chức năng: " +
                "\n1. Xem danh  sach giảng viên." +
                "\n2. Xem danh  sach học sinh." +
                "\n3. Thoat.");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose){
            case 1:
                break;
            case 2:
                studentService.displayStudentList();
                break;
            case 3:
        }
    }
}
