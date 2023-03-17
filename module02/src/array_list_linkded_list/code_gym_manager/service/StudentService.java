package array_list_linkded_list.code_gym_manager.service;

import array_list_linkded_list.code_gym_manager.model.CodeGymPerson;
import array_list_linkded_list.code_gym_manager.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    public void addStudent(){
        System.out.print("Nhap ma hoc vien: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        String birthDay = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gender = sc.nextLine();
        System.out.print("Nhap lop: ");
        String classes = sc.nextLine();
        System.out.print("Nhap diem so: ");
        int point = Integer.parseInt(sc.nextLine());
        Student student = new Student(id,name,birthDay,gender,classes,point);
        students.add(student);
    }

    public  void displayStudentList(){
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
