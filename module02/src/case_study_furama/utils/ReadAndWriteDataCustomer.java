package case_study_furama.utils;

import case_study_furama.models.person.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteDataCustomer {
    private static final String CUSTOMER_LIST_PATH = "src\\case_study_furama\\data\\customer.csv";
    public  static  void writeCustomerToFile(List<Customer> customers, boolean append){
        File file = new File(CUSTOMER_LIST_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < customers.size(); i++) {
                bufferedWriter.write(customers.get(i).getInfoToCsv());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static LinkedList<Customer> readFileToList(){
        LinkedList<Customer> customers = new LinkedList<>();
        File file = new File(CUSTOMER_LIST_PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine=bufferedReader.readLine()) != null){
                String[] elementCustomer = readLine.split(",");
                String horse = elementCustomer[0];
                String name = elementCustomer[1];
                String birthDay = elementCustomer[2];
                String gender = elementCustomer[3];
                String id = elementCustomer[4];
                String phoneNumber = elementCustomer[5];
                String email = elementCustomer[6];
                String guestType = elementCustomer[7];
                String address = elementCustomer[8];
                Customer customer = new Customer(horse,name,birthDay,gender,id,phoneNumber,email,guestType,address);
                customers.add(customer);
            }
            bufferedReader.close();
            fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return customers;
    }
}
