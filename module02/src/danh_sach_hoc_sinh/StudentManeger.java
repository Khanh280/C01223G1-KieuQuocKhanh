package danh_sach_hoc_sinh;

import java.util.Scanner;

public class StudentManeger {
    Scanner sc = new Scanner(System.in);
    CodeGymStudent[] students = new CodeGymStudent[5];

    public void display() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
//                if (students[i].getId() != 0) {
                    System.out.println(students[i] + "\n");
//                }
            } else {
                break;
            }
        }
    }

    public void add() {
        System.out.print("Nhập id: ");
        String strId = sc.nextLine();
        if (!strId.equals("") && strId.matches("-?\\d+")) {
            int id = Integer.parseInt(strId);
            for (int i = 0; i < students.length; i++) {
                if (id > 0 && students[i] == null) {
                        System.out.print("Nhập tên: ");
                        String name = sc.nextLine();
                        System.out.print("Nhập lớp: ");
                        String classes = sc.nextLine();
                        CodeGymStudent student = new CodeGymStudent(id, name, classes);
                        for (int j = 0; i < students.length; j++) {
                            if (students[j] == null) {
                                students[j] = student;
                                break;
                            }
                        }
                    break;
                } else if (id > 0 && id == students[i].getId()){
                    System.out.println("Id đã tồn tại.");
                    break;
                } else {
                    System.out.println("Id > 0 & Id phải là số.");
                    break;
                }
            }
        } else {
            System.out.println("Id > 0 & Id phải là số.");
        }
    }

    public void delete() {
        System.out.print("Nhập id bạn muốn xóa: ");
        String strId = sc.nextLine();
        if (!strId.equals("") && strId.matches("-?\\d+")) {
            int id = Integer.parseInt(strId);
            int count = 0;
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null) {
                    if (id == students[i].getId()) {
                        students[i] = new CodeGymStudent(0, null, null);
                        System.out.println("Đã xóa thành công id:" + id);
                        break;
                    } else {
                        System.out.println("Id không tồn tại.");
                    }
                } else {
                    count++;
                }
                if (count == students.length) {
                    System.out.println("Id không tồn tại.");
                }
            }
        } else {
            System.out.println("Vui lòng nhập đúng Id.");
        }
    }

    public void edit() {
        System.out.print("Nhập id bạn muốn sửa: ");
        String strId = sc.nextLine();
        if (!strId.equals("") && strId.matches("-?\\d+")) {
            int id = Integer.parseInt(strId);
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
        } else {
            System.out.println("Vui lòng nhập đúng id.");
        }
    }

}
