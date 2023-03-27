package io_text_file.coppy_file_text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file muốn coppy: ");
        String path = scanner.nextLine();
        List<String> stringList = new ArrayList<>();
        try {
            stringList = CoppyFileText.readFileToList(path);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Dữ liệu trong file bạn muốn coppy: ");
        for (String s : stringList) {
            System.out.println(s);
        }
        System.out.print("Nhập file đích muốn sao chép dữ liệu: ");
        String path1 = scanner.nextLine();
        System.out.print("Nhập true để ghi thêm dữ liệu vào file, false để ghi đè dữ liệu cũ: ");
        boolean choose = scanner.nextBoolean();
        CoppyFileText.writeListToFile(stringList, path1, choose);
        System.out.println("Đã sao chép thành công.");

    }
}
