package case_study_furama.utils;

import case_study_furama.models.facility.Villa;


import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteDataVilla {
    private static final String VILLA_LIST_PATH = "src\\case_study_furama\\data\\villa.csv";

    public static void writeVillaToFile(List<Villa> villas, boolean append){
        File file = new File(VILLA_LIST_PATH);
        FileWriter fileWriter= null;
        BufferedWriter bufferedWriter = null;
        try{
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < villas.size() ; i++) {
                bufferedWriter.write(villas.get(i).getInfoToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Villa> readFileToList(){
        List<Villa> villas = new ArrayList<>();
        File file = new File(VILLA_LIST_PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null){
                String[] elementVilla = readLine.split(",");
                String serviceName = elementVilla[0];
                double areaUsed = Double.parseDouble(elementVilla[1]);
                int rentalCost = Integer.parseInt(elementVilla[2]);
                int maximumPeople = Integer.parseInt(elementVilla[3]);
                String rentalType = elementVilla[4];
                String roomStandards = elementVilla[5];
                double poolArea = Double.parseDouble(elementVilla[6]);
                int numberFloors = Integer.parseInt(elementVilla[7]);
                Villa villa = new Villa(serviceName,areaUsed,rentalCost,maximumPeople,rentalType,roomStandards,poolArea,numberFloors);
                villas.add(villa);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return villas;
    }
}
