package code_gym_manager.service;

import code_gym_manager.model.Intructor;

import java.util.ArrayList;
import java.util.Scanner;

public class IntructorService extends Intructor implements IServiceIntructor {
    Scanner sc = new Scanner(System.in);
    static ArrayList<Intructor> intructors = new ArrayList<>();
    static Intructor intructor = new Intructor();

    @Override
    public void addIntructor() {
        System.out.print("Nhập mã giảng viên: ");
        int id = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; i < intructors.size(); i++) {
            if (id == intructors.get(i).getId()) {
                System.out.println("Mã giảng viên đã tồn tại.");
            } else {
                count++;
            }
        }
        if (count == intructors.size()) {
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("Nhập ngày sinh: ");
            String birthDay = sc.nextLine();
            System.out.print("Nhập giới tính: ");
            String gender = sc.nextLine();
            System.out.print("Nhập chuyên môn: ");
            String knowledge = sc.nextLine();
            intructor = new Intructor(id, name, birthDay, gender, knowledge);
            intructors.add(intructor);
        }
    }

    @Override
    public void displayIntructortList() {
        for (int i = 0; i < intructors.size(); i++) {
            System.out.println(intructors.get(i));
            ;
        }
    }

    @Override
    public void deleteIntructor() {
        System.out.println("Nhập mã giảng viên muốn xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; i < intructors.size(); i++) {
            if (id == intructors.get(i).getId()) {
                try {
                    System.out.println("Bạn xác nhận xóa " + id + " không. " +
                            "\n1. Yes " +
                            "\n2. No ");
                    int choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                        case 1:
                            intructors.remove(intructors.get(i));
                            System.out.println("Bạn đã xóa thành công giảng viên  " + id);
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
            if (count == intructors.size()) {
                System.out.println("Mã giảng viên không tồn tại");
                return;
            }
        }
        System.out.println("Danh sách hiện tại đang trống.");
    }
}
