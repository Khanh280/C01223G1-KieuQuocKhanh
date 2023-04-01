package case_study_furama.utils;

import case_study_furama.models.Contract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteDataContracts {
    private static final String CONTRACTS_LIST_PATH = "src\\case_study_furama\\data\\contract.csv";

    public static void writeListToFile(List<Contract> contractList, boolean append) {
        File file = new File(CONTRACTS_LIST_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < contractList.size(); i++) {
                bufferedWriter.write(contractList.get(i).getInfoToCsv());
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

    public static List<Contract> readFileToList() {
        List<Contract> contractList = new ArrayList<>();
        File file = new File(CONTRACTS_LIST_PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] elementContracts = readLine.split(",");
                String contractNumber = elementContracts[0];
                String bookingHorse = elementContracts[1];
                String predepositAmount = elementContracts[2];
                String sumMoneyPay = elementContracts[3];
                String guestHorse = elementContracts[4];
                Contract contract = new Contract(contractNumber, bookingHorse, predepositAmount, sumMoneyPay, guestHorse);
                contractList.add(contract);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return contractList;
    }

}
