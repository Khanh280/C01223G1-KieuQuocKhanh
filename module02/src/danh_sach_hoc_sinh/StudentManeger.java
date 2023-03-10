package danh_sach_hoc_sinh;

import java.util.Scanner;

public class StudentManeger {
    Scanner sc = new Scanner(System.in);
    static CodeGymStudent[] students = new CodeGymStudent[10];

    public void display() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].id != 0) {
                    System.out.println(students[i] + "\n");
                }
            } else {
                break;
            }
        }
    }

    public void add() {
        inputInfo();

    }

    public void delete() {
        System.out.print("Nhap id ban muon xoa: ");
        int id = Integer.parseInt(sc.nextLine());
        int count=0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && id == students[i].id) {
                students[i] = new CodeGymStudent(0, null,null);
                break;
            } else {
                count++;
            }
            if (count == students.length){
                System.out.print("id khong ton tai");
            }
        }
    }

    public void inputInfo() {
        System.out.print("Nhap id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap lop: ");
        String classes = sc.nextLine();
        CodeGymStudent student = new CodeGymStudent(id, name, classes);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

}
