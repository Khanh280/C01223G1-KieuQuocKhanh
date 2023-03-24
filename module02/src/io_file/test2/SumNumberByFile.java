package io_file.test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumNumberByFile {
    public List<Integer> readFileInteger(String urlFile){
        List<Integer> list = new ArrayList<>();
        try{
            FileReader readFile = new FileReader(urlFile);
            BufferedReader bufferedReader = new BufferedReader(readFile);
            int line=0;
            while (true){
                line = Integer.parseInt(bufferedReader.readLine());
                list.add(line);
            }
        } catch (Exception e){
        }
        return  list;
    }
    public static void main(String[] args) {
        SumNumberByFile sumNumberByFile = new SumNumberByFile();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap duong dan File can doc: ");
        String urlFile = scanner.nextLine();
        List<Integer> list = sumNumberByFile.readFileInteger(urlFile);
        int sum=0;
        for (Integer i:list) {
            sum+=i;
            System.out.println(i);
        }
        System.out.println(sum);
    }
}
