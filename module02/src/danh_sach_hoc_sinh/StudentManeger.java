package danh_sach_hoc_sinh;

import java.util.Scanner;

public class StudentManeger {
    Scanner sc = new Scanner(System.in);
    static CodeGymStudent[] students = new CodeGymStudent[5];

    public void display() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() != 0) {
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
        System.out.print("Nhập id bạn muốn xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        int count=0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && id == students[i].getId()) {
                students[i] = new CodeGymStudent(0, null,null);
                System.out.println("Đã xóa thành công id:" + id);
                break;
            } else {
                count++;
            }
            if (count == students.length){
                System.out.println("Id không tồn tại.");
            }
        }
    }

    public  void edit(){
        System.out.print("Nhập id bạn muốn sửa: ");
        String id1 = sc.nextLine();
        if ( !id1.equals("")){
            int id = Integer.parseInt(id1);
            int count=0;
            for (int i = 0; i < students.length; i++) {
                if ( students[i] == null){
                    System.out.println("Id " + id + " không tồn tại.");
                    break;
                } else if (id == students[i].getId() && students[i] != null) {
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập lớp: ");
                    String classes = sc.nextLine();
                    students[i] = new CodeGymStudent(id, name,classes);
                    break;
                } else  {
                    count++;
                }
                if (count == students.length){
                    System.out.println("Id không tồn tại.");
                }
            }
        } else {
            System.out.println("Vui lòng nhập đúng id.");
        }
    }
    public void inputInfo() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập lớp: ");
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
