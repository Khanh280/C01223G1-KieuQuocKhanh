package code_gym_manager.service;

import code_gym_manager.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService extends Student implements IServiceStudent {
    static ArrayList<Student> students = new ArrayList<>();
    static Student student = new Student();
    Scanner sc = new Scanner(System.in);

    @Override
    public void addStudent() {
        System.out.print("Nhập mã học viên: ");
        int id = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                System.out.println("Mã học viên đã tồn tại.");
                return;
            } else {
                count++;
            }
        }
        if (count == students.size()) {
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("Nhập ngày sinh: ");
            String birthDay = sc.nextLine();
            System.out.print("Nhập giới tính: ");
            String gender = sc.nextLine();
            System.out.print("Nhập lớp: ");
            String classes = sc.nextLine();
            System.out.print("Nhập điểm số: ");
            int point = Integer.parseInt(sc.nextLine());
            student = new Student(id, name, birthDay, gender, classes, point);
            students.add(student);
        }
    }

    @Override
    public void displayStudentList() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    @Override
    public void deleteStudent() {
        System.out.println("Nhập mã học viên muốn xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                try {
                    System.out.println("Bạn xác nhận xóa " + id + " không. " +
                            "\n1. Yes " +
                            "\n2. No ");
                    int choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                        case 1:
                            students.remove(students.get(i));
                            System.out.println("Bạn đã xóa thành công học viên " + id);
                            break;
                        case 2:
                            System.out.println("Bạn đã không xóa");
                            break;
                    }
                    return;
                } catch (Exception e) {
                    System.out.println("Yes or No.");
                }
            } else {
                count++;
            }
            if (count == students.size()) {
                System.out.println("Mã học viên không tồn tại");
                return;
            }
        }
        System.out.println("Danh sách hiện tại đang trống.");
    }
}
