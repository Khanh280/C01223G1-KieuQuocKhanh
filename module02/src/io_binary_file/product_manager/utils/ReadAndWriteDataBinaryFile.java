package io_binary_file.product_manager.utils;

import io_binary_file.product_manager.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteDataBinaryFile {
    private static final String PRODUCT_LIST_PATH = "src\\io_binary_file\\product_manager\\data\\product_list.dat";

    public static void writeProductToFile(List<Product> productList, boolean append) {
        File file = new File(PRODUCT_LIST_PATH);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file,append);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readFileToList() {
        List<Product> productList = new ArrayList<>();
        File file = new File(PRODUCT_LIST_PATH);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            if (file.length() > 0) {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                productList = (List<Product>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
