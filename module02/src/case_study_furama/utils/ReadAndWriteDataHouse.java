package case_study_furama.utils;

import case_study_furama.models.facility.House;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteDataHouse {
    private static final String HOUSE_LIST_PATH = "src\\case_study_furama\\data\\house.csv";

    public static void writeHouseToFile(List<House> houses, boolean append) {
        File file = new File(HOUSE_LIST_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < houses.size(); i++) {
                bufferedWriter.write(houses.get(i).getInfoToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<House> readFileToList() {
        List<House> houses = new ArrayList<>();
        File file = new File(HOUSE_LIST_PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] elementHouse = readLine.split(",");
                String servicename = elementHouse[0];
                double areaUsed = Double.parseDouble(elementHouse[1]);
                int rentalCost = Integer.parseInt(elementHouse[2]);
                int maximumPeople = Integer.parseInt(elementHouse[3]);
                String rentalType = elementHouse[4];
                String roomStandards = elementHouse[5];
                int numberFloors = Integer.parseInt(elementHouse[6]);
                House house = new House(servicename, areaUsed, rentalCost, maximumPeople, rentalType, roomStandards, numberFloors);
                houses.add(house);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houses;
    }
}
