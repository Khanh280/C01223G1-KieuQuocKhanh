package code_gym_manager.controller;

import code_gym_manager.service.IntructorService;
import code_gym_manager.service.StudentService;

import java.util.Scanner;

public class MainMenu {
    static StudentService studentService = new StudentService();
    static IntructorService intructorService = new IntructorService();
    static Scanner sc = new Scanner(System.in);

    public static void displayList() {
        boolean flag;
        do {
            flag = true;
            try {
                System.out.print("Chọn chức năng: " +
                        "\n1. Thêm mới giảng viên hoặc học sinh." +
                        "\n2. Xóa giảng viên hoặc học sinh." +
                        "\n3. Xem danh sách giảng viên hoặc học sinh." +
                        "\n4. Thoát." +
                        "\n Chọn chức năng: ");
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        addIntructorOrStudent();
                        break;
                    case 2:
                        deleteIntructorOrStudent();
                        break;
                    case 3:
                        displayIntructorOrStrudent();
                        break;
                    case 4:
                        System.out.print("Thoát........");
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.print("Vui lòng ");
            }
        } while (flag);
    }

    public static void addIntructorOrStudent() {
        boolean flag;
        do {
            flag = true;
            try {
                System.out.println("Chọn chức năng: " +
                        "\n1. Thêm mới giảng viên." +
                        "\n2. Thêm mới học sinh." +
                        "\n3. Quay lại.");
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        intructorService.addIntructor();
                        break;
                    case 2:
                        studentService.addStudent();
                        break;
                    case 3:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.print("Vui lòng ");
            }
        } while (flag);
    }

    public static void displayIntructorOrStrudent() {
        boolean flag;
        do {
            flag = true;
            try {
                System.out.println("Chọn chức năng: " +
                        "\n1. Xem danh  sách giảng viên." +
                        "\n2. Xem danh  sách học sinh." +
                        "\n3. Quay lại.");
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("--------------------CODE GYM INTRUCTOR-----------------");
                        System.out.println("+---+----------+-------------+--------+--------+------+");
                        intructorService.displayIntructortList();
                        break;
                    case 2:
                        System.out.println("--------------------CODE GYM STUDENT-------------------");
                        System.out.println("+----+----------+-------------+-----------+--------+------+");
                        System.out.println("| ID |    Tên   |  Ngày Sinh  | Giới Tính |   Lớp  | Điểm |");
                        System.out.println("+----+----------+-------------+-----------+--------+------+");
                        studentService.displayStudentList();
                        System.out.println("+----+----------+-------------+-----------+--------+------+");
                        break;
                    case 3:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.print("Vui lòng ");
            }
        } while (flag);

    }

    public static void deleteIntructorOrStudent() {
        boolean flag;
        do {
            flag = true;
            try {
                System.out.println("Chọn chức năng: " +
                        "\n1. Xoá giảng viên." +
                        "\n2. Xoá học sinh." +
                        "\n3. Quay lại.");
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        intructorService.deleteIntructor();
                        break;
                    case 2:
                        studentService.deleteStudent();
                        break;
                    case 3:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.print("Vui lòng ");
            }
        } while (flag);
    }
}
