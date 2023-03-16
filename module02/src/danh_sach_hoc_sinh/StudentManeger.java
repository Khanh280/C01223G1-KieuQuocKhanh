package danh_sach_hoc_sinh;

import java.util.Scanner;

public class StudentManeger {
    Scanner sc = new Scanner(System.in);
    CodeGymStudent[] students = new CodeGymStudent[10];

    public void display() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i] + "\n");
            }
        }
    }

    public void add() {
        System.out.print("Nhập id: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < students.length; i++) {
                if (id > 0 && students[i] == null) {
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập lớp: ");
                    String classes = sc.nextLine();
                    CodeGymStudent student = new CodeGymStudent(id, name, classes);
                    students[i] = student;
                    break;
                } else if (id > 0 && id == students[i].getId()) {
                    System.out.println("Id đã tồn tại.");
                    break;
                } else {
                    System.out.println("Id > 0 & Id phải là số.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Id > 0 & Id phải là số.");
        }
    }

    public void delete() {
        System.out.print("Nhập id bạn muốn xóa: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            int count = 0;
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null && id == students[i].getId()) {
                    students[i] = null;
                    System.out.println("Đã xóa thành công id:" + id);
                    students[i] = students[i + 1];
                    students[i + 1] = null;
                    break;
                } else {
                    count++;
                }
                if (count == students.length) {
                    System.out.println("Id không tồn tại.");
                }
            }
        } catch (Exception e) {
            System.out.println("Vui lòng nhập đúng Id.");
        }
    }

    public void edit() {
        System.out.print("Nhập id bạn muốn sửa: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            int count = 0;
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    System.out.println("Id " + id + " không tồn tại.");
                    break;
                } else if (id == students[i].getId() && students[i] != null) {
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập lớp: ");
                    String classes = sc.nextLine();
                    students[i] = new CodeGymStudent(id, name, classes);
                    break;
                } else {
                    count++;
                }
                if (count == students.length) {
                    System.out.println("Id không tồn tại.");
                }
            }
        } catch (Exception e) {
            System.out.println("Vui lòng nhập đúng id.");
        }
    }
}
