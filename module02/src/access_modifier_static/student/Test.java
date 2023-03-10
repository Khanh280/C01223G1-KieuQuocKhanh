package access_modifier_static.student;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine();
        if (!name.equals("")){
            System.out.print("Nhập lớp: ");
            String classes = sc.nextLine();
            student.setName(name);
            student.setClasses(classes);
            System.out.print("Họ tên: " + student.getName() + "\nLớp: " + student.getClasses());
        } else{
            System.out.println(student.toString());
        }
    }
}
