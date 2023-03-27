package io_binary_file.coppy_file_binary;

import java.io.*;
import java.util.Scanner;

public class ReadAndWriteFileBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tệp nguồn: ");
        String sourceFile = scanner.nextLine();
        String stringList = readSourceToTarget(sourceFile);
        System.out.print("Nhập tệp đích: ");
        String targetFile = scanner.nextLine();
        writeSourceToTarget(targetFile, stringList, false);
    }

    public static void writeSourceToTarget(String namePath, String stringList, boolean append) {
        File file = new File(namePath);
        FileOutputStream fileOutputStream = null;
        try {
            if(!file.exists()){
                throw new FileNotFoundException("File đích không tồn tại.");
            }
            fileOutputStream = new FileOutputStream(file);
            byte[] bytes = stringList.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                fileOutputStream.write(b);
            }
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readSourceToTarget(String namePath) {
        StringBuilder result = new StringBuilder();
        File file = new File(namePath);
        FileInputStream fileInputStream = null;
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("File nguồn không tồn tại.");
            }
            fileInputStream = new FileInputStream(file);
            int i = -1;
            System.out.println("Số byte trong tệp nguồn: ");
            while ((i = fileInputStream.read()) != -1) {
                result.append((char) i);
                System.out.println(i);
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
