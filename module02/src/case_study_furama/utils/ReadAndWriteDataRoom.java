package case_study_furama.utils;

import case_study_furama.models.facility.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteDataRoom {
    private static final String ROOM_LIST_PATH = "src\\case_study_furama\\data\\room.csv";

    public static void writeRoomToFile(List<Room> roomList, boolean append){
        File file = new File(ROOM_LIST_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < roomList.size(); i++) {
                bufferedWriter.write(roomList.get(i).getInfoToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch( IOException e){
            e.printStackTrace();
        }
    }

    public static List<Room> readFileToList(){
        List<Room> rooms = new ArrayList<>();
        File file = new File(ROOM_LIST_PATH);
        FileReader fileReader= null;
        BufferedReader bufferedReader = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine= null;
            while ((readLine = bufferedReader.readLine()) != null){
                String[] elementRoom = readLine.split(",");
                String serviceName = elementRoom[0];
                double areaUsed = Double.parseDouble(elementRoom[1]);
                int rentalCost = Integer.parseInt(elementRoom[2]);
                int maximunPeople = Integer.parseInt(elementRoom[3]);
                String rentalType = elementRoom[4];
                String freeService = elementRoom[5];
                Room room = new Room(serviceName,areaUsed,rentalCost,maximunPeople,rentalType,freeService);
                rooms.add(room);
            }
            bufferedReader.close();
            fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return rooms;
    }
}