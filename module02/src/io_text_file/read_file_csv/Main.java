package io_text_file.read_file_csv;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> list = ReadFileCsv.readFile("src/io_file/read_file_csv/country.csv");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
