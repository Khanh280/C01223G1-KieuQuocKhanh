package case_study_furama.utils;

import case_study_furama.models.facility.Facility;
import case_study_furama.models.facility.House;
import case_study_furama.models.facility.Room;
import case_study_furama.models.facility.Villa;

import java.io.*;
import java.util.*;

public class ReadAndWriteDataFacility {
    private static final String FACILITY_LIST_PATH = "src\\case_study_furama\\data\\facility.csv";
    static Map<Facility, Integer> mapFacility = new LinkedHashMap<>();

    public static void writeFacilityToList(Map<Facility, Integer> facilityIntegerMap, boolean append) {
        File file = new File(FACILITY_LIST_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Facility> set = facilityIntegerMap.keySet();
            for (Facility s : set) {
                if (s instanceof Villa) {
                    bufferedWriter.write(s.getInfoToCSV() + "," + facilityIntegerMap.get(s));
                    bufferedWriter.newLine();
                } else if (s instanceof Room) {
                    bufferedWriter.write(s.getInfoToCSV() + "," + facilityIntegerMap.get(s));
                    bufferedWriter.newLine();
                } else if (s instanceof House) {
                    bufferedWriter.write(s.getInfoToCSV() + "," + facilityIntegerMap.get(s));
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Map<Facility, Integer> readFileToMap() {
        Map<Facility, Integer> mapFacility = new LinkedHashMap<>();
        Map<Facility, Integer> mapA = new LinkedHashMap<>();
        File file = new File(FACILITY_LIST_PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] elementFacility = readLine.split(",");
                Map<Facility, Integer> facility = checkTypeFacility(elementFacility);
                Set<Map.Entry<Facility, Integer>> entry = facility.entrySet();
                for (Map.Entry<Facility, Integer> e : entry) {
                    mapA.put(e.getKey(), e.getValue());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(bufferedReader != null){
                    bufferedReader.close();
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        List<Facility> facilities = new ArrayList<>(mapA.keySet());
        facilities.sort(new SortMapFacilityByName());
        for (Facility f:facilities) {
            mapFacility.put(f,mapA.get(f));
        }
        return mapFacility;
    }

    public static Map<Facility, Integer> checkTypeFacility(String[] elementFacility) {
        Map<Facility, Integer> mapFacility = new LinkedHashMap<>();
        String serviceName;
        String areaUsed;
        String rentalCost;
        String maximumPeople;
        String rentalType;
        String roomStandards;
        String numberFloors;
        int numberOfUses;
        switch (elementFacility.length) {
            case 7:
                serviceName = elementFacility[0];
                areaUsed = elementFacility[1];
                rentalCost = elementFacility[2];
                maximumPeople = elementFacility[3];
                rentalType = elementFacility[4];
                String freeService = elementFacility[5];
                numberOfUses = Integer.parseInt(elementFacility[6]);
                Facility room = new Room(serviceName, areaUsed, rentalCost, maximumPeople, rentalType, freeService);
                mapFacility.put(room, numberOfUses);
                break;
            case 8:
                serviceName = elementFacility[0];
                areaUsed = elementFacility[1];
                rentalCost = elementFacility[2];
                maximumPeople = elementFacility[3];
                rentalType = elementFacility[4];
                roomStandards = elementFacility[5];
                numberFloors = elementFacility[6];
                numberOfUses = Integer.parseInt(elementFacility[7]);
                Facility house = new House(serviceName, areaUsed, rentalCost, maximumPeople, rentalType, roomStandards, numberFloors);
                mapFacility.put(house, numberOfUses);
                break;
            case 9:
                serviceName = elementFacility[0];
                areaUsed = elementFacility[1];
                rentalCost = elementFacility[2];
                maximumPeople = elementFacility[3];
                rentalType = elementFacility[4];
                roomStandards = elementFacility[5];
                String poolArea = elementFacility[6];
                numberFloors = elementFacility[7];
                numberOfUses = Integer.parseInt(elementFacility[8]);
                Facility villa = new Villa(serviceName, areaUsed, rentalCost, maximumPeople, rentalType, roomStandards, poolArea, numberFloors);
                mapFacility.put(villa, numberOfUses);
                break;
        }
        return mapFacility;
    }
}
