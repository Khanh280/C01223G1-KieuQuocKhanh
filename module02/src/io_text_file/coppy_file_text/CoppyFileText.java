package io_text_file.coppy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoppyFileText {
    public static List<String> readFileToList(String nameFile) throws IOException {
        List<String> stringList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        File file = new File(nameFile);
        if (!file.exists()) {
            throw new FileNotFoundException("Tập tin không tồn tại.");
        }
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        String string = null;
        while ((string = bufferedReader.readLine()) != null) {
            stringList.add(string);

        }
        bufferedReader.close();
        fileReader.close();
        int count=0;
        for (int i = 0; i < stringList.size(); i++) {
            String[] str= stringList.get(i).split("");
            for (int j = 0; j < str.length; j++) {
                if (!str[j].equals(" ")){
                    count++;
                }
            }
        }
        System.out.println("Tổng số ký tự trong file: " + count);
        return stringList;
    }

    public static void writeListToFile(List<String> stringList, String nameFile, boolean appent) {
        File file = new File(nameFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (file.exists()) {
                System.out.println("Tập tin đã tồn tại.");
                System.exit(0);
            }
            fileWriter = new FileWriter(file, appent);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < stringList.size(); i++) {
                bufferedWriter.write(stringList.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
