package case_study_furama.utils;

import case_study_furama.models.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteDataEmployee {
    private static final String EMPLOYEE_LIST_PATH = "src\\case_study_furama\\data\\employee.csv ";

    public static void writeEmployeeToFile(List<Employee> employees, boolean append) {
        File file = new File(EMPLOYEE_LIST_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < employees.size(); i++) {
                bufferedWriter.write(employees.get(i).getInfoToCsv());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readFileToList() {
        List<Employee> employees = new ArrayList<>();
        File file = new File(EMPLOYEE_LIST_PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] elementEmployee = readLine.split(",");
                String horse = elementEmployee[0];
                String name = elementEmployee[1];
                String birthDay = elementEmployee[2];
                String gender = elementEmployee[3];
                String id = elementEmployee[4];
                String phoneNumber = elementEmployee[5];
                String email = elementEmployee[6];
                String degree = elementEmployee[7];
                String location = elementEmployee[8];
                String salary = String.valueOf(Long.parseLong(elementEmployee[9]));
                Employee employee = new Employee(horse, name, birthDay, gender, id, phoneNumber, email, degree, location, salary);
                employees.add(employee);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
