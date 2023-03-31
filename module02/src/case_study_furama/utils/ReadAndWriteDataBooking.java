package case_study_furama.utils;

import case_study_furama.models.Booking;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class ReadAndWriteDataBooking {
    private static final String BOOKING_LIST_PATH = "src\\case_study_furama\\data\\booking.csv";

    public static void writeSetToFile(Set<Booking> bookingSet) {
        File file = new File(BOOKING_LIST_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking b : bookingSet) {
                bufferedWriter.write(b.getInfoToCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Set<Booking> readFileToSet() {
        Set<Booking> bookingList = new TreeSet<>();
        File file = new File(BOOKING_LIST_PATH);
        FileReader fileReader=null;
        BufferedReader bufferedReader = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine= bufferedReader.readLine())!=null){
                String[] elementBooking = readLine.split(",");
                String guestHorse = elementBooking[0];
                String serviceName = elementBooking[1];
                String serviceType = elementBooking[2];
                String bookingHorse = elementBooking[3];
                String startDate = elementBooking[4];
                String endtDate = elementBooking[5];
                Booking booking = new Booking(guestHorse,serviceName,serviceType,bookingHorse,startDate,endtDate);
                bookingList.add(booking);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bookingList;
    }
}
