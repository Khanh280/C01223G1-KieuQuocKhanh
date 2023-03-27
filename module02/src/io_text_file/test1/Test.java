package io_text_file.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void writeFile(List<Student> students) {
        try {
            FileWriter fw = new FileWriter("test.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {

        }
    }

    public List<Student> readFile() {
        List<Student> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split("-");
                String name = txt[0];
                int id = Integer.parseInt(txt[1]);
                int age = Integer.parseInt(txt[2]);
                list.add(new Student(name, id, age));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //    public static List<Student> readFile(){
//        List<Student> students = new ArrayList<>();
//        try{
//            FileReader fr = new FileReader("test.txt");
//            BufferedReader br = new BufferedReader(fr);
//            String line = "";
//            while (true){
//                line = br.readLine();
//                if ( line == null){
//                    break;
//                }
//                String[] txt = line.split("-");
//                String name = txt[0];
//                int id = Integer.parseInt(txt[1]);
//                int age = Integer.parseInt(txt[2]);
//                students.add(new Student(name, id, age));
//            }
//        } catch ( Exception e){
//
//        }
//        return  students;
//    }
    public static void main(String[] args) {

        Student s1 = new Student("Khanh", 1, 22);
        Student s2 = new Student("Khanh1", 2, 23);
        Student s3 = new Student("Khanh2", 3, 24);
        Student s4 = new Student("Khanh3", 4, 25);
        Student s5 = new Student("Khanh4", 5, 26);
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
//        writeFile(students);
        Test t = new Test();
        List<Student> list = t.readFile();
        for (Student l : list) {
            System.out.println(l);
        }
//        writeFile(students);
//        readFile();
//        List<Student> list =readFile();
//        for (Student l: list) {
//            System.out.println(l);
//        }


    }
}
