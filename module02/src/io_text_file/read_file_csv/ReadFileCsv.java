package io_text_file.read_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCsv {
    static List<Country> countryList = new ArrayList<>();
    static Country country = new Country();

    public static List<Country> readFile(String nameFile) {
        File file = new File(nameFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] arr = readLine.split(",");
                int id = Integer.parseInt(arr[0]);
                String code = arr[1];
                String nameCountry = arr[2];
                country = new Country(id, code, nameCountry);
                countryList.add(country);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countryList;
    }
}
