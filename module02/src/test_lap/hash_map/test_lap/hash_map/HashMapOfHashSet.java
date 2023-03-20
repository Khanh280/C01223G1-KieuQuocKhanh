package test_lap.hash_map.test_lap.hash_map;

import java.util.*;


public class HashMapOfHashSet {

    public static void main(String[] args) {
        Student hashMapOfHashSet1 = new Student("Khanh1", 23, "Quang Nam");
        Student hashMapOfHashSet2 = new Student("Khanh2", 25, "Quang Nam");
        Student hashMapOfHashSet3 = new Student("Khanh3", 28, "Quang Nam");
        Student hashMapOfHashSet4 = new Student("Khanh4", 30, "Quang Nam");
        Map<Integer, Student> studentHashMap = new HashMap<>();
        studentHashMap.put(4, hashMapOfHashSet4);
        studentHashMap.put(2, hashMapOfHashSet2);
        studentHashMap.put(1, hashMapOfHashSet1);
        studentHashMap.put(3, hashMapOfHashSet3);

        Set<Student> studentHashSet = new HashSet<>();
        studentHashSet.add(hashMapOfHashSet1);
        studentHashSet.add(hashMapOfHashSet2);
        studentHashSet.add(hashMapOfHashSet3);
        studentHashSet.add(hashMapOfHashSet4);
        System.out.println(studentHashMap + "\n");
        System.out.println(studentHashSet + "\n");
    }
}
    class Student{
        public String name;
        public int age;
        public String address;

        public Student(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Student(int age, String address) {
//        this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Student{" +
//                "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    '}';
        }

//        @Override
//        public int compareTo(Student o) {
//            return this.age - o.age;
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }
    }


